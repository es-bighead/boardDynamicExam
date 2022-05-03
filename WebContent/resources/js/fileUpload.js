/**
 * 이미지 파일 업로드
 */

 document.querySelector('div #inputFile').addEventListener('change', function(event){
	 //파일 업로드 초기화
	document.querySelector("input[name=checkUpload]").value = 0;

	//이미지 확장자 Validation을 위한 (대문자로 변경)
	var fileFormat = this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	
	//이미지 확장자 jpg 확인
	if(fileFormat != "JPG"){
		alert("이미지는 jpg 형식만 가능합니다.");
		return false;
	};
	
	//이미지 파일 용량 체크
	if(this.files[0].size > 1024 * 1024 * 1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return false;
	};
	
	//Real FIle Name 담기
	document.getElementById('inputFileName').value = this.files[0].name;
	
	if(this.files && this.files[0]){
		
		var reader = new FileReader();
		
		reader.onload = function (e){
			
			//이미지 미리보기
			var divPicture = document.querySelector('div #pictureView');
			divPicture.style.backgroundImage = 'url(' + e.target.result + ')';
			divPicture.style.backgroundPosition = 'center';
			divPicture.style.backgroundSize = 'cover';
			divPicture.style.backgroundRepeat = 'no-repeat';
		}
		
		reader.readAsDataURL(this.files[0]);
	}

});

function upload_go(){
	
	var imageForm = document.getElementById("imageForm");
	
	//form 태그 양식을 객체화
	var form = new FormData(imageForm);
	
	if(imageForm.pictureFile.value == ""){
		alert("사진을 선택하세요.");
		document.querySelector("input[name=pictureFile]").click();
		return false;		
	}
	
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.onreadystatechange = function(e){
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
		      if (httpRequest.status === 200) {
		    	  if(httpRequest.response != "NO"){
		    		  document.querySelector('input[name=oldPicture]').value = httpRequest.response;
		    		  document.querySelector("input[name=picture]").value = httpRequest.response;
		    		  document.querySelector("input[name=checkUpload]").value = 1;
		    		  alert("사진을 업로드 했습니다");
			    	}else{
			    		alert("파일 업로드를 실패했습니다.");	
			    	}
		      }else{
		    	  alert("파일 업로드를 실패했습니다.");
		      }
		}
	}
	
	httpRequest.open("POST", "/pictureUpload.do");
	
	httpRequest.send(form);
}