<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="nav/nav.jsp"%>
<%
		String username = (String)session.getAttribute("success");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>浏览图书</title>
<script type="text/javascript" src="../js/jQuery-2.1.4.min.js" ></script>
<link rel="stylesheet" href="../css/nav.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="shortcut icon" href="/bookshop/img/favicon.png">
<script type="text/javascript"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background: #f4f5f7;
	}
	.div_bottom{
		width: 1000px;
		height: 1320px;
		background: #f4f5f7;
		margin:0 auto;
		margin-bottom: -10px;
		margin-top: 10px;
	}
	.query{
		width: 1000px;
		height: 150px;
		background: #FFFFFF;
		margin: 0 auto;
		border-radius: 10px;
	}
	.query_son1{
		width: 912px;
		height: 50px;
		line-height: 50px;
		text-align: left;
	}
	.query_son1 h2{
		margin-left: 10px;
		font-weight: bold;
		font-family: "楷体";
		text-shadow: 0 0 0.2em #F87, 0 0 0.2em #F87;
	}
	.query_son2{
		width: 912px;
		height: 50px;
		line-height: 50px;
		text-align: left;
		margin-left: 10px;
		font-family: "楷体";
		font-weight: bold;
	}
	.paging{
		width: 912px;
		height: 50px;
		line-height: 50px;
		margin-left: 10px;
		font-family: "楷体";
	}
	.paging span{
		color: #FF4559;
		font-weight: bold;
	}
	.paging button{
		width:60px;
		height:25px;
		line-height:25px;
		border: 1px solid #EC5851;
		color: #EC5851;
		text-align: center;
		margin-left: 5px;
		background: white;
		outline: none;
	}
	.paging button:hover{
		background-color: pink;
		color: #FFFFFF;
	}
	#book_name{
		width: 180px;
		height: 30px;
	}
	#book_author{
		width: 180px;
		height: 30px;
	}
	#book_publish{
		width: 180px;
		height: 30px;
	}
	#query_book{
		width: 80px;
		height: 30px;
		background: white;
		color: #EC5851;
		border: 1px solid #EC5851;
		outline: none;
	}
	#query_book:hover{
		background-color: pink;
		color: #FFFFFF;
	}
	#reset{
		width: 40px;
		height: 30px;
		background: white;
		color: #EC5851;
		border: 1px solid #EC5851;
		outline: none;
	}
	#reset:hover{
		background-color: pink;
		color: #FFFFFF;
	}
	.book{
		width: 1000px;
		margin: 0 auto;
		margin: 0;
		padding: 0;
	}
	.book .book_son{
		width: 240px;
		height: 278px;
		margin-top: 10px;
		margin-right: 10px;
		background-color: #FFFFFF;
		border: 1px solid #FFFFFF;
		border-radius: 10px;
		float: left;
		transition: all 400ms;
	}
	.book .book_son:hover{
		border: 1px solid #EC5851;
	}
	div.book div.book_son:nth-child(4n) {
	/*每一行的最后一个应用这个样式（4的倍数）*/
	margin-right: 0px;
}

	.bookimgdiv{
		width: 150.25px;
		height: 185px;
		margin: 0 auto;
		margin-top: 10px;
	}
	.bookimgclass{
		width: 150.25px;
		height: 185px;
		margin: 0 auto;
		margin-top: 1px;
	}
	.bookprice{
		color: #EA5474;
		font-weight: bold;
		margin-left: 15px;
	}
	.bookname{
		width: 200.5px;
		height: 20px;
		font-size: 17px;
		font-weight: bold;
		color: #727475;
		margin-left: 18px;
		display: block;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	.book_bottom{
		width: 200.5px;
		margin-left: 18px;
		height: 20px;
		font-size: 13px;
		font-weight: bold;
		color: #CCC;
	}
	.book_bottom_left{
		width: 90px;
		height: 20px;
		line-height: 20px;
		float: left;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.book_bottom_right{
		width: 90px;
		height: 20px;
		line-height: 20px;
		float: right;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
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
		<div class="div_bottom" id="div_bottom">
			<div class="query">
				<div class="query_son1">
					<h2>搜索图书</h1>
				</div>
				<div class="query_son2">
					<form id="form" onsubmit="return func()">
						书名: <input type="text" id="book_name" name="book_name"/>
						作者: <input type="text" id="book_author" name="book_author"/>
						出版社: <input type="text" id="book_publish" name="book_publish"/>
						<button id="query_book" onclick="query()">查询图书</button>
						<button id="reset" type="reset">清空</button>
					</form>
				</div>
				<div class="paging">
				共查找到<span id="bookNumber"></span>本图书,当前显示第<span id="thisPageNumber"></span>页,共<span id="maxPageNumber"></span>页  
				<button onclick="first()">首    页</button>
				<button onclick="previous()">上一页</button>
				<button onclick="next()">下一页</button>
				<button onclick="last()">尾    页</button>
				</div>
			</div>
			<div class="book" id="booklist">
					
			</div>
		</div>
		<%@ include file="footer/footer.jsp"%>
	<script>
		
		window.$thisPageNumber =parseInt($("#thisPageNumber").text()); //获取当前显示的页数
		window.onload = function(){
			var username="<%=username%>"; //获取登录成功时session保存的登录名
			if(username != "null"){   //用户名不为空就将用户显示在导航栏右侧
				$("#nav_login_img").show();
				$("#nav_login_message").show();
			}
			if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
				first(); //搜索栏信息初始化默认显示第1页
			}else{
				window.$thisPageNumber = 1;
				query();
			}
		}
		//首页按钮方法
		function first(){
			if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
				window.$thisPageNumber = 1;
				Submission();
			}else{
				window.$thisPageNumber = 1;
				query();
			}
			
		}
		//上一页按钮方法
		function previous(){
			if(window.$thisPageNumber <= 1){
				if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
					first();
				}else{
					window.$thisPageNumber = 1;
					query();
				}	
			}else{
				if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
					window.$thisPageNumber = window.booklistdata.thisPageNumber - 1;
					Submission();
				}else{
					window.$thisPageNumber = window.booklistdata.thisPageNumber - 1;
					query();
				}
				
			}
		}
		//下一页按钮方法
		function next(){
			if(window.$thisPageNumber >= window.booklistdata.maxPageNumber){
				if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
					last();
				}else{
					window.$thisPageNumber = window.booklistdata.maxPageNumber;
					query();
				}
			}else{
				if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
					window.$thisPageNumber = window.booklistdata.thisPageNumber + 1;
					Submission();
				}else{
					window.$thisPageNumber = window.booklistdata.thisPageNumber + 1;
					query();
				}
			}
		}
		//最后一页按钮方法
		function last(){
				if($("#book_name").val() == "" && $("#book_author").val() == "" && $("#book_publish").val() == ""){
					window.$thisPageNumber = window.booklistdata.maxPageNumber;
					Submission();
				}else{
					window.$thisPageNumber = window.booklistdata.maxPageNumber;
					query();
				}
		}
		//根据页面当前显示的页数查询对应的图书
		function Submission(){
			var parameter = $("#form").serialize();
			 	parameter+="&thisPageNumber="+window.$thisPageNumber;
				$.ajax({
						    type:"post",
						    url:"/bookshop/showAllBook",      
						    data:parameter,      
						    dataType:"json",
						    success:function(res){
						    console.log(res.booklist);
						    window.booklistdata = res;
						    var bookListHtml = "";
						    var booklist = res.booklist;
						    for(var i in booklist){
						    	bookListHtml += "<div class='book_son'><div class='bookimgdiv'><a href='/bookshop/admin/ShowBook.jsp?bookISBN="+ booklist[i].bookISBN +"'><img class='bookimgclass' src='/bookshop/img/bookPic/" + booklist[i].bookISBN + booklist[i].bookPic + " '/></a></div>";
						    	bookListHtml += "<span class='bookprice'>￥"+ booklist[i].bookPrice +"</span></br>";
						    	bookListHtml += "<a class='bookname'>" + booklist[i].bookName + "</a>";
						    	bookListHtml += "<div class='book_bottom'><div class='book_bottom_left'>" + booklist[i].bookPublish + "</div><div class='book_bottom_right'>" + booklist[i].bookAuthor + "</div></div>";
						    	bookListHtml += "</div>";
						    }
						    console.log(res);
						    $("#booklist").html(bookListHtml);
						   	$("#bookNumber").html(res.bookNumber);
						    $("#thisPageNumber").html(res.thisPageNumber);
						    $("#maxPageNumber").html(res.maxPageNumber);
						    }
						});
		}
		//查询方法
		function query(){
			var parameter = $("#form").serialize();
				parameter+="&thisPageNumber="+window.$thisPageNumber;
						console.log("");
						$.post("/bookshop/uqeryBook",parameter,function(res){
							 console.log(res.bookISBN);
							 window.booklistdata = res;
						    var bookListHtml = "";
						    var booklist = res.booklist;
						    for(var i in booklist){
						    	bookListHtml += "<div class='book_son'>";
						    	bookListHtml +=	"<div class='bookimgdiv'>";
						    	bookListHtml += "<a href='/bookshop/admin/ShowBook.jsp?bookISBN=" + booklist[i].bookISBN + "'><img class='bookimgclass' src='/bookshop/img/bookPic/" + booklist[i].bookISBN + booklist[i].bookPic + "'/></a>";
						    	bookListHtml += "</div>";
						    	bookListHtml += "<span class='bookprice'>￥"+ booklist[i].bookPrice +"</span></br>";
						    	bookListHtml += "<a class='bookname'>" + booklist[i].bookName + "</a>";
						    	bookListHtml += "<div class='book_bottom'><div class='book_bottom_left'>" + booklist[i].bookPublish + "</div><div class='book_bottom_right'>" + booklist[i].bookAuthor + "</div></div>";
						    	bookListHtml += "</div>";
						    	
						    }
						    $("#booklist").html(bookListHtml);
						   	$("#bookNumber").html(res.bookNumber);
						    $("#thisPageNumber").html(res.thisPageNumber);
						    $("#maxPageNumber").html(res.maxPageNumber);
						},"json");
		}
		
		/*阻止表单提交默认地址*/
		 function func(){
            return false;
        }
	</script>
</body>
</html>