package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.entity.Orderform;
import com.entity.Orderitem;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class UpdateStateServlet
 */
@WebServlet("/ModifyState")
public class UpdateStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStateServlet() {
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
		 String orderNO = request.getParameter("orderNO");
		 sqlHelper sh = new sqlHelper();
		 Orderform orderform = new Orderform();
		 orderform.setOrderNO(orderNO);
		 if(sh.UpdateQueryOrderForm_orderstatus(orderform)) {
		 responseMap.put("message", "执行更新成功");
		 }
		 sh.CloseConn();//释放资源
		 ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
	}

}
