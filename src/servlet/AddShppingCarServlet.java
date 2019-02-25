package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class ShppingCarServlet
 */
@WebServlet("/AddShoppingCar")
public class AddShppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShppingCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> responseMap = new HashMap<String,Object>();
		request.setCharacterEncoding("utf-8");
		String bookISBN = request.getParameter("bookISBN");
		String number = request.getParameter("number");
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		sqlHelper sh = new sqlHelper();
		if (bookISBN == null || "".equals(bookISBN)) {//二次验证数据是否为空
			responseMap.put("message", "添加购物车失败");
		}else {
			HttpSession session = request.getSession();
			ArrayList<HashMap<String, Object>> shoppingcar = (ArrayList<HashMap<String, Object>>) session.getAttribute("shoppingcar");//获取购物车session
			if(shoppingcar == null) {//非空验证 如果购物车集合为空则创建新的购物车
				shoppingcar = new ArrayList<>();
			}
			HashMap<String,Object> map = new HashMap<>();
			map.put("bookISBN", bookISBN);
			map.put("number", number);
			map.put("uuid", uuid);
			shoppingcar.add(map); //将map添加到shoppingcar集合内
			System.out.println(shoppingcar);
			session.setAttribute("shoppingcar", shoppingcar);//最后将购物车存入session
			responseMap.put("message", "添加购物车成功");
		}
		sh.CloseConn();
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
