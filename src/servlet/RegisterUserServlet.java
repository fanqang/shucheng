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
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		sqlHelper sh = new sqlHelper();
		User us = new User();
		us.setUser_name(user_name);
		System.out.println("用户名:"+user_name+"密码:"+user_pwd);
		if("".equals(user_name) || user_name == null || "".equals(user_pwd) || user_pwd == null ) { //������֤ǰ���ύ������
			responseMap.put("message", "error");
		}else if(sh.queryUser(us) != null) {
			responseMap.put("message", "该用户已被注册");
		}else if(sh.queryUser(us) == null){
			User user = new User();
			user.setUser_name(user_name);
			user.setUser_pwd(user_pwd);
			sh.insertUser(user);
			responseMap.put("message", "注册成功");
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
