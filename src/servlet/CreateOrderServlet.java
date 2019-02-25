package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Address;
import com.entity.Book;
import com.entity.Orderform;
import com.entity.Orderitem;
import com.google.gson.Gson;
import com.sqlHelper.sqlHelper;

import responsecontent.ResponseContent;

/**
 * Servlet implementation class Create_OrderServlet
 */
@WebServlet("/CreateOrder")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrderServlet() {
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
		sqlHelper sh = new sqlHelper();
		String uuid = UUID.randomUUID().toString();//创建uuid
		HttpSession session = request.getSession();
		String user_name = (String) session.getAttribute("success");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String sumprice = request.getParameter("sumprice");
		System.out.println(name);
		System.out.println(sumprice);
		ArrayList<HashMap<String, Object>> shoppingcar = (ArrayList<HashMap<String, Object>>) session.getAttribute("shoppingcar");//获取购物车session存入的图书
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();//创建一个list集合用于存储遍历shoppingcar后的数据
		for (HashMap<String, Object> Book : shoppingcar) {//遍历shoppingcar
			 HashMap<String, Object> bookinfo = new HashMap<>();//创建一个HashMap
			 bookinfo.put("bookISBN", Book.get("bookISBN"));
			 bookinfo.put("count", Book.get("number"));
			 list.add(bookinfo);//将HashMap存入list集合
		}
		System.out.println(uuid);
		shoppingcar.clear();//销毁shoppingcar购物车内的所有数据
		Address aa = new Address();
		aa.setCollect_people(name);
		Address address = sh.queryaddress(aa);
		Orderform or = new Orderform(uuid, new Date(), Float.parseFloat(sumprice), address.getCollect_people(), address.getTelephone(), address.getAddress(),"未结算",user_name);
		sh.InsertOrderForm(or);//讲需要的订单信息插入订单条目表
		System.out.println(shoppingcar.size());
		for (HashMap<String, Object> Books : list) {//遍历list集合根据内部hashMap存入的键值获取对应的数据
			String bookISBN = (String)Books.get("bookISBN");
			String count = (String)Books.get("count");
			Book book = sh.queryBookISBN(bookISBN);
			Orderitem orderitem = new Orderitem(0, uuid, bookISBN, book.getBookPrice(), Integer.parseInt(count), 0);
			sh.InsertOrderItem(orderitem);//讲需要的订单信息插入订单表
		}
		responseMap.put("name", name);
		responseMap.put("message", "创建订单成功！");//存入一个信息，用于前端回调函数判断订单是否成功创建
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
	}

}
