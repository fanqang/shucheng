<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
	String username = (String)session.getAttribute("success");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="stylesheet" href="../css/messagebox.css" />
<link rel="shortcut icon" href="/bookshop/img/favicon.png">
<script type="text/javascript" src="../js/messageBox.js" ></script>
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<script type="text/javascript"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background: #F4F5F7;
	}
	.mask{
		position: fixed;
		z-index: 199;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.5);
	}
	.div_main{
		width: 1000px;
		min-height: 200px;
		margin: 0 auto;
		margin-top: 10px;
		background: #FFFFFF;
		border-radius: 10px;
	}
	.shopping_car{
		width: 1000px;
		height: 60px;
		font-family: "微软雅黑";
		font-size: 20px;
		font-weight: bold;
		line-height: 60px;
		margin-left: 10px;
		text-shadow: 0 0 0.2em #F87, 0 0 0.2em #F87;
	}
	.div_href{
		width: 320px;
		height: 60px;
		line-height: 60px;
	}
	.checkbox_div{
		width: 980px;
		padding-bottom: 10px;
		padding-left: 10px;
		padding-right: 10px;
	}
	.nav_div{
		width: 980px;
		height: 30px;
		background: #DDDDDD;
		display: none;
	}
	.nav_div ul{
		width: 980px;
		height: 30px;
		list-style: none;
	}
	.nav_div ul li{
		float: left;
		line-height: 30px;
		margin-right: 145px;
		color: #555a5d;
		font-family: "微软雅黑";
		font-weight: bold;
	}
	.nav_div ul li:nth-child(6n){
		margin-right: 0px;
	}
	.shoppingCar{
		width: 980px;
		min-height: 70px;
		background: #F5F5F5;
		border-bottom: 1px solid #DDDDDD;
	}
	.shoppingCar:hover{
		background: #EAEAEA;
	}
	.div1{
		height: 70px;
		line-height: 70px;
		text-align: center;
		margin-right: 10px;
		float: left;
		font-family: "微软雅黑";
	}
	.div1:nth-child(6n){
		margin-right: 0px;
	}
	.checkbox{
		width: 45px;
		position: relative;
		top:-40%;
		left: -5px;
	}
	.book_img{
		position: relative;
		left: -10px;
		width: 60px;
		height: 70px;
		position: relative;
	}
	.div1:nth-child(2n){
		width: 200px;
		height: 70px;
		text-align: left;
		overflow: hidden;
		text-overflow: ellipsis;
		position: relative;
		left: 20px;
	}
	.div1:nth-child(3n){
		width: 70px;
		height: 70px;
		position: relative;
		left: 50px;
		color: #EA5474;
		font-weight: bold;
	}
	.div1:nth-child(4n){
		width: 150px;
		height: 70px;
		position: relative;
		left: 125px;
	}
	.cha{
		width: 45px;
		height: 25px;
		margin-top: 22.5px;
		margin-left: 7.5px;
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
		margin-top: 22.5px;
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
		margin-top: 22.5px;
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
	.div1:nth-child(5n){
		width: 70px;
		height: 70px;
		position: relative;
		left: 175px;
		color: #EA5474;
		font-weight: bold;
	}
	.div1:nth-child(6n){
		width: 70px;
		height: 70px;
		position: relative;
		left: 265px;
	}
	.div1:nth-child(6n) button{
		width: 45px;
		height: 30px;
		margin-top: 20px;
		background: #FFFFFF;
		border: 1px solid #EA5474;
		color: EA5474;
		position: relative;
		padding: 0px;
		left: 15px;
	}
	.div1:nth-child(6n) button:hover{
		background: pink;
		color: #FFFFFF;
	}
	.div_bottom{
		width: 980px;
		height: 30px;
		background: #DDDDDD;
		display: none;
	}
	.div2{
		float: left;
	}
	.div2:nth-child(1){
		width: 30px;
		height: 30px;
		line-height: 30px;	
	}
	.div2:nth-child(1) input{
		position: relative;
		left: 11px;
		margin-top: 10px;
	}
	.div2:nth-child(2){
		width: 30px;
		height: 30px;
		line-height: 30px;
		font-size: 15px;
		font-family: "微软雅黑";
		position: relative;
		left: 6px;
	}
	.div2:nth-child(3){
		width: 90px;
		height: 30px;
		line-height: 30px;
		position: relative;
		left: 635px;
		color: #EA5474;
		font-weight: bold;
		font-family: "微软雅黑";
		font-size: 20px;
	}
	.div2:nth-child(4){
		width: 70px;
		height: 30px;
		text-align: center;
		position: relative;
		background: #EA5474;
		left: 760px;
		font-size: 12px;
	}
	.div2:nth-child(4) button{
		width: 70px;
		height: 30px;
		background: #EA5474;
		font-size: 12px;
		color: #FFFFFF;
		border: 0;
		position: relative;
		top: 19px;
		padding: 0px;
	}
	.address{
		width: 730px;
		min-height: 130px;
		border-radius: 10px;
		position: absolute;
		left: 50%;
		top: 20px;
		margin-left: -360px;
		background: #FFFFFF;
		opacity: 0;
		display: none;
	}
	.address .address_son{
		width: 730px;
		height: 30px;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		padding:15px 0 15px 0;
	}
	.address .address_son h3{
		text-align: center;
		font-family: "微软雅黑";
		font-size: 22px;
		color: #555555;
	}
	.address .address_nav{
		width: 700px;
		height: 40px;
		margin: 0 auto;
		background-color: #DDDDDD;
	}
	.address .address_nav span{
		height: 40px;
		line-height: 40px;
		color: #555555;
		font-family: "微软雅黑";
		font-weight: bold;
	}
	#shopping_address_page{
		padding-bottom: 15px;
	}
	.shopping_address{
		width: 700px;
		height: 60px;
		border-top: 1px solid #ccc;
		background-color:#F5F5F5;
		margin: 0 auto;
	}
	.shopping_address:hover{
		background: #EAEAEA;
	}
	.shopping_address:nth-child(1){
		border-top: 0;
	}
	.div_address{
		float: left;
	}
	.div_address:nth-child(1){
		width: 80px;
		height: 60px;
		line-height: 60px;
		text-align: center;
		position: relative;
		left: 15px;
	}
	.div_address:nth-child(2){
		width: 110px;
		height: 60px;
		line-height: 60px;
		text-align: center;
		position: relative;
		left: 40px;
	}
	.div_address:nth-child(3){
		width: 330px;
		height: 60px;
		line-height: 60px;
		text-align: left;
		position: relative;
		left: 85px;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	.div_address:nth-child(4){
		width: 50px;
		height: 60px;
		position: relative;
		left: 115px;
	}
	.div_address:nth-child(4) button{
		width: 50px;
		height: 30px;
		margin-top: 15px;
		border: 1px solid #EA5474;
		color: #EA5474;
	}
	.div_address:nth-child(4) button:hover{
		background-color:pink;
		color: #FFFFFF;
	}
	.footer{
		width: 100%;
		height: 170px;
		background-color: #373d41;
		position: absolute;
		bottom: 0;
	}

</style>
</head>
<body>
		<div class="div_main">
		<div class="shopping_car">购物车</div>
		<div class="checkbox_div">
			<div class="nav_div">
				<ul>
					<li>选择</li>
					<li>商品名称</li>
					<li>单价(元)</li>
					<li>数量</li>
					<li>小计</li>
					<li>操作</li>
				</ul>
			</div>
			<div id="shoppingCarPage">
			
			</div>
			<div class="div_bottom">
				<div class="div2"><input type="checkbox" checked="checked" id="all" onclick="allselection()"/></div>
				<div class="div2">全选</div>
				<div class="div2" id="Settlement">￥0.00</div>
				<div class="div2"><button onclick="Settlement()" id="Settlement">立即结算</button></div>
			</div>
		</div>
	</div>
	<div id="mask">
		<div class="address">
			<div class="address_son">
				<h3>选择收货地址</h3>
			</div>
			<div class="address_nav">
				<span style="position: relative; left: 35px;">收货人</span>
				<span style="position: relative; left: 85px;">联系电话</span>
				<span style="position: relative; left: 255px;">地址</span>
				<span style="position: relative; left: 475px;">操作</span>
			</div>
			<div id="shopping_address_page">
				
			</div>
		</div>
	</div>
	<%@ include file="footer/footer.jsp"%>
	<script>
		window.$number = parseInt($("#number").text()); //获取购物车对应的图书数量
		$(function(){
			var username="<%=username%>";
			if(username != "null"){
				$("#nav_login_img").show();
				$("#nav_login_message").show();
			}
			$.post("/bookshop/ShoppingCar",{},function(res){
				console.log(res.list);
				console.log(res.message);
				var ShoppingCarPage = "";
				var bookList = res.list;
				if(res.message == "null"){
					ShoppingCarPage +="<div class='div_href'>购物车中还没有物品，您可以先&nbsp<a href='ShowAllBook.jsp' style='color:#EA5474'>浏览图书</a>。</div>";
				}else{
					window.$bookPrice = bookList.bookPrice;
					for (var i in bookList) {
					ShoppingCarPage += "<div class='shoppingCar' uuid='"+bookList[i].uuid+"'>";
					ShoppingCarPage += "<div class='div1'><input type='checkbox' checked='checked' name='check' class='checkbox' onclick='selection()'/><img class='book_img' src='/bookshop/img/bookPic/" + bookList[i].book.bookISBN + bookList[i].book.bookPic + "'></div>";
					ShoppingCarPage += "<div class='div1'>" + bookList[i].book.bookName + "</div>";
					ShoppingCarPage += "<div class='div1'>￥" + bookList[i].book.bookPrice + "</div>";
					ShoppingCarPage += "<div class='div1'>";
					ShoppingCarPage += "<button class='cha' onclick='cha()'>-</button>";
					ShoppingCarPage += "<div class='number'>"+ bookList[i].number +"</div>";
					ShoppingCarPage += "<button class='he' onclick='he()'>+</button>";
					ShoppingCarPage += "</div>";
					ShoppingCarPage += "<div class='div1' name='num'>￥"+ (bookList[i].book.bookPrice * parseInt(bookList[i].number)).toFixed(2) +"</div>";
					ShoppingCarPage += "<div class='div1'><button onclick='Delete()'>删除</button></div>";
					ShoppingCarPage += "</div>";
					ShoppingCarPage += "</div>";
					}
					$(".nav_div").show();
					$(".div_bottom").show();
				}
				$("#shoppingCarPage").html(ShoppingCarPage);
				$("#Settlement").html(window.$Settlement);
				selection();
			});
			
				//绑定页面鼠标单击隐藏收货地址的div
			　$("#mask").bind("click",function(e){
		  　　　　　　   var target  = $(e.target);
		  　　　　　  　  if(target.closest("#mask").length == 1 && target.closest(".address").length == 0){
			      　　　　　　  	$("#mask").removeClass("mask");
			      		$(".address").animate({"top":'150px',"opacity":0},200);
			      		setTimeout("$('#mask').css('display','none')",200);
			      		$("#mask").animate({"opacity":0});
		 　　　　　　     }　　　　
		 　　　　　　})

		})
		function cha(){
			var num = parseInt($(window.event.srcElement.parentElement.parentElement).find(".div1")[3].getElementsByTagName("div")[0].innerText);
			if($(window.event.srcElement).text() == "-"){
				num--;
				if(num < 1){
					num = 1; 
				}
			}
			$(window.event.srcElement.parentElement).find(".number").html(num);
			small_plan();
			selection();
		}
		function he(){
			var num = parseInt($(window.event.srcElement.parentElement.parentElement).find(".div1")[3].getElementsByTagName("div")[0].innerText);
			if($(window.event.srcElement).text() == "+"){
				num++;
				if(num > 99){
					num = 99; 
				}
			}
			$(window.event.srcElement.parentElement).find(".number").html(num);
			small_plan();
			selection();
		}
		//小计方法
		function small_plan(){
			var num = parseInt($(window.event.srcElement.parentElement.parentElement).find(".div1")[3].getElementsByTagName("div")[0].innerText);
			var price = parseFloat($(window.event.srcElement.parentElement.parentElement).find(".div1")[2].innerText.substring(1));
			var small_plan = parseFloat(num * price);
			$(window.event.srcElement.parentElement.parentElement).find(".div1")[4].innerHTML = "￥"+small_plan.toFixed(2);
		}
		//计算总价格
		function selection(){
			var checkEle = document.getElementsByName("check");
			console.log(checkEle);
			var sum = 0;
			for(var i in checkEle){
					if(checkEle[i].checked){
						sum += parseFloat($(checkEle[i].parentElement.parentElement).find(".div1")[4].innerText.substring(1));
						console.log(sum);
					}
			}
			$("#Settlement").html("￥"+sum.toFixed(2));
		}
		function allselection(){
			if(window.event.srcElement.checked) {
			$(".shoppingCar").find("input[type='checkbox']").each(function() {
				this.checked = true;
			});
			} else {
			$(".shoppingCar").find("input[type='checkbox']").each(function() {
				this.checked = false;
			});
			}
				selection(); //统计总价格
		}
		//结算选择地址方法
		function Settlement(){
			$("#mask").addClass("mask");
			$("#mask").css("display","block");
			$(".address").css("display","block");
			$(".address").animate({"top":'300px',"opacity":1});
			$("#mask").animate({"opacity":1});
			$.post("/bookshop/queryaddress",{},function(res){
				console.log(res.message);
				console.log(res);
				var shopping_address_page = "";
				var addresslist = res.list;
				for(var i in addresslist){
					shopping_address_page +="<div class='shopping_address'>";
					shopping_address_page +="<div class='div_address'>"+addresslist[i].collect_people+"</div>";
					shopping_address_page +="<div class='div_address'>"+addresslist[i].telephone+"</div>";
					shopping_address_page +="<div class='div_address'>"+addresslist[i].address+"</div>";
					shopping_address_page +="<div class='div_address'><button onclick='create_order()'>选择</button></div>";
					shopping_address_page +="</div>";
				}
				$("#shopping_address_page").html(shopping_address_page);
			});
		}
		//删除对应图书方法
		function Delete(){
			var inputs = document.getElementsByName("check");
			var uuid = $(window.event.srcElement.parentElement.parentElement).attr("uuid");
			console.log(uuid);
			var obj = 0;
			for(var i=0; i<inputs.length; i++){
				if(inputs[i].checked){
					obj++; 
					flag = true; 
				}
			}
			if(obj == 0){
				messageBox("提示","请选中需要删除的图书！",function(){});
				return;
			}
			console.log(flag);
			if(flag){
				messageBox("提示","确定要删除吗？",function(){
					$.post("/bookshop/deleteShoppingCarBook",{"uuid":uuid},function(res){
						console.log(res.message);
						/*window.open("ShoppingCar.jsp");*/ //在新窗口打开
						window.location.href="ShoppingCar.jsp"; //在当前页面打开
					});
				},function(){});
			  }
		}
		//创建订单
		function create_order(){
			var name = $(window.event.srcElement.parentElement.parentElement).find(".div_address")[0].innerHTML;
			var sumprice = $("#Settlement").text().substr(1);
			console.log(name);
			console.log(sumprice);
				messageBox("提示","创建订单成功!",function(){
				$.post("/bookshop/CreateOrder",{"name":name,"sumprice":sumprice},function(res){
					console.log(res.name);
					console.log(res.message);
					window.location.href="order.jsp";
				});
			});
		}
	</script>
</body>
</html>