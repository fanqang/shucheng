<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/messagebox.css" />
<script type="text/javascript" src="../js/messageBox.js" ></script>
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background-color: #F4F5F7;
	}
	.div_main{
		width: 1000px;
		min-height: 200px;
		margin: 0 auto;
		margin-top: 10px;
		background: #FFFFFF;
		border-radius: 10px;
	}
	.title{
		width: 952px;
		height: 60px;
		font-family: "微软雅黑";
		font-size: 20px;
		font-weight: bold;
		line-height: 60px;
		margin-left: 10px;
		text-shadow: 0 0 0.2em #F87, 0 0 0.2em #F87;
	}
	.message{
		width: 980px;
		padding: 20px 10px 10px 10px;
	}
</style>
<title>未登录</title>
</head>
<body>
	<div class="div_main">
		<div class="title">尚未登录</div>
		<div class="message">您还没有登录，请登录之后在进行操作</div>
	</div>
	<script>
		$(function(){
			messageBox("提示","请单击确定按钮跳转到登录页面进行登录",function(){
						window.location.href = "login.jsp";
					});
		})
	</script>
</body>
</html>