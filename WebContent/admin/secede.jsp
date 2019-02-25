<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
	String username = (String)session.getAttribute("success"); //获取用户登录存入session内的登录名
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出书城系统</title>
<link rel="stylesheet" href="../css/messagebox.css" />
<link rel="stylesheet" href="../css/nav.css" />
<link rel="shortcut icon" href="/bookshop/img/favicon.png">
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<script type="text/javascript" src="../js/messageBox.js" ></script>
</head>
<body>
	<script>
		$(function(){
			var username = "<%=username%>";
			if(username == "null"){ //如果登录名为空则跳转登录页面 反之则销毁登录名的session在跳转登录页面
					messageBox("提示","您当前还未登录，请登录！",function(){
						window.location.href = "login.jsp";
					})
				}
			else{
				$.post("/bookshop/SecedeLogin",{},function(res){
				console.log(res.message);
				if(res.message == "ok"){
					messageBox("提示","退出系统成功！",function(){
						window.location.href = "login.jsp";
					})
				}
			});
			}
			
		})
	</script>
</body>
</html>