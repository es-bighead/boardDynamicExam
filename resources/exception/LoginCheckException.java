package exception;

public class LoginCheckException extends Exception{
	
	public LoginCheckException() {
		super("아이디 또는 패스워드가 일치하지 않습니다.");
	}

}
