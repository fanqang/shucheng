package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Book;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class ShowBookServlet
 */
@WebServlet("/showbook")
public class ShowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookServlet() {
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
		String bookISBN = request.getParameter("bookISBN");
		sqlHelper sh = new sqlHelper();
		if(bookISBN == null || "".equals(bookISBN)) {
			responseMap.put("message", "error");
		}else {
			Book book = new Book();
			book.setBookISBN(bookISBN);
			Book bk = sh.queryBookBasisbookISBN(book);
			HashMap<String, Object> map = new HashMap<>();
			String[] str = bk.getBookEvaluate().split("~");
			map.put("bk", bk);
			map.put("bookEvaluate",str);
			List<HashMap<String, Object>> list = new ArrayList<>();
			list.add(map);
			responseMap.put("message", "success");
			responseMap.put("booklist", list);
			HttpSession Session = request.getSession();
			Session.setAttribute("booklist", list);
		}
		sh.CloseConn(); //释放资源
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}
}
