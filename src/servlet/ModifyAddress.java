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
 * Servlet implementation class ModifyAddress
 */
@WebServlet("/modify_address")
public class ModifyAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyAddress() {
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
		int id =Integer.parseInt(request.getParameter("id"));
		String people = request.getParameter("people");
		String phone = request.getParameter("phone");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String prov = request.getParameter("prov");
		String city = request.getParameter("city");
		String dist = request.getParameter("dist");
		String detailed_address = request.getParameter("detailed_address");
		String address = prov+city+dist+detailed_address;
		sqlHelper sh = new sqlHelper();
		Address a = new Address(id, people, phone, zipcode, address);
		if(sh.UpdateAddress(a)) {
			responseMap.put("message", "修改成功");
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
