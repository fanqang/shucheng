package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * Servlet implementation class ShoppingCarServlet
 */
@WebServlet("/ShoppingCar")
public class ShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCarServlet() {
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
		HttpSession session = request.getSession();
		ArrayList<HashMap<String, Object>> shoppingcar = (ArrayList<HashMap<String, Object>>) session.getAttribute("shoppingcar");
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		if(shoppingcar == null || shoppingcar.size() <= 0) {
			responseMap.put("message", "null");
		}else {
			for (HashMap<String, Object> book : shoppingcar) {
			Book value = sh.queryBookISBN(book.get("bookISBN").toString());
			HashMap<String, Object> bookInfo = new HashMap<>();
			bookInfo.put("number", book.get("number"));
			bookInfo.put("book",value);
			bookInfo.put("uuid",book.get("uuid"));
			list.add(bookInfo);
			responseMap.put("list", list);
			responseMap.put("message", "查询成功！");
			System.out.println(value);
			}
		}
		sh.CloseConn();
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
