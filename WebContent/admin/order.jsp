<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
	String username = (String)session.getAttribute("success");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="stylesheet" href="../css/messagebox.css" />
<link rel="shortcut icon" href="/bookshop/img/favicon.png">
<script type="text/javascript"></script>
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/messageBox.js" ></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background-color: #F4F5F7;
	}
	.mask{
		position: fixed;
		z-index: 199;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.25);
	}
	.stbs{
		width: 1000px;
		min-height: 190px;
		margin: 0 auto;
		margin-top: 10px;
		background-color: #FFFFFF;
		border-radius: 10px;
	}
	.stbs_text{
		width: 1000px;
		height:60px;
		font-family: "微软雅黑";
		font-size: 20px;
		font-weight: bold;
		line-height: 60px;
		margin-left: 10px;
		text-shadow: 0 0 0.2em #F87, 0 0 0.2em #F87;
	}
	.stbs_main{
		width: 980px;
		padding: 0 10px 10px 10px;
	}
	.stbs_main_2{
		width: 980px;
		padding: 0 10px 10px 10px;
	}
	.stbs_main_3{
		width: 980px;
		padding: 0 10px 10px 10px;
	}
	.stbs_nav{
		width: 980px;
		height: 40px;
		background-color: #DDDDDD;
	}
	.stbs_nav_son{
		float:left;
		line-height: 40px;
		font-family: "微软雅黑";
		font-weight: bold;
		color: #555555;
	}
	.stbs_nav_son:nth-child(1){
		width:180px;
		position: relative;
		left: 10px;
		text-align: left;
	}
	.stbs_nav_son:nth-child(2){
		width: 120px;
		position: relative;
		left: 10px;
		text-align: center;
	}
	.stbs_nav_son:nth-child(3){
		width:170px;
		position: relative;
		left: 10px;
		text-align: center;
	}
	.stbs_nav_son:nth-child(4){
		width:300px;
		position: relative;
		text-align: left;
		left: 10px;
	}
	.stbs_nav_son:nth-child(5){
		width: 100px;
		text-align: left;
		position: relative;
		left: 15px;
		color: #EA5474;
	}
	.stbs_nav_son:nth-child(6){
		width: 100px;
		height: 40px;
		position: relative;
		left: 10px;
	}
	.stbs_nav_son:nth-child(6) button{
		width: 80px;
		height: 30px;
		margin:5px 10px 5px 10px;
		border: 1px solid #EA5474;
		color: #EA5474;
		background-color: #FFFFFF;
		outline: none;
	}
	.stbs_nav_son:nth-child(6) button:hover{
		background-color: pink;
		color: #FFFFFF;
		cursor: pointer;
	}
	.ShoppingBookList{
		width: 980px;
		height: 80px;
		background-color: #F5F5F5;
		border-top: 1px solid #DDDDDD !important;
	}
	.ShoppingBookList:first-child{
		border-top: none;
	}
	.ShoppingBookList:hover{
		background-color: #EAEAEA;
	}
	.div_href{
		width: 700px;
		height: 60px;
		line-height: 60px;
	}
	.ShoppingBook{
		height: 80px;
		line-height: 80px;
		float: left;
	}
	.ShoppingBook:nth-child(1){
		width: 60px;
		height: 80px;
		position: relative;
		left: 10px;
	}
	.ShoppingBook:nth-child(1) img{
		width: 60px;
		height: 80px;
	}
	.ShoppingBook:nth-child(2){
		width: 380px;
		height: 80px;
		position: relative;
		left: 20px;
	}
	.ShoppingBook:nth-child(3){
		width: 110px;
		height: 80px;
		position: relative;
		left:60px;
	}
	.ShoppingBook:nth-child(3) span{
		font-family: "微软雅黑";
		font-weight: bold;
		color: #EA5474;
	}
	.ShoppingBook:nth-child(4){
		width: 80px;
		height: 80px;
		position: relative;
		left:90px;
	}
	.ShoppingBook:nth-child(5){
		width: 120px;
		height: 80px;
		position: relative;
		left:120px;
	}
	.ShoppingBook:nth-child(5) span{
		font-family: "微软雅黑";
		font-weight: bold;
		color: #EA5474;
	}
	.ShoppingBook:nth-child(6){
		width: 80px;
		height: 80px;
		position: relative;
		left:140px;
	}
	.ShoppingBook:nth-child(6) button{
		width: 80px;
		height: 30px;
		border: 1px solid #DDDDDD;
		margin-top: 25px;
		color: #DDDDDD;
		background-color: #FFFFFF;
		outline: none;
	}
	.evaluate_btn{
		width: 80px !important;
		height: 30px !important;
		border: 1px solid #EA5474 !important;
		margin-top: 25px !important;
		color: #EA5474 !important;
		background-color: #FFFFFF !important;
		outline: none;
	}
	.evaluate_btn:hover{
		background-color: pink !important;
		color: #FFFFFF !important;
		cursor: pointer !important;
	}
	.evaluate_div{
		width: 600px;
		height: 300px;
		margin: auto;
		background-color: #FFFFFF;
		border-radius: 5px;
		position: absolute;
		left: 50%;
		top: 50%;
		margin-top: -150px;
		margin-left: -300px;
		opacity: 0;
		display: none;
	}
	.evaluate_div .evaluate_div_nav{
		width: 200px;
		height: 60px;
		line-height: 60px;
		margin: auto;
		text-align: center;
		font-family: "微软雅黑";
		font-size: 25px;
		font-weight: bold;
		text-shadow:0 0 0.2em #F87,
                0 0 0.2em #F87;
	}
	.evaluate_div textarea{
		width: 550px;
		height: 150px;
		font-size: 20px;
		text-align: left;
		margin-left: 25px;
		font-family: "微软雅黑";
		resize: none;
		outline: none;
		border: 1px solid #DDDDDD;
	}
	.evaluate_div textarea:focus{
		border: 1px solid #EA5474;
	}
	.evaluate_div button{
		width: 550px;
		height: 40px;
		border: 1px solid #EA5474;
		margin-left: 25px;
		margin-top: 25px;
		color: #EA5474;
	}
	.evaluate_div button:hover{
		background-color: pink;
		color: #FFFFFF;
	}
	.footer{
		width: 100%;
		height: 170px;
		background-color: #373d41;
		bottom: 0;
		margin-top: 10px;
	}
</style>
<title>订单</title>
</head>
<body>
	<div class="stbs">
		<div class="stbs_text" id="Settlement_js">待结算</div>
		<div class="stbs_main" id="stbs_main"></div>
	</div>
	<div class="stbs" id="Settlement_pj">
		<div class="stbs_text">待评价</div>
		<div class="stbs_main_2" id="stbs_main_2"></div>
	</div>
	<div class="stbs" id="all_order">
		<div class="stbs_text">全部订单</div>
		<div class="stbs_main_3" id="stbs_main_3"></div>
	</div>
	<div id="mask">
		<div id="evaluate_div" class="evaluate_div">
			<div class="evaluate_div_nav">评  价</div>
			<textarea rows="20" rows="20" placeholder="在这里写下你的评论，最少10字，最多120字。" id="textarea"></textarea>
			<button onclick="sbmit_pj()">提交评价</button>
		</div>
	</div>
	<%@ include file="footer/footer.jsp"%>
	<script>
			$(orderList);
			//待结算订单
		    function orderList(){
		    	// 加载用户图标  如果登录则显示 未登录则不显示
				var username="<%=username%>";
				if(username != "null"){
				$("#nav_login_img").show();
				$("#nav_login_message").show();
				}
		    	$.post("/bookshop/order",{},function(res){
				console.log(res.message);
				console.log(res.orderList);
				var Unsettled = "";
				if(res.message == "null"){
					Unsettled +="<div class='div_href'>待结算中还没有物品，您可以先  <a href='ShowAllBook.jsp' style='color:#EA5474'>浏览图书</a> , 或者去  <a href='ShoppingCar.jsp' style='color:#EA5474'>购物车</a>  添加图书。</div>";
				}else{
					var orderList = res.orderList.orderList;
					for(var i in orderList){
						date = new Date(orderList[i].time);
						var Month = (date.getMonth()+1)
						var Day = date.getDate();
						var Hours = date.getHours();
						var Minutes = date.getMinutes();
						var Seconds = date.getSeconds();
						if(Month<10){
							Month = "0"+Month;
						}
						if(Day<10){
							Day = "0"+Day;
						}
						if(Hours<10){
							Hours = "0"+Hours;
						}
						if(Minutes<10){
							Minutes = "0"+Minutes;
						}
						if(Seconds<10){
							Seconds = "0"+Seconds;
						}
						date = date.getFullYear()+"/"+Month+"/"+date.getDate()+ " " +Hours+":"+Minutes+":"+Seconds;
						Unsettled +="<div class='stbs_nav' orderNO='"+orderList[i].orderNO+"'>"
						Unsettled +="<div class='stbs_nav_son'>"+ date +"</div>";
						Unsettled +="<div class='stbs_nav_son'>"+ orderList[i].name +"</div>";
						Unsettled +="<div class='stbs_nav_son'>"+ orderList[i].phone +"</div>";
						Unsettled +="<div class='stbs_nav_son'>"+ orderList[i].address +"</div>";
						Unsettled +="<div class='stbs_nav_son'>￥"+ orderList[i].sumPrice +"</div>";
						if(orderList[i].orderstatus == "未结算"){
							Unsettled +="<div class='stbs_nav_son'><button onclick='Settlement()'>立即结算</button></div>";
						}
						Unsettled +="</div>"
					for(var j in orderList[i].orderItemList){
						Unsettled +="<div class='ShoppingBookList'>";
						Unsettled +="<div class='ShoppingBook'><img src='/bookshop/img/bookPic/"+orderList[i].orderItemList[j].book.bookISBN + orderList[i].orderItemList[j].book.bookPic +"'/></div>";
						Unsettled +="<div class='ShoppingBook'>"+ orderList[i].orderItemList[j].book.bookName +"</div>";
						Unsettled +="<div class='ShoppingBook'>单价:&nbsp<span>￥"+ orderList[i].orderItemList[j].book.bookPrice +"</span></div>";
						Unsettled +="<div class='ShoppingBook'>数量:"+ orderList[i].orderItemList[j].count +"</div>";
						Unsettled +="<div class='ShoppingBook'>小计:&nbsp<span>￥"+ (orderList[i].orderItemList[j].bookPrice * orderList[i].orderItemList[j].count).toFixed(2) +"</span></div>";
						Unsettled +="<div class='ShoppingBook'><button disabled='disabled'>立即评价</button></div>";
						Unsettled +="</div>";
						}
					}
				
			}
				
				$("#stbs_main").html(Unsettled);
				notevaluateList();
				allorder();
			});
				
				//绑定页面鼠标单击隐藏评价div
				$("#mask").bind("click",function(e){
		  　　　　　　var target  = $(e.target);
		  　　　　　  　  if(target.closest("#evaluate_div").length == 0 && target.closest("#evaluate").length != 1){
			      　　　　　　 	$("#mask").removeClass("mask");
			      		$("#evaluate_div").animate({"top":"0","opacity":0},500);
			      		setTimeout("$('#evaluate_div').css('display','none')",500);
			      		$("#mask").animate({"opacity":0});
		 　　　　　　     }　　　　
		 　　　　　　})
		  }
		    //待评价订单
			function notevaluateList(){
				$.post("/bookshop/notevaluate",{},function(res){
					console.log(res.notevaluateList);
					var NoteValuate = "";
					if(res.evaluate == "null"){
					NoteValuate +="<div class='div_href'>待评价中还没有已结算的图书，请立即结算图书或者前往  <a href='ShoppingCar.jsp' style='color:#EA5474'>购物车</a>  添加图书。</div>";
				}else{
				    var notevaluateList = res.notevaluateList.orderList;
					for(var i in notevaluateList){
						date = new Date(notevaluateList[i].time);
						var Month = (date.getMonth()+1)
						var Day = date.getDate();
						var Hours = date.getHours();
						var Minutes = date.getMinutes();
						var Seconds = date.getSeconds();
						if(Month<10){
							Month = "0"+Month;
						}
						if(Day<10){
							Day = "0"+Day;
						}
						if(Hours<10){
							Hours = "0"+Hours;
						}
						if(Minutes<10){
							Minutes = "0"+Minutes;
						}
						if(Seconds<10){
							Seconds = "0"+Seconds;
						}
						if(notevaluateList[i].orderItemList.length == 0){
							continue;
						}
						date = date.getFullYear()+"/"+Month+"/"+date.getDate()+ " " +Hours+":"+Minutes+":"+Seconds;
						NoteValuate +="<div class='stbs_nav' orderNO='"+notevaluateList[i].orderNO+"'>"
						NoteValuate +="<div class='stbs_nav_son'>"+ date +"</div>";
						NoteValuate +="<div class='stbs_nav_son'>"+ notevaluateList[i].name +"</div>";
						NoteValuate +="<div class='stbs_nav_son'>"+ notevaluateList[i].phone +"</div>";
						NoteValuate +="<div class='stbs_nav_son'>"+ notevaluateList[i].address +"</div>";
						NoteValuate +="<div class='stbs_nav_son'>￥"+ notevaluateList[i].sumPrice +"</div>";
						if(notevaluateList[i].orderstatus == "未结算"){
							NoteValuate +="<div class='stbs_nav_son'><button onclick='Settlement()'>立即结算</button></div>";
						}else{
							NoteValuate +="<div class='stbs_nav_son' style='display:none;'><button onclick='Settlement()'>立即结算</button></div>";
						}
						NoteValuate +="</div>"
						
					for(var j in notevaluateList[i].orderItemList){
						NoteValuate +="<div class='ShoppingBookList' bookISBN='"+ notevaluateList[i].orderItemList[j].book.bookISBN +"' orderNO='"+ notevaluateList[i].orderNO +"' ID='"+ notevaluateList[i].orderItemList[j].ID +"'>";
						NoteValuate +="<div class='ShoppingBook'><img src='/bookshop/img/bookPic/"+notevaluateList[i].orderItemList[j].book.bookISBN + notevaluateList[i].orderItemList[j].book.bookPic +"'/></div>";
						NoteValuate +="<div class='ShoppingBook'>"+ notevaluateList[i].orderItemList[j].book.bookName +"</div>";
						NoteValuate +="<div class='ShoppingBook'>单价:&nbsp<span>￥"+ notevaluateList[i].orderItemList[j].book.bookPrice +"</span></div>";
						NoteValuate +="<div class='ShoppingBook'>数量:"+ notevaluateList[i].orderItemList[j].count +"</div>";
						NoteValuate +="<div class='ShoppingBook'>小计:&nbsp<span>￥"+ (notevaluateList[i].orderItemList[j].bookPrice * notevaluateList[i].orderItemList[j].count).toFixed(2) +"</span></div>";
						if(notevaluateList[i].orderstatus == "已结算" && notevaluateList[i].orderItemList[j].commentstatus == 0){
								NoteValuate +="<div class='ShoppingBook'><button class='evaluate_btn' onclick='ShowEvaluate()' id='evaluate'>立即评价</button></div>";
						}
						NoteValuate +="</div>";
						}
					}
				}
				$("#stbs_main_2").html(NoteValuate);
			});
			}
			//所有订单	
			function allorder(){
				$.post("/bookshop/allorder",{},function(res){
					console.log(res.message);
					console.log(res.AllorderList);
					var allorder = "";
					if(res.message == "null"){
					allorder +="<div class='div_href'>所有订单中没有图书，请立即结算图书或者前往  <a href='ShoppingCar.jsp' style='color:#EA5474'>购物车</a>  添加图书。</div>";
					}else{
						var allorderList = res.AllorderList.orderList;
						for(var i in allorderList){
						date = new Date(allorderList[i].time);
						var Month = (date.getMonth()+1)
						var Day = date.getDate();
						var Hours = date.getHours();
						var Minutes = date.getMinutes();
						var Seconds = date.getSeconds();
						if(Month<10){
							Month = "0"+Month;
						}
						if(Day<10){
							Day = "0"+Day;
						}
						if(Hours<10){
							Hours = "0"+Hours;
						}
						if(Minutes<10){
							Minutes = "0"+Minutes;
						}
						if(Seconds<10){
							Seconds = "0"+Seconds;
						}
						date = date.getFullYear()+"/"+Month+"/"+date.getDate()+ " " +Hours+":"+Minutes+":"+Seconds;
						allorder +="<div class='stbs_nav' orderNO='"+allorderList[i].orderNO+"'>"
						allorder +="<div class='stbs_nav_son'>"+ date +"</div>";
						allorder +="<div class='stbs_nav_son'>"+ allorderList[i].name +"</div>";
						allorder +="<div class='stbs_nav_son'>"+ allorderList[i].phone +"</div>";
						allorder +="<div class='stbs_nav_son'>"+ allorderList[i].address +"</div>";
						allorder +="<div class='stbs_nav_son'>￥"+ allorderList[i].sumPrice +"</div>";
						if(allorderList[i].orderstatus == "未结算"){
							allorder +="<div class='stbs_nav_son'><button onclick='Settlement()'>立即结算</button></div>";
						}else{
							allorder +="<div class='stbs_nav_son' style='display:none;'><button onclick='Settlement()'>立即结算</button></div>";
						}
						allorder +="</div>"
						for(var j in allorderList[i].orderItemList){
							allorder +="<div class='ShoppingBookList' bookISBN='"+ allorderList[i].orderItemList[j].book.bookISBN +"' orderNO='"+ allorderList[i].orderNO +"' ID='"+ allorderList[i].orderItemList[j].id +"'>";
							allorder +="<div class='ShoppingBook'><img src='/bookshop/img/bookPic/"+allorderList[i].orderItemList[j].book.bookISBN + allorderList[i].orderItemList[j].book.bookPic +"'/></div>";
							allorder +="<div class='ShoppingBook'>"+ allorderList[i].orderItemList[j].book.bookName +"</div>";
							allorder +="<div class='ShoppingBook'>单价:&nbsp<span>￥"+ allorderList[i].orderItemList[j].book.bookPrice +"</span></div>";
							allorder +="<div class='ShoppingBook'>数量:"+ allorderList[i].orderItemList[j].count +"</div>";
							allorder +="<div class='ShoppingBook'>小计:&nbsp<span>￥"+ (allorderList[i].orderItemList[j].bookPrice * allorderList[i].orderItemList[j].count).toFixed(2) +"</span></div>";
							if(allorderList[i].orderstatus == "未结算" && allorderList[i].orderItemList[j].commentstatus == 0){
									allorder +="<div class='ShoppingBook'><button disabled='disabled'>立即评价</button></div>";
							}else if(allorderList[i].orderstatus == "已结算" && allorderList[i].orderItemList[j].commentstatus == 0){
									allorder +="<div class='ShoppingBook'><button class='evaluate_btn' onclick='ShowEvaluate()'>立即评价</button></div>";
							}else if(allorderList[i].orderstatus == "已结算" && allorderList[i].orderItemList[j].commentstatus == 1){
									allorder +="<div class='ShoppingBook'><button class='evaluate_btn' onclick='QueryEvaluate()'>查看评价</button></div>";
							}
							allorder +="</div>";
						}
					}
				}
					$("#stbs_main_3").html(allorder);
			});
		}
			
			//结算订单方法
			function Settlement(){
				var orderNO = $(window.event.srcElement.parentElement.parentElement).attr("orderNO");
				messageBox("提示","确定要结算订单吗？",function(){
					$.post("/bookshop/ModifyState",{"orderNO":orderNO},function(res){
						orderList();
					});
				},function(){});
			}
			//显示图书评价
			function ShowEvaluate(){
				window.bookISBN =  $(window.event.srcElement.parentElement.parentElement).attr("bookISBN");
				window.orderNO =  $(window.event.srcElement.parentElement.parentElement).attr("orderNO");
				window.id =  $(window.event.srcElement.parentElement.parentElement).attr("ID");
				console.log(window.bookISBN);
				$("#mask").addClass("mask");
				$("#evaluate_div").css("display","block");
				$("#evaluate_div").css("top","0px");
				$("#evaluate_div").animate({"top":'50%',"opacity":1},300);
				$("#mask").animate({"opacity":1});
			}
			//提交评价内容用于后台像数据库图书表插入评价信息
			function sbmit_pj(){
				var text = $("#textarea").val();
				console.log(text);
				if(text.length < 10){
					messageBox("评价提示","评价字数不能少于10字",function(){});
				}else if(text.length > 120){
					messageBox("评价提示","评价字数不能大于120字",function(){});
				}else{
					messageBox("提示","评价成功！",function(){
						$("#evaluate_div").css("display","none");
						$.post("/bookshop/AddBookEvaluate",{"bookISBN":window.bookISBN,"text":text,"orderNO":window.orderNO,"ID":window.id},function(res){
							console.log(res.message);
							orderList();
							$("#mask").removeClass("mask");
					      	$("#evaluate_div").animate({"top":'0px',"opacity":0},100);
					      	$("#mask").animate({"opacity":0});
						});
					});
				}
				
			}
			//查询评价
			function QueryEvaluate(){
				var bookISBN =  $(window.event.srcElement.parentElement.parentElement).attr("bookISBN");
				$.post("/bookshop/QueryEvaluate",{"bookISBN":bookISBN},function(res){
					if(res.message == "数据库查询错误"){
						messageBox("提示","查询异常请重试",function(){});
					}else{
						var book_pj = res.book.join("<br/><br/>");
						messageBox("图书评价",book_pj,function(){});
					}
				});
			}
	</script>
</body>
</html>