<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
	   String bookISBN = request.getParameter("bookISBN");
	   String username = (String)session.getAttribute("success");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="shortcut icon" href="/bookshop/img/favicon.png">
<link rel="stylesheet" href="../css/messagebox.css" />
<script type="text/javascript" src="../js/messageBox.js" ></script>
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<script type="text/javascript"></script>
<title>显示图书</title>
<style type="text/css">
	.*{
		margin: 0;
		padding: 0;
	}
	body{
		background: #F4F5F7;
	}
	.div_top{
		width: 1000px;
		height: 350px;
		margin: 0 auto;
		margin-top: 10px;
		border-radius: 10px;
		background: white;		
	}
	.div_top .top{
		width: 1000px;
		height: 60px;
		line-height: 60px;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		margin-left: 10px;
		font-weight: bold;
		font-family: "微软雅黑";
		font-size: 22px;
		color: black;
	}
	.bootom{
		width: 1000px;
		height: 270px;
		margin: 10px 0 10px 10px;
	}
	.div_top .left{
		width: 200px;
		height: 270px;
		border: 0;
		float: left;
	}
	.div_top .left img{
		width: 200px;
		height: 270px;
	}
	.div_top .right{
		width: 712px;
		height: 270px;
		float: right;
	}
	.div_top .right .right_a{
		margin-left: 150px;
		margin-top: 20px;
		color: #555758;
		font-weight: bold;
		font-family: "微软雅黑";
	}
	.div_top .right .right_a span{
		color: #555758;
		font-weight: bold;
		font-family: "微软雅黑";
	}
	.button_number_box{
		width: 150px;
		height: 30px;
		margin-left: 150px;
		margin-top: 15px;
	}
	.cha{
		width: 45px;
		height: 25px;
		margin-top: 2.5px;
		background: white;
		border: 1px solid #ccc;
		font-weight: bold;
		font-size: 15px;
		cursor: pointer;
		float: left;
	}
	.cha:hover{
		background: pink;
		outline: none;
	}
	.number{
		width: 45px;
		height: 23px;
		line-height: 23px;
		margin-top: 2.5px;
		background: white;
		border: 1px solid #ccc;
		border-left: 0;
		border-right: 0;
		float: left;
		text-align: center;
	}
	.he{
		width: 45px;
		height: 25px;
		margin-top: 2.5px;
		background: white;
		border: 1px solid #ccc;
		font-weight: bold;
		font-size: 15px;
		cursor: pointer;
		float: left;
	}
	.he:hover{
		background: pink;
		outline: none;
	}
	.add_shopping_car{
		width: 135px !important;
		height: 30px !important;
		margin-left: 150px !important;
		margin-top: 15px !important;
		border: 1px solid #EC5851 !important;
		background: white !important;
		color: #EC5851 !important;
	} 
	.div_center{
		width: 1000px;
		height: 180px;
		margin: 0 auto;
		margin-top: 10px;
		border-radius: 10px;
		background: white;
	}
	.div_center_top{
		width: 1000px;
		height: 60px;
		line-height: 60px;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		margin-left: 10px;
		font-weight: bold;
		font-family: "微软雅黑";
		font-size: 22px;
		color: black;
	}
	.div_center_bootom{
		width: 1000px;
		height: 100px;
		margin: 0 0 10px 0;
	}
	.div_center_bootom textarea{
		width: 992px;
		height: 100px;
		margin-left: 10px;
		border: 0;
		resize: none;
		font-size: 15px;
		color: #565656;
		font-family: "微软雅黑";
		overflow: hidden;
	}
	.div_center_bootom textarea:focus{
		outline: none;
	}
	.div_bottom{
		width: 1000px;
		height: 180px;
		margin: 0 auto;
		margin-top: 10px;
		border-radius: 10px;
		background: white;
	}
	.div_bottom_top{
		width:1000px;
		height: 60px;
		line-height: 60px;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		margin-left: 10px;
		font-weight: bold;
		font-family: "微软雅黑";
		font-size: 22px;
		color: black;
	}
	.div_bottom_bottom{
		width: 1000px;
		min-height: 100px;
		margin: 0 0 10px 0;
		font-family: "微软雅黑";
		font-size: 18px;
		margin-left: 10px;
	}
	.footer{
		width: 100%;
		height: 170px;
		background-color: #373d41;
		bottom: 0;
		margin-top: 10px;
	}
</style>
</head>
<body>
	<div class="div_top" id="div_top">
		<div class="top" id="top"></div>
		<div class="bootom">
			<div class="left"><img id="img"/></div>
			<div class="right">
				<div class="right_a">ISBN <span id="ISBN"></span></div>
				<div class="right_a">作者 <span id="author"></span></div>
				<div class="right_a">出版社 <span id="publish"></span></div>
				<div class="right_a" style="color: #EA5151;">￥<span style="color: #EA5151;" id="price"></span></div>
				<div class="button_number_box">
					<button class="cha" onclick="cha()">-</button>
					<div class="number" id="number">1</div>
					<button class="he" onclick="he()">+</button>
				</div>
				<button class="add_shopping_car" onclick="shopping_car()">加入购物车</button>
			</div>
		</div>
	</div>
	<div class="div_center">
		<div class="div_center_top">说明</div>
		<div class="div_center_bootom"><textarea readonly id="textarea"></textarea></div>
	</div>
	<div class="div_bottom">
		<div class="div_bottom_top">评价</div>
		<div class="div_bottom_bottom" id="book_pj"><!--<div class="bottom_nav"><div class="bottom_nav_son"></div><div class="bottom_nav_son"></div><div class="bottom_nav_son"></div></div>--></div>
	</div>
	<%@ include file="footer/footer.jsp"%>
	<script>
		window.$number = parseInt($("#number").text());
		window.$bookISBN = "<%=bookISBN%>";
		$(function(){
			var username="<%=username%>";
			if(username != "null"){
				$("#nav_login_img").show();
				$("#nav_login_message").show();
			}
			$.post("/bookshop/showbook",{"bookISBN":window.$bookISBN},function(res){
							 var $bookList = res.booklist[0];
							 $("#top").html($bookList.bk.bookName);
							 $("#img").attr("src","/bookshop/img/bookPic/"+$bookList.bk.bookISBN+$bookList.bk.bookPic);
							 $("#ISBN").text($bookList.bk.bookISBN);
							 $("#author").text($bookList.bk.bookAuthor);
							 $("#publish").text($bookList.bk.bookPublish);
							 $("#price").text($bookList.bk.bookPrice);
							 $("#textarea").val($bookList.bk.bookAbstract);
							 var str = "";
						 		console.log(res.booklist[0].bookEvaluate.length);
						 		if(res.booklist[0].bookEvaluate == ""){
						 			str = "暂无评价";
						 		}else{
						 			str = res.booklist[0].bookEvaluate.join("<br/>");
						 		}
							 $("#book_pj").html(str);
						},"json");
		})
		//按钮差方法
		function cha(){
			if(window.$number == 1){
				$("#number").html(window.$number = 1);
			}else{
				$("#number").html(--window.$number);
			}
		}
		//按钮和方法
		function he(){
			if(window.$number <= 99){
				$("#number").html(++window.$number);
			}else{
				$("#number").html(window.$number = 99);
			}
		}
		//创建购物车的方法
		function shopping_car(){
			var username = "<%=username%>";
			//如果当前页面获取的用户名为空的话则跳转登录页面，否则则创建购物车
				if(username == "null"){
					messageBox("提示","当前未登录,请单击确定按钮跳转到登录页面进行登录",function(){
						window.location.href = "login.jsp";
					});
				}else{
					messageBox("提示","添加购物车成功！",function(){
					$.post("/bookshop/AddShoppingCar",{"bookISBN":window.$bookISBN,"number":window.$number},function(res){
						console.log(res.message);
					})
				});
				}
			}
		
	</script>
</body>
</html>