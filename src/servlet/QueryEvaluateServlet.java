package servlet;

import java.io.IOException;
import java.util.HashMap;

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
 * Servlet implementation class QueryEvaluateServlet
 */
@WebServlet("/QueryEvaluate")
public class QueryEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryEvaluateServlet() {
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
		HashMap<String, Object> responseMap = new HashMap<>();
		String bookISBN = request.getParameter("bookISBN");
		sqlHelper sh = null;
		if("".equals(bookISBN) || bookISBN == null ) {
			responseMap.put("message", "数据库查询错误");
		}else {
			sh = new sqlHelper();
			Book value = sh.QueryBookEvaluate(bookISBN);
			String[] str = value.getBookEvaluate().split("~");
			System.out.println(value);
			responseMap.put("book", str);
		}
		sh.CloseConn();
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
