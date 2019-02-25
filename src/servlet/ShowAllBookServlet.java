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
 * Servlet implementation class QueryBookServlet
 */
@WebServlet("/showAllBook")
public class ShowAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllBookServlet() {
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
		sqlHelper sh = new sqlHelper();
		String thisPageNumber = request.getParameter("thisPageNumber");
		int thispagenumber = Integer.parseInt(thisPageNumber);
		List<Book> booklist = sh.queryAllBook(thispagenumber); //调用sql类查询所有图书的方法
		int count = sh.queryBookCount(); // 查询所有图书的数量
		int maxPageNumber = (count/16)+1; // 设置最大的页数
		responseMap.put("booklist", booklist);
		responseMap.put("bookNumber", count);
		responseMap.put("thisPageNumber", thispagenumber);
		responseMap.put("maxPageNumber", maxPageNumber);
		sh.CloseConn();//关闭数据库连接释放资源
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}
}
