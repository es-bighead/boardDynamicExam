package com.exam.controller.comm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import util.comm.GetUploadPath;
import util.comm.MakeFileName;

/**
 * Servlet implementation class PictureUploadServlet
 */
@WebServlet("/pictureUpload.do")
public class PictureUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 업로드 파일 환결 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String fileName = null;
		PrintWriter writer = response.getWriter();
		
		try{
			fileName = saveFile(request, response);
			
			System.out.println(fileName);
		}catch(Exception e){
			fileName = "NO";
			e.printStackTrace();
		}
		
		writer.write(fileName);
	}

	private String saveFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new Exception();
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		String uploadPath = GetUploadPath.getUploadPath("memberPictureUpload");
		File file = new File(uploadPath);
		if(!file.mkdirs()){
			System.out.println(uploadPath + "가 이미 존재하거나 실패했습니다.");
		}
		
		List<FileItem> formItems = upload.parseRequest(new ServletRequestContext(request));
		String fileName = null;
		
		if(formItems != null && formItems.size() > 0){
			for(FileItem item : formItems){
				if(!item.isFormField()){
					fileName = MakeFileName.toUUIDFileName(".jpg", "");
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					
					item.write(storeFile);
				}else{
					switch(item.getFieldName()){
						case "oldPicture" :
							String oldFileName = item.getString("utf-8");
							File oldFile = new File(uploadPath + File.separator + oldFileName);
							if(oldFile.exists()){
								oldFile.delete();
							}
							break;
					}
				}
			}
		}
		
		return fileName;
	}

}
