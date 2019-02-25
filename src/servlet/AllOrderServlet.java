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
 * Servlet implementation class AllOrderServlet
 */
@WebServlet("/allorder")
public class AllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrderServlet() {
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
		 if(sh.queryOrderFormCount() == 0) {
				responseMap.put("message", "null");
			}else {
				  List<Orderform> orderformList = sh.queryAllOrderFormList();
				  List<Object> orderItemList;
				  List<Object> orderList = new ArrayList<>();
				  for (Orderform orderform : orderformList) {
					  orderItemList = new ArrayList<>();
					  String orderno = orderform.getOrderNO();
					  Orderform odf = new Orderform();
					  odf.setOrderNO(orderno);
					  List<Orderform> orderNO = sh.queryOrderNO_condition_orderNO(odf);
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
					  List<Orderitem> orderitems = sh.queryOrderItemBookISBNAndBookPriceAndCountAndCommentstatusList(orderitem);
				  for (Orderitem orderitem2 : orderitems) {
					  HashMap<String, Object> map = new HashMap<>();
					  Book book = sh.queryBookISBN(orderitem2.getBookISBN());
					  map.put("book", book);
					  map.put("bookPrice",orderitem2.getBookPrice());
					  map.put("count",orderitem2.getCount());
					  map.put("commentstatus",orderitem2.getCommentstatus());
					  map.put("id",orderitem2.getID());
					  orderItemList.add(map);
					}
				}
					  
		}
				  HashMap<String, Object> orderMap = new HashMap<>();
				  orderMap.put("message", "获取所有订单成功");
				  orderMap.put("orderList", orderList);
				  responseMap.put("AllorderList", orderMap);
		}
		 ResponseContent.setContentAtJson(response, new Gson().toJson(responseMap));
		 sh.CloseConn();
	}

}
