package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
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
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		sqlHelper sh = null;
		System.out.println("用户名:"+user_name+"密码:"+user_pwd);
		if("".equals(user_name) || user_name == null || "".equals(user_pwd) || user_pwd == null ) { //二次验证前端提交的数据
			responseMap.put("message", "失败");
		}else {
			sh = new sqlHelper();
			User us = new User();
			us.setUser_name(user_name);
			User user = sh.queryUser(us);
			if(user.getUser_pwd().equals(user_pwd)) { //当前密码与数据库密码一致则登录成功
				HttpSession Session = request.getSession();
				Session.setAttribute("success", user_name);
				responseMap.put("message", "成功");
			}else {
				responseMap.put("message", "失败");
			}
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
