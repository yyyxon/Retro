<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page info="" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.142/mvc_prj/common/main/favicon.png">
<!-- bootstrap CDN-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQuery CDN -->
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/variable/pretendardvariable.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
	.inputBox {
	 border:none;
	  border-bottom: 1px solid #ebebeb;
	  font-size: 15px;
	  line-height: 22px;
	  width: 450px; 
	  height:40px; 
	  outline: none;
	  margin-top: 15px;
	  font-family:pretendard;
	}
	label{font-weight: bold; font-family:Pretendard Variable}
	

a {
  text-decoration: none;
  color: #222222
}
a:hover { color:#222222 }

table, tr, td{
 border:none;
}


</style>
<script type="text/javascript">
$(function(){
   $("#findIdBtn").click(function() {
	   $("#frm").submit();
   })
   
});//ready
</script>
<script type="text/javascript">
    
    // 입력을 제한 할 특수문자의 정규식
    var replaceId  = /[-]/gi;
    
    $(document).ready(function(){
        
        $("#phone").on("focusout", function() {
            var x = $(this).val();
            if (x.length > 0) {
                if (x.match(replaceId)) {
                   x = x.replace(replaceId, "");
                }
                $(this).val(x);
            }
        }).on("keyup", function() {
            $(this).val($(this).val().replace(replaceId, ""));

        });

    });
 
</script>

</head>
 <c:import url="/common/cdn/cdn.jsp" /> 

 <jsp:include page="/common/cdn/header.jsp"/>
 
<body>
<main class="relative flex-grow border-b-2"
		style="min-height: -webkit-fill-available; -webkit-overflow-scrolling: touch">
		<div class="flex mx-auto max-w-[1280px] px-4 md:px-8 2xl:px-16 box-content">
		<c:import url="http://localhost/retro_prj/common/cdn/mypage_sidebar.jsp" />
		<div class="w-full flex-grow">

<div style=" font-size: 35px; font-weight: bold; color: #333333;  margin-top: 30px; margin-bottom:10px ">1:1 문의내용</div>
<hr style="border: solid 2px #000000; margin-top:10px; width: 100%; margin: 0px auto">


            
     


            
           


</table>


</div>
</div>


</main>
 <jsp:include page="/common/cdn/footer.jsp"/> 
</body>
</html>