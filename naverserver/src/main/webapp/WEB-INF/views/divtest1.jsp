<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="d"> 프로젝트 </div>
<button id="btn"> 보내기 </button>

<script src="/jquery-3.2.1.min.js"></script>
<script>

$("#btn").on('click', function(){
//현재 클릭한 id 읽어오기(id가 클릭할 때마다 다르므로)
var myid = $(this).attr("id");
//현재 클릭한 태그의 텍스트문자 가져오기
alert( $("#"+myid).text() );



//alert( $("#"+myid+"").val()  )	
var div = document.getElementById("d").innerHTML;
location.href="/divtest2?param="+div;
	
});

</script>

</body>
</html>