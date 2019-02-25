<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
	String username = (String)session.getAttribute("success");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/messagebox.css" />
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/footer.css" />
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<script type="text/javascript" src="../js/messageBox.js" ></script>
<script type="text/javascript" src="../js/jsAddress.js" ></script><!--省市区三级联动-->
<title>收货地址</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background-color: #F5F5F5;
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
	.address{
		width: 1000px;
		min-height: 170px;
		margin: auto;
		margin-top: 10px;
		background-color: #FFFFFF;
		border-radius: 10px;
	}
	.address_top{
		width: 1000px;
		height: 60px;
	}
	.address_text{
		width: 200px;
		height: 60px;
		font-family: "微软雅黑";
		font-size: 20px;
		font-weight: bold;
		line-height: 60px;
		margin-left: 10px;
		text-shadow: 0 0 0.2em #F87, 0 0 0.2em #F87;
		float: left;
	}
	.add_address{
		width: 150px;
		height: 60px;
		float: right;
		margin-right: 10px;
	}
	.add_address button{
		padding: 0;
		margin: 0;
		width: 120px;
		height: 40px;
		outline: none;
		border: 1px solid #EA5474;
		color: #EA5474;
		margin: 10px 0 0 29px;
	}
	.add_address button:hover{
		border: 0;
		color: #FFFFFF;
	}
	.div_main{
		width: 980px;
		padding: 0 10px 10px 10px;
	}
	.address_nav{
		width: 980px;
		height: 40px;
		line-height: 40px;
		background-color: #DDDDDD;
	}
	.address_nav_son{
		font-family: "微软雅黑";
		font-size: 15px;
		float: left;
	}
	.address_nav_son:nth-child(1){
		width: 100px;
		position: relative;
		left: 10px;
	}
	.address_nav_son:nth-child(2){
		width: 130px;
		position: relative;
		left: 10px;
	}
	.address_nav_son:nth-child(3){
		width: 150px;
		position: relative;
		left: 10px;
	}
	.address_nav_son:nth-child(4){
		width: 100px;
		position: relative;
		left: 20px;
	}
	.address_nav_son:nth-child(5){
		width: 150px;
		position: relative;
		left: 382px;
	}
	.address_main{
		width: 980px;
		min-height: 60px;
		background-color: #F5F5F5;
	}
	.address_main_row{
		width: 980px;
		height: 60px;
		line-height: 60px;
		border-top: 1px solid #CCC;
	}
	.address_main_row:nth-child(1){
		border-top: 0;
	}
	.address_main_row:hover{
		background-color: #EAEAEA;
	}
	.address_main_row_son{
		float: left;
	}
	.address_main_row_son:nth-child(1){
		width: 100px;
		position: relative;
		left: 10px;
	}
	.address_main_row_son:nth-child(2){
		width: 110px;
		position: relative;
		left: 10px;
	}
	.address_main_row_son:nth-child(3){
		width: 150px;
		position: relative;
		left: 25px;
	}
	.address_main_row_son:nth-child(4){
		width: 400px;
		position: relative;
		left: 20px;
	}
	.address_main_row_son:nth-child(5){
		width: 130px;
		height: 60px;
		position: relative;
		left: 90px;
	}
	.bj{
		margin: 0;
		padding: 0;
		width: 45px;
		height: 30px;
		outline: none;
		border: 1 px solid #EA5474;
		color: #EA5474;
		margin: 15px 15px 10px 10px;
	}
	.delete{
		margin: 0;
		padding: 0;
		width: 45px;
		height: 30px;
		outline: none;
		border: 1 px solid #EA5474;
		color: #EA5474;
	}
	.Add_modify_address{
		width: 430px;
		height: 450px;
		border-radius: 5px;
		position: absolute;
		left: 50%;
		top: 50%;
		margin-top: -250px;
		margin-left: -200px;
		background-color: #FFFFFF;
		opacity: 0;
		display: none;
	}
	.address_title{
		width: 430px;
		height: 70px;
		line-height: 70px;
		text-align: center;
		font-family: "微软雅黑";
	}
	.people{
		width: 330px;
		height: 40px;
		margin: auto;
	}
	.people span{
		width: 80px;
		line-height: 40px;
		font-size: 16px;
		float: left;
	}
	.people .input_people{
		width: 250px;
		line-height: 40px;
		float: left;
	}
	.people .input_people input{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
		
	}
	.people .input_people input:focus{
		border-style:solid;  
	    border-color: #03a9f4;  
	    box-shadow: 0 0 15px #03a9f4;  
	}
	.phone{
		width: 330px;
		height: 40px;
		margin: auto;
		margin-top: 5px;
	}
	.phone span{
		width: 80px;
		line-height: 40px;
		font-size: 16px;
		float: left;
	}
	.phone .input_phone{
		width: 250px;
		line-height: 40px;
		float: left;
	}
	.phone .input_phone input{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
		
	}
	.phone .input_phone input:focus{
		border-style:solid;  
	    border-color: #03a9f4;  
	    box-shadow: 0 0 15px #03a9f4;  
	}
	.zipcode{
		width: 330px;
		height: 40px;
		margin: auto;
		margin-top: 5px;
	}
	.zipcode span{
		width: 80px;
		line-height: 40px;
		font-size: 16px;
		float: left;
	}
	.zipcode .input_zipcode{
		width: 250px;
		line-height: 40px;
		float: left;
	}
	.zipcode .input_zipcode input{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
		
	}
	.zipcode .input_zipcode input:focus{
		border-style:solid;  
	    border-color: #03a9f4;  
	    box-shadow: 0 0 15px #03a9f4;  
	}
	.Receiving_address{
		width: 330px;
		height: 40px;
		margin: auto;
		margin-top: 5px;
	}
	.Receiving_address span{
		width: 80px;
		line-height: 40px;
		font-size: 16px;
		float: left;
	}
	.Receiving_address_select{
		width: 250px;
		height: 135px;
		font-size: 16px;
		float: left;
	}
	.prov{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.city{
		margin-top: 10px;
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.dist{
		margin-top: 10px;
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.prov_2{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.city_2{
		margin-top: 10px;
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.dist_2{
		margin-top: 10px;
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
	}
	.detailed_address{
		width: 330px;
		height: 40px;
		margin: auto;
		margin-top: 5px;
	}
	.detailed_address span{
		width: 80px;
		line-height: 40px;
		font-size: 16px;
		float: left;
	}
	.detailed_address .input_detailed_address{
		width: 250px;
		line-height: 40px;
		float: left;
	}
	.detailed_address .input_detailed_address input{
		width: 250px;
		height: 35px;
		font-size: 16px;
		border: 1px solid #CCC;
		
	}
	.detailed_address .input_detailed_address input:focus{
		border-style:solid;  
	    border-color: #03a9f4;  
	    box-shadow: 0 0 15px #03a9f4;  
	}
	.address_div{
		width: 330px;
		height: 35px;
		margin: auto;
		margin-top: 95px;
	}
	.address_div button{
		margin: 0;
		padding: 0;
		width: 330px;
		height: 35px;
		border: 1px solid #EA5474;
	}
	.address_div button:hover{
		color: #FFFFFF;
		background-color: pink;
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
<div class="address" id="address">
	<div class="address_top">
		<div class="address_text">我的收货地址</div>
		<div class="add_address"><button onclick="Show_AddAddress()">添加收货地址</button></div>
	</div>
	<div class="div_main">
		<div class="address_nav">
			<div class="address_nav_son">收货人</div>
			<div class="address_nav_son">联系电话</div>
			<div class="address_nav_son">邮编</div>
			<div class="address_nav_son">地址</div>
			<div class="address_nav_son">操作</div>
		</div>
		<div class="address_main" id="address_main">
		</div>
	</div>
</div>
<div id="mask">
	<div class="Add_modify_address" id="modify_address">
		<div class="address_title"><h2>修改收货地址</h2></div>
		<div class="people"><span>收货人</span><div class="input_people"><input id="modify_people"/></div></div>
		<div class="phone"><span>联系电话</span><div class="input_phone"><input id="modify_phone"/></div></div>
		<div class="zipcode"><span>邮编</span><div class="input_zipcode"><input id="modify_zipcode"/></div></div>
		<div class="Receiving_address"><span>收货地址</span>
							<div class="Receiving_address_select">
							<select class="prov" id="modify_prov"></select><br>
	                        <select class="city" id="modify_city"></select><br>
	                        <select class="dist" id="modify_dist"></select>
							</div>
		</div>
		<div class="detailed_address"><span>详细地址</span><div class="input_detailed_address"><input id="modify_detailed_address"/></div></div>
		<div class="address_div"><button onclick="Modify_Address()">修改收货地址</button></div>
	</div>
	<div class="Add_modify_address" id="add_address">
		<div class="address_title"><h2>添加收货地址</h2></div>
		<div class="people"><span>收货人</span><div class="input_people"><input id="add_people"/></div></div>
		<div class="phone"><span>联系电话</span><div class="input_phone"><input id="add_phone"/></div></div>
		<div class="zipcode"><span>邮编</span><div class="input_zipcode"><input id="add_zipcode"/></div></div>
		<div class="Receiving_address"><span>收货地址</span>
							<div class="Receiving_address_select">
							<select class="prov_2" id="add_prov"></select><br>
	                        <select class="city_2" id="add_city"></select><br>
	                        <select class="dist_2" id="add_dist"></select>
							</div>
		</div>
		<div class="detailed_address"><span>详细地址</span><div class="input_detailed_address"><input id="add_detailed_address"/></div></div>
		<div class="address_div"><button onclick="Add_Address()">添加收货地址</button></div>
	</div>
</div>
<%@ include file="footer/footer.jsp"%>
<script type="text/javascript">
	$(ShowAddress);
	function ShowAddress(){
		var username="<%=username%>";
			if(username != "null"){
				$("#nav_login_img").show();
				$("#nav_login_message").show();
			}
		$.post("/bookshop/address",{},function(res){
				console.log(res.message);//获取后台回调函数传递过来的信息
				console.log(res.List);
				var AddressList = res.List;
				var address = "";
				//下面遍历后台传递回来的地址集合
				for (var i in AddressList) {
					address +="<div class='address_main_row' id='"+ AddressList[i].ID +"'>";
					address +="<div class='address_main_row_son'>"+ AddressList[i].collect_people +"</div>";
					address +="<div class='address_main_row_son'>"+ AddressList[i].telephone +"</div>";
					address +="<div class='address_main_row_son'>"+ AddressList[i].zipcode +"</div>";
					address +="<div class='address_main_row_son'>"+ AddressList[i].address +"</div>";
					address +="<div class='address_main_row_son'><button class='bj' onclick='Show()'>编辑</button><button class='delete' onclick='Delete()'>删除</button></div>";
					address +="</div>"
				}
				$("#address_main").html(address);
			});
			//页面单击隐藏修改地址div
			$("#mask").bind("click",function(e){
			  　　　　　　var target  = $(e.target);
			  　　　　　  　  if(target.closest("#mask").length == 1 && target.closest("#modify_address").length == 0 && target.closest("#add_address").length == 0){//判断鼠标点中的区域是否在添加地址div区域外并且不包括页面编辑按钮
				      　　　　　　 	$("#mask").removeClass("mask");
				      		$("#modify_address").animate({"top":"25%","opacity":0},500);
				      		setTimeout("$('#modify_address').css('display','none')",500);
				      		$("#add_address").animate({"top":"25%","opacity":0},500);
				      		setTimeout("$('#add_address').css('display','none')",500);
				      		$("#mask").animate({"opacity":0})
			 　　　　　　     }　　　　
			 　　　　　　})
	}
		

	//删除方法
	function Delete(){
		var id = $(window.event.srcElement.parentElement.parentElement).attr("id");
		messageBox("提示","确定要删除该地址吗？",function(){
			$.post("/bookshop/deleteaddress",{"id":id},function(res){
			console.log(res.message);
			window.location.href = "address.jsp";
			});
		},function(){});
	}
	//显示修改地址信息方法
	function Show(){
		$("#mask").addClass("mask"); //背景遮罩
		$("#mask").css("display","block");
		$("#modify_address").css("display","block");
		$("#modify_address").css("top","0px");
		$("#modify_address").animate({"top":'50%',"opacity":1});//加载动画效果  opacity透明度
		$("#mask").animate({"opacity":1});
		window.id = $(window.event.srcElement.parentElement.parentElement).attr("id");
		$.post("/bookshop/display_address",{"id":window.id},function(res){
			console.log(res.message);
			var pcqp = "";//省
			var pcac = "";//市，区
			var pcaa = "";//县
			var street = "";//街道
			var receivingAddress = res.address.address;//获取地址
			for(var i in PCAP){//遍历省数组
				if(receivingAddress.startsWith(window.PCAP[i])) {//筛选对应的省的信息，找到则存入pcqp
				pcqp = window.PCAP[i];
				receivingAddress = receivingAddress.substring(pcqp.length); //删除省的信息
				for(var j in window.PCAC[i]) { //遍历查找出市
					if(receivingAddress.startsWith(window.PCAC[i][j])) {//筛选对应的市的信息，找到则存入pcac
						pcac = window.PCAC[i][j];
						receivingAddress = receivingAddress.substring(pcac.length); //删除市的信息
						for(var k in window.PCAA[i][j - 1]) { //遍历查找出县
							if(receivingAddress.startsWith(window.PCAA[i][j - 1][k])) {//筛选对应的县的信息，找到则存入pcaa
								pcaa = window.PCAA[i][j - 1][k];
								street = receivingAddress.substring(pcaa.length); //删除县的信息，最后剩下的就是街道信息
								break;
								}
							}
							break;
						}
					}
				break;
				}
			}
			$("#modify_people").val(res.address.collect_people);
			$("#modify_phone").val(res.address.telephone);
			$("#modify_zipcode").val(res.address.zipcode);
			new PCAS("modify_prov", "modify_city", "modify_dist", pcqp, pcac, pcaa);
			$("#modify_detailed_address").val(street);
		});
	}
	//修改地址方法
	function Modify_Address(){
		var people = $("#modify_people").val();
		var phone = $("#modify_phone").val();
		var zipcode = $("#modify_zipcode").val();
		var prov = $("#modify_prov").val();
		var city = $("#modify_city").val();
		var dist = $("#modify_dist").val();
		var detailed_address = $("#modify_detailed_address").val();
		var re = /^[0-9]{6}$/ //邮编正则表达式验证
		if(people.length == 0){
			messageBox("提示","收货人的信息不能为空",function(){});
		}else if(phone.length == 0){
			messageBox("提示","收货人联系电话的信息不能为空",function(){});
		}else if(!re.test(zipcode)){
			messageBox("提示","收货人的邮编信息格式不正确",function(){});
		}else if(prov.length == 0){
			messageBox("提示","省信息不能为空",function(){});
		}else if(detailed_address.length == 0){
			messageBox("提示","收货人的街道信息不能为空",function(){});
		}else{
			$.post("/bookshop/modify_address",{"people":people,"phone":phone,"zipcode":zipcode,"prov":prov,"city":city,"dist":dist,"detailed_address":detailed_address,"id":window.id},function(res){
			console.log(res.message);
			if(res.message == "修改成功"){
				messageBox("提示","收货人地址信息修改成功!",function(){
				window.location.href="address.jsp";
				});
			}
		});
	  }
		
	}
	//显示添加地址div
	function Show_AddAddress(){
		$("#mask").addClass("mask");
		$("#mask").css("display","block");
		$("#add_address").css("display","block");
		$("#add_address").css("top","0px");
		$("#add_address").animate({"top":'50%',"opacity":1});
		$("#mask").animate({"opacity":1});
		new PCAS("add_prov", "add_city", "add_dist",SPT,SCT,SAT);
	}
	//添加地址方法
	function Add_Address(){
		var add_people = $("#add_people").val();
		var add_phone = $("#add_phone").val();
		var add_zipcode = $("#add_zipcode").val();
		var add_prov = $("#add_prov").val();
		var add_city = $("#add_city").val();
		var add_dist = $("#add_dist").val();
		var add_detailed_address = $("#add_detailed_address").val();
		var re = /^[0-9]{6}$/ //邮编正则表达式验证
		if(add_people.length == 0){
			messageBox("提示","收货人的信息不能为空",function(){});
		}else if(add_phone.length == 0){
			messageBox("提示","收货人联系电话的信息不能为空",function(){});
		}else if(!re.test(add_zipcode)){
			messageBox("提示","收货人的邮编信息格式不正确",function(){});
		}else if(add_prov.length == 0){
			messageBox("提示","省信息不能为空",function(){});
		}else if(add_detailed_address.length == 0){
			messageBox("提示","收货人的街道信息不能为空",function(){});
		}else{
			$.post("/bookshop/add_address",{"people":add_people,"phone":add_phone,"zipcode":add_zipcode,"prov":add_prov,"city":add_city,"dist":add_dist,"detailed_address":add_detailed_address},function(res){
			console.log(res.message);
			if(res.message == "添加成功"){
				messageBox("提示","收货人地址信息添加成功!",function(){
				window.location.href="address.jsp";
				});
			}
		});
		}
		
	}
</script>
</body>
</html>