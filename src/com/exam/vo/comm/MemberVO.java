package com.exam.vo.comm;

public class MemberVO {

	int mem_no;
	String lgin_id;
	String pwd;
	String name;
	String cel;
	String email;
	String addr;
	String reg_dt;
	String sec_dt;
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getLgin_id() {
		return lgin_id;
	}
	public void setLgin_id(String lgin_id) {
		this.lgin_id = lgin_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getSec_dt() {
		return sec_dt;
	}
	public void setSec_dt(String sec_dt) {
		this.sec_dt = sec_dt;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_no=" + mem_no + ", lgin_id=" + lgin_id + ", pwd=" + pwd + ", name=" + name + ", cel="
				+ cel + ", email=" + email + ", addr=" + addr + ", reg_dt=" + reg_dt + ", sec_dt=" + sec_dt + "]";
	}
	
}