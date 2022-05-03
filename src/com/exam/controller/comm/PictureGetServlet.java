package com.exam.controller.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.comm.GetUploadPath;

/**
 * Servlet implementation class PictureGetServlet
 */
@WebServlet("/pictureGet.do")
public class PictureGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("picture");
		String savePath = GetUploadPath.getUploadPath("memberPictureUpload");
		
		String filePath = savePath+fileName;
		
		sendFile(response, filePath);
	}

	private void sendFile(HttpServletResponse response, String filePath) throws ServletException, IOException {
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		ServletContext context = getServletContext();
		
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null){
			mimeType = "application/octet-stream";
		}
		
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		String headerKey = "Content-Diposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int byteRead = -1;
		
		while((byteRead = inStream.read(buffer)) != -1){
			outStream.write(buffer, 0, byteRead);
		}
		
		if(inStream != null) {
			inStream.close();
		}
		
		if(outStream != null){
			outStream.close();
		}
		
	}

}
