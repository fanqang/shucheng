package servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.User;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/insertUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		Map<String, Object> responseMap = new HashMap<>();// 准备返回到页面的数据
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();//获取用户
		
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String user_re_pwd = request.getParameter("user_re_pwd");
		sqlHelper sh = null;
		if("".equals(user_name) || user_name == null || "".equals(user_pwd) || user_pwd == null || "".equals(user_re_pwd) || user_re_pwd == null || !user_pwd.equals(user_re_pwd)) {
			responseMap.put("message", "用户信息填写不正确，请重新填写！");
		}else {
			sh = new sqlHelper();
			User user = new User(user_name, user_pwd);
			sh.insertUser(user);
			responseMap.put("message", "注册成功");
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
