<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>
	<title>회원가입</title>
</head>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function fn_addr(){
		document.getElementById("addr").value = "";
		
	 	new daum.Postcode({
	 		autoClose: true,
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("addr").value = addr;
            }
        }).open();
	}
	
	function fn_emailEnd(){
		var email = document.getElementById("email").value;
		var end = document.getElementById("emailEnd").value;
		
		if(end != ""){
			if(email == ""){
				alert("이메일을 먼저 입력하세요.");
			}else{
				document.getElementById("email").value = email.split("@")[0] + "@" + end;
			}			
		}
	}
	
	function isSame() {
		var pwd1 = document.getElementById('pwd').value;
		var pwd2 = document.getElementById('pwd2').value;
		
	    if(pwd1 !='' && pwd2 !='') {
	        if(pwd1 == pwd2) {
	            document.getElementById('same').innerHTML='일치';
	            document.getElementById('same').style.color='blue';
	        }else {
	            document.getElementById('same').innerHTML='불일치';
	            document.getElementById('same').style.color='red';
	        }
	    }
	    
	}
	
	function fn_submit(){
		var id = document.getElementById("id").value;
		var idChk = document.getElementById("sameId").innerText;
		var name = document.getElementById("name").value;
		var cel1 = document.getElementById("cel1").value;
		var cel2 = document.getElementById("cel2").value;
		var cel3 = document.getElementById("cel3").value;
		document.getElementById("cel").value = cel1 + (cel1 == "" ? "" : "-" + cel2) + (cel2 == "" ? "" : "-" + cel3);
		var cel = document.getElementById("cel").value;;
		var email = document.getElementById("email").value;
		var addr = document.getElementById("addr").value;
		var pwd = document.getElementById('same').innerText;
		
		if(id == ""){
			alert("아이디를 입력하세요.");
			document.getElementById("id").focus();
			return false;
		}
		
		if(name == ""){
			alert("이름을 입력하세요.");
			document.getElementById("name").focus();
			return false;
		}
		
		if(cel == "" || (cel1 == "" || cel2 == "" || cel3 == "")){
			alert("연락처를 입력하세요.");
			document.getElementById("cel1").focus();
			return false;
		}
		
		if(email == ""){
			alert("이메일을 입력하세요.");
			document.getElementById("email").focus();
			return false;
		}
		
		if(addr == ""){
			alert("주소를 입력하세요.");
			document.getElementById("addr").focus();
			return false;
		}
		
		if(idChk == ""){
			alert("아이디 중복검사 후 진행이 가능합니다.");
			document.getElementById("id").focus();
			return false;
		}
		
		if(idChk == "NO"){
			alert("중복된 아이디는 사용이 불가능합니다.");
			document.getElementById("id").focus();
			return false;
		}
		
		if(pwd == "불일치" || pwd == ""){
			alert("패스워드를 확인하세요.");
			document.getElementById("pwd2").focus();
			return false;
		}
		
		document.signForm.submit();
		
	}
</script>

<div class="docSlider">
    <section class="section1">
        <div class="inner">
            <form class="signBox" action="<%=request.getContextPath()%>/acount.do" method="post" name="signForm">
                <h1>회원가입</h1>
                <fieldset>
                    <table class="sign_table">
				      <tr>
				        <th>ID</th>
				        <td>
				        	<input id="id" name="id" type="text">
				            <input id="idChk" type="button" value="중복확인">&nbsp;&nbsp;<span id="sameId"></span>
				        </td>
				      </tr>
				      <tr>
				        <th>비 번</th>
				        <td>
				        	<input id="pwd" name="pwd" type="password" onkeyup="isSame();" /> 
				        </td>
				      </tr>
				      <tr>
				        <th>비번확인</th>
				        <td>
				        	<input id="pwd2" name="pwd2" type="password" onkeyup="isSame();"> &nbsp;&nbsp;<span id="same"></span>
				        </td>
				      </tr>
				      <tr>
				        <th>이 름</th>
				        <td>
				        	<input id="name" name="name" type="text"> 
				        </td>
				      </tr>
				      <tr>
				        <th>전화번호</th>
				        <td>
				        	<input id="cel" name="cel" type="hidden" value="" />
				        	<input id="cel1" name="cel1" list="startNum" type="text" size="3"/>
				        	<datalist id="startNum">
							  <option value="010" label="010" />
							  <option value="011" label="011" />
							  <option value="016" label="016" />
							</datalist> -
				            <input id="cel2" name="cel2" type="text" size="4"> -
				            <input id="cel3" name="cel3" type="text" size="4">
				        </td>
				      </tr>
				      <tr>
				        <th>이 메 일</th>
				        <td>
				        	<input id="email" name="email" type="text" value=""/>
				        	<select id="emailEnd" onchange="fn_emailEnd();">
				        		<option value="">직접입력</option>
				        		<option value="naver.com">naver.com</option>
				        		<option value="daum.net">daum.net</option>
				        		<option value="google.com">google.com</option>
				        	</select>
				         </td>
				      </tr>
				      <tr>
				        <th>주 소</th>
				        <td>
				        	<input id="addr" name="addr" type="text">
				        	<input type="button" value="주소검색" onclick="fn_addr();"/>
				        </td>
				      </tr>
				      <tr align="center">
				        <th colspan="2">
				           <button class="sig_btn" type="button" onclick="fn_submit();"></button>
				           <button class="can_btn" type="button" onclick="javascript:history.go(-1)"></button>
				        </th>       
				      </tr>
				   </table>
                </fieldset>
            </form>
        </div>
    </section>
</div>

<script type="text/javascript">
var httpRequest;
/* button이 클릭되었을때 이벤트 */
const idchk = document.querySelector('#idChk');
 
idchk.addEventListener('click', function(event){
	/* textBox에 작성된 id 데이터를 가져옴 */
	var id = document.getElementById("id").value;
	/* 통신에 사용 될 XMLHttpRequest 객체 정의 */
	httpRequest = new XMLHttpRequest();
	/* httpRequest의 readyState가 변화했을때 함수 실행 */
    httpRequest.onreadystatechange = function(e){
    	/* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 name과 age를 그려줌 */
	    if (httpRequest.readyState === XMLHttpRequest.DONE) {
		      if (httpRequest.status === 200) {
		    	
		    	if(httpRequest.response == "OK"){
		    		document.getElementById("sameId").innerText = "OK";
			        document.getElementById('sameId').style.color='blue';	
		    	}else{
		    		document.getElementById("sameId").innerText = "NO";
			    	document.getElementById('sameId').style.color='red';	
		    	}
		    	
		      } else {
		    	  alert("중복검사중 에러 발생!!!");
		      }
	    }
    };
    /* Get 방식으로 name 파라미터와 함께 요청 */
    httpRequest.open('GET', '/idDuplicate.do?id=' + id);
    /* 정의된 서버에 요청을 전송 */
    httpRequest.send();
});
</script>

<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>