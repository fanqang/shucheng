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


import com.google.gson.Gson;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class DeleteShoppingCar
 */
@WebServlet("/deleteShoppingCarBook")
public class DeleteShoppingCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShoppingCar() {
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
		String newuuid = request.getParameter("uuid");
		System.out.println(newuuid+"新");
		HttpSession session = request.getSession();
		ArrayList<HashMap<String, Object>> shoppingcar = (ArrayList<HashMap<String, Object>>)session.getAttribute("shoppingcar");
		for (int i=0; i<shoppingcar.size(); i++) {
			HashMap<String, Object> item = shoppingcar.get(i);
			String uuid = item.get("uuid").toString();
			System.out.println(uuid+"老");
			if(newuuid.equals(uuid)) {
				shoppingcar.remove(i);
				responseMap.put("message", "删除成功！");
			}
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
