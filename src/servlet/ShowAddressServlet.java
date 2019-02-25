package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Address;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class ShowAddressServlet
 */
@WebServlet("/display_address")
public class ShowAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAddressServlet() {
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
		String id = request.getParameter("id");
		sqlHelper sh = new sqlHelper();
		Address a = sh.queryAddress(Integer.parseInt(id));
		responseMap.put("address", a);
		responseMap.put("message","查询成功");
		sh.CloseConn(); //释放资源
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
