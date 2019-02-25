package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class QueryBook
 */
@WebServlet("/uqeryBook")
public class QueryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> responseMap = new HashMap<String,Object>();
		request.setCharacterEncoding("utf-8");
		String bookName = request.getParameter("book_name");
		String bookAuthor = request.getParameter("book_author");
		String bookPublish = request.getParameter("book_publish");
		String thisPageNum = request.getParameter("thisPageNumber");
		int thisPageNumber = Integer.parseInt(thisPageNum);//强转页面提交过来的参数为int类型
		int maxPageNumber = 0; //初始化最大页数
		int count = 0; //初始化图书数量
		List<Book> booklist = null;
		sqlHelper sh = new sqlHelper();
		//下面是根据用户输入页面的对应文本内容条件模糊查询所对应图书的信息
		if(bookName != null && !"".equals(bookName)) {
			booklist = sh.queryBookName(thisPageNumber,bookName);
			count = sh.queryBookNameCount(bookName);
			maxPageNumber = (count/16)+1;
			System.out.println("图书名数量"+count);
			System.out.println("图书名当前页数"+thisPageNumber);
			System.out.println("图书名最大页数"+maxPageNumber);
		}
		if(bookAuthor != null && !"".equals(bookAuthor)) {
			booklist = sh.queryBookAuthor(thisPageNumber, bookAuthor);
			count = sh.queryBookAuthorCount(bookAuthor);
			maxPageNumber = (count/16)+1;
			System.out.println("作者数量"+count);
			System.out.println("作者当前页数"+thisPageNumber);
			System.out.println("作者最大页数"+maxPageNumber);
		}
		if(bookPublish != null && !"".equals(bookPublish)) {
			booklist = sh.queryBookPublish(thisPageNumber, bookPublish);
			count = sh.queryBookPublishCount(bookPublish);
			maxPageNumber = (count/16)+1;
			System.out.println("出版社数量"+count);
			System.out.println("出版社当前页数"+thisPageNumber);
			System.out.println("出版社最大页数"+maxPageNumber);
		}
		responseMap.put("booklist", booklist);
		responseMap.put("bookNumber", count);
		responseMap.put("thisPageNumber", thisPageNumber);
		responseMap.put("maxPageNumber", maxPageNumber);
		sh.CloseConn();
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
