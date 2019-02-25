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
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/add_address")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
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
		String people = request.getParameter("people");
		String phone = request.getParameter("phone");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String prov = request.getParameter("prov");
		String city = request.getParameter("city");
		String dist = request.getParameter("dist");
		String detailed_address = request.getParameter("detailed_address");
		String address = prov+city+dist+detailed_address;
		sqlHelper sh = new sqlHelper();
		Address a = new Address();
		a.setCollect_people(people);
		a.setTelephone(phone);
		a.setZipcode(zipcode);
		a.setAddress(address);
		if(sh.AddAddress(a)) {
			responseMap.put("message", "添加成功");
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
