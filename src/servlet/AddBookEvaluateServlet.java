package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

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
 * Servlet implementation class AddBookEvaluateServlet
 */
@WebServlet("/AddBookEvaluate")
public class AddBookEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookEvaluateServlet() {
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
		request.setCharacterEncoding("utf-8");
		String bookISBN = request.getParameter("bookISBN");
		String text = request.getParameter("text");
		String orderNO = request.getParameter("orderNO");
		String ID = request.getParameter("ID");
		sqlHelper sh = new sqlHelper();
		sh.UpdateOrderItem_commentstatus(bookISBN, orderNO,ID);
		System.out.println(bookISBN+"--"+text+"--"+ID);
		HttpSession session = request.getSession();
		String logname = (String) session.getAttribute("success");
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String time = df.format(date);
		Book book = new Book();
		book.setBookEvaluate(logname+"&nbsp&nbsp&nbsp" +time+"&nbsp&nbsp&nbsp"+ text+"~");
		book.setBookISBN(bookISBN);
		if(sh.UpdateBookEvaluate(book)) {
			responseMap.put("message", "执行更新成功");
		}else {
			responseMap.put("message", "执行更新失败");
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
