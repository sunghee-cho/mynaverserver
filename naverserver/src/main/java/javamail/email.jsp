<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>

</head>

<body>
    <div>
        <form action="sendCode" method="get">
            <h2>이메일 인증하기</h2>
                아래 이메일주소를 입력하시면,<br> 입력하신 이메일로 인증코드를 보내드립니다<br>
                <br>
                이메일 입력 :
                <input type="text" name="email" id="email" value="이메일을 입력하세요">
                <input id="submit" type="submit" value="인증번호 전송"/>  
        </form>
     
		<div class="box inputCode" > 
		인증번호 :
			<input id="inputCode" type="text"/> 
			<button id="submitbtn" type="button" >확인</button> 
		</div>
		
		
		<div>
			<a id="join" href="http://localhost:9009/join/join"></a>
		</div>
		
    </div>
    <script>
$(document).ready(function(){
	
//인증번호 전송 클릭시 text 칸에 입력한 이메일 보존
/*     $("#submit").click(function() {
    	var email = ${email};
    	$("#email").val();
    	if(${email} == $("#email").val()){
    	$("input[name=email]").attr("value", email);
    	}
    	else{
    		$("#email").val("이메일을 입력하세요");
    	}
    }); 
*/
    
    
//확인 버튼 클릭시 인증번호 대조 후 일치여부 판단
    $("#submitbtn").click(function() {
    var inputCode = $("#inputCode").val();	
    var joinCode = ${joinCode};
    	if (inputCode == joinCode) {
    		alert("인증번호가 일치합니다");
    		$("#join").get(0).click();
    			
    	} else {
    		alert("인증번호가 일치하지 않습니다");
    	}
    	
    });
});
    </script>
</body>


</html>
