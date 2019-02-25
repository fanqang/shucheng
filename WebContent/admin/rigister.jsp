<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
	<link rel="stylesheet" href="../css/styles.css" />
   	<link rel="stylesheet" href="../css/demo.css" />
    <link rel="shortcut icon" href="/bookshop/img/favicon.png">
</head>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	.errormessage{
		width: 260px;
		height: 120px;
		margin: auto;
		background-color: #FFFFFF;
		position: fixed;
		left: 50%;
		margin-left: -130px;
	}
	.errormessage .Tips{
		height: 40px;
		background-color: #F8F8F8;
	}
	.errormessage .Tips span{
		color: #333333;
		font-family: "微软雅黑";
		font-size: 14px;
		line-height: 40px;
		position: relative;
		left: 20px;
	}
	.errormessage .message{
		height: 80px;
	}
	.errormessage .message .son{
		height: 70px;
		line-height: 70px;
		float: left;
	}
	.errormessage .message .son:nth-child(1){
		width: 40px;
		line-height: 70px;
		position: relative;
		left: 20px;
	}
	.errormessage .message .son:nth-child(1) img{
		margin-top: 20px;
	}
	.errormessage .message .son:nth-child(2){
		width: 170px;
		color: #333333;
		font-family: "微软雅黑";
		font-size: 14px;
		position: relative;
		left: 25px;
	}
</style>
<body>
<div class='login'>
	  <div class='login_title'>
	    <span>游客注册</span>
	  </div>
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='../img/user_icon_copy.png'>
	      </div>
	      <input name="login" placeholder='用户名' maxlength="16" type='text' autocomplete="off" id="user_name" value="小范"/>
	        <div class='validation'>
	        </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='../img/lock_icon_copy.png'>
	      </div>
	      <input name="pwd" placeholder='密码' maxlength="16" type='text' autocomplete="off" id="user_pwd" value="123456">
	      <div class='validation'>
	      </div>
	    </div>
	     <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='../img/lock_icon_copy.png'>
	      </div>
	      <input name="re_pwd" placeholder='再次输入密码' maxlength="16" type='text' autocomplete="off" id="re_pwd">
	      <div class='validation'>
	      </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='../img/key.png'>
	      </div>
	      <input name="code" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off" id="code">
	      <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
	      <canvas class="J_codeimg" id="myCanvas" onclick="Code();"></canvas>
	      </div>
	    </div>
	    <div class='login_fields__submit'>
	      <input type='button' value='注册' id="login" onclick="login()" style="position: relative;left: 13px;">
	    </div>
	  </div>
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p>欢迎登陆网上书城系统</p>
	  </div>
	</div>
	<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
   	<script type="text/javascript" src="../js/Particleground.js" ></script>
    <script type="text/javascript" src="../js/Treatment.js" ></script>
   	<script type="text/javascript" src="../js/messageBox.js" ></script>
   	<script type="text/javascript">
		var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持
		Code();
	    function Code() {
			if(canGetCookie == 1){
				createCode("AdminCode");
				var AdminCode = getCookieValue("AdminCode");
				showCheck(AdminCode);
			}else{
				showCheck(createCode(""));
			}
	    }
	    function showCheck(a) {
			CodeVal = a;
	        var c = document.getElementById("myCanvas");
	        var ctx = c.getContext("2d");
	        ctx.clearRect(0, 0, 1000, 1000);
	        ctx.font = "80px 'Hiragino Sans GB'";
	        ctx.fillStyle = "#E8DFE8";
	        ctx.fillText(a, 0, 100);
	    }
	    //粒子背景特效
	    $('body').particleground({
	        dotColor: '#E8DFE8',
	        lineColor: '#133b88'
	    });
	     $('input[name="pwd"]').focus(function () {
	        $(this).attr('type', 'password');
	    });
	    $('input[type="text"]').focus(function () {
	        $(this).prev().animate({ 'opacity': '1' }, 200);
	    });
	    $('input[type="text"],input[type="password"]').blur(function () {
	        $(this).prev().animate({ 'opacity': '.5' }, 200);
	    });
	    $('input[name="login"],input[name="pwd"]').keyup(function () {
	        var Len = $(this).val().length;
	        if (!$(this).val() == '' && Len >= 5) {
	            $(this).next().animate({
	                'opacity': '1',
	                'right': '30'
	            }, 200);
	        } else {
	            $(this).next().animate({
	                'opacity': '0',
	                'right': '20'
	            }, 200);
	        }
	    });
	    //下面是注册验证
	    function login(){
	     	var user_name = $("#user_name").val();
	     	var user_pwd = $("#user_pwd").val();
	     	var re_pwd = $("#re_pwd").val();
	     	var code = $("#code").val();
	     	var message = $("#message").text();
	     	console.log(message);
	     	console.log(CodeVal);
	     	console.log(code);
	     	if(user_name == ''){
	     		Message("请输入账号");
	     	}else if(user_pwd == ''){
	     		Message("请输入密码");
	     		
	     	}else if(re_pwd == ''){
	     		Message("请再次输入密码");
	     	}else if(user_pwd != re_pwd){
	     		Message("两次输入的密码不一致");
	     	}
	     	else if(code == ''){
	     		Message("请输入验证码");
	     		
	     	}else if(code != CodeVal){
	     		Message("验证码输入不正确");
	     		
	     	}else{
	     		$.post("/bookshop/registerUser",{"user_name":user_name,"user_pwd":user_pwd},function(res){
	     			if(res.message == "注册成功"){
				     	var flag = confirm("注册成功,立即登录");
				     	if(flag){
				     		window.location = "../admin/login.jsp";
				     		}
				     	}else if(res.message == "error"){
				     	Message("注册失败");
				     	}else if(res.message == "该用户已被注册"){
				        Message("该用户已被注册");
				     	}
	     		});
	     	}
	    }
	</script>
</body>
</html>