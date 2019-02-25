package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
 * Servlet implementation class DeleteAddressServlet
 */
@WebServlet("/deleteaddress")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressServlet() {
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
		int new_id = Integer.parseInt(id); //强转成int类型用于后面判断
		sqlHelper sh = new sqlHelper();
		List<Address> list = sh.queryAddress(); //调用sql查询方法
		for(int i=0;i<list.size();i++) { //循环判断
			int old_id = list.get(i).getID();
			if(new_id == old_id) {//如果条件匹配成功则执行sql删除方法，删除指定的条目
				sh.DeleteAddress(new_id);
				responseMap.put("message", "删除成功");
			}
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
