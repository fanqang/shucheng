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
 * Servlet implementation class NotEvaluateServlet
 */
@WebServlet("/notevaluate")
public class NotEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotEvaluateServlet() {
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
		sqlHelper sh = new sqlHelper();
		if (sh.queryOrderItem_commentstatus() == 0) {
			responseMap.put("evaluate", "null");
		}else {
			 List<Orderform> orderformList = sh.queryOrderFormList_orderstatus_true();
			  List<Object> orderItemList;
			  List<Object> orderList = new ArrayList<>();
			  for (Orderform orderform : orderformList) {
				  orderItemList = new ArrayList<>();
				  String orderno = orderform.getOrderNO();
				  Orderform odf = new Orderform();
				  odf.setOrderNO(orderno);
				  List<Orderform> orderNO = sh.queryOrderNO_orderstatus_true(odf);
				  HashMap<String, Object> maps = new HashMap<>();
				  maps.put("time", orderform.getTime());
				  maps.put("name", orderform.getName());
				  maps.put("phone", orderform.getPhone());
				  maps.put("address", orderform.getAddress());
				  maps.put("sumPrice", orderform.getSumprice());
				  maps.put("user_name", orderform.getUser_name());
				  maps.put("orderstatus", orderform.getOrderstatus());
				  maps.put("orderNO", orderform.getOrderNO());
				  maps.put("orderItemList", orderItemList);
				  orderList.add(maps);
		      for (Orderform orderform2 : orderNO) {
				  Orderitem orderitem = new Orderitem();
				  orderitem.setOrderNO(orderform2.getOrderNO());
				  List<Orderitem> orderitems = sh.queryOrderItemBookISBNAndBookPriceAndCountList(orderitem);
			  for (Orderitem orderitem2 : orderitems) {
				  HashMap<String, Object> map = new HashMap<>();
				  Book book = sh.queryBookISBN(orderitem2.getBookISBN());
				  map.put("ID", orderitem2.getID());
				  map.put("book", book);
				  map.put("bookPrice",orderitem2.getBookPrice());
				  map.put("count",orderitem2.getCount());
				  map.put("commentstatus", orderitem2.getCommentstatus());
				  orderItemList.add(map);
				  System.out.println(orderItemList);
				}
			}
				  
	}
			  HashMap<String, Object> orderMap = new HashMap<>();
			  orderMap.put("message", "获取待评价订单成功");
			  orderMap.put("orderList", orderList);
			  responseMap.put("notevaluateList", orderMap);
		}
		ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		sh.CloseConn();
 	}

}
