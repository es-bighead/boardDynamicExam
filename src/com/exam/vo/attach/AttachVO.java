package com.exam.vo.attach;

public class AttachVO {
	
	private String attach_id;
	private String board_no;
	private String real_file_name;
	private String real_file_path;
	private String file_ext;
	private String file_name;
	private String file_path;
	private String reg_dt;
	private String mod_dt;
	private String del_yn;
	
	public String getAttach_id() {
		return attach_id;
	}
	public void setAttach_id(String attach_id) {
		this.attach_id = attach_id;
	}
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getReal_file_name() {
		return real_file_name;
	}
	public void setReal_file_name(String real_file_name) {
		this.real_file_name = real_file_name;
	}
	public String getReal_file_path() {
		return real_file_path;
	}
	public void setReal_file_path(String real_file_path) {
		this.real_file_path = real_file_path;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
	@Override
	public String toString() {
		return "AttachVO [attach_id=" + attach_id + ", board_no=" + board_no + ", real_file_name=" + real_file_name
				+ ", real_file_path=" + real_file_path + ", file_ext=" + file_ext + ", file_name=" + file_name
				+ ", file_path=" + file_path + ", reg_dt=" + reg_dt + ", mod_dt=" + mod_dt + ", del_yn=" + del_yn + "]";
	}
	
}
