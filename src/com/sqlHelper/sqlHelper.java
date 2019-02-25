package com.sqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.entity.Address;
import com.entity.Book;
import com.entity.Orderform;
import com.entity.Orderitem;
import com.entity.User;




public class sqlHelper {
	public Connection conn = null;
	private int pageNum = 16;//每页显示的图书数量
	public sqlHelper() {
		conn = DB.getconnection();
	}
	
	//关闭数据库连接
	public void CloseConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加会员信息
	 * @param u
	 * @return
	 */
	public boolean insertUser(User u) {
		String sql = "INSERT INTO user (user_name,user_pwd) VALUES (?,?);";
		boolean flage = false;
		PreparedStatement ps;
		try {
			sqlHelper sh = new sqlHelper();
			User user = sh.queryUser(u);
			if(user != null) {
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUser_name());
			ps.setString(2, u.getUser_pwd());
			ps.execute();
			flage = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flage;
	}
	/**
	 * 查询会员
	 * @param u
	 * @return
	 */
	public User queryUser(User u) {
		String sql = "select * from user where user_name = ?";
		User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUser_name());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUser_name(rs.getString("user_name"));
				user.setUser_pwd(rs.getString("user_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 通过图书名查询图书
	 * @param b
	 * @return
	 */
	public List<Book> queryBookName(int thisPageNumber,String bookName) {
		String sql = "select * from book where bookName like '%"+ bookName +"%' LIMIT " + (thisPageNumber - 1)*pageNum + "," + pageNum + "";
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookPublish(rs.getString("bookPublish"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过bookISBN查询图书
	 * @param bookISBN
	 * @return
	 */
	public Book queryBookISBN(String bookISBN){
		String sql = "select * from book where bookISBN = ?";
		Book book = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookISBN);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookName(rs.getString("bookName"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				book.setBookPublish(rs.getString("bookPublish"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * 通过bookName查询图书
	 * @param bookISBN
	 * @return
	 */
	public Book queryBookName(String bookName){
		String sql = "select * from book where bookName = ?";
		Book book = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookName(rs.getString("bookName"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				book.setBookPublish(rs.getString("bookPublish"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * 通过图书作者查询图书
	 * @param b
	 * @return
	 */
	public List<Book> queryBookAuthor(int thisPageNumber,String bookAuthor) {
		String sql = "select * from book where bookAuthor like '%"+ bookAuthor +"%' LIMIT " + (thisPageNumber - 1)*pageNum + "," + pageNum + "";
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookPublish(rs.getString("bookPublish"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过图书出版社查询图书
	 * @param b
	 * @return
	 */
	public List<Book> queryBookPublish(int thisPageNumber,String bookPublish) {
		String sql = "select * from book where bookPublish like '%"+ bookPublish +"%' LIMIT " + (thisPageNumber - 1)*pageNum + "," + pageNum + "";
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookPublish(rs.getString("bookPublish"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询所有图书
	 * @param thisPageNumber
	 * @return
	 */
	public List<Book> queryAllBook(int thisPageNumber) {
		String sql = "select * from book LIMIT " + (thisPageNumber - 1)*pageNum + "," + pageNum + "";
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookISBN(rs.getString("bookISBN"));
				book.setBookPic(rs.getString("bookPic"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getFloat("bookPrice"));
				book.setBookPublish(rs.getString("bookPublish"));
				book.setBookAbstract(rs.getString("bookAbstract"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询所有图书的数量
	 * @return
	 */
	public int queryBookCount() {
		int count =0;
		String sql = "select count(*) from book";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据图书名称查询数量
	 * @return
	 */
	public int queryBookNameCount(String bookName) {
		int count =0;
		String sql = "select count(*) from book where bookName like '%"+ bookName +"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据图书作者查询图书数量
	 * @param bookName
	 * @return
	 */
	public int queryBookAuthorCount(String bookAuthor) {
		int count =0;
		String sql = "select count(*) from book where bookAuthor like '%"+ bookAuthor +"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据图书出版社查询图书数量
	 * @param bookName
	 * @return
	 */
	public int queryBookPublishCount(String bookPublish) {
		int count = 0;
		String sql = "select count(*) from book where bookPublish like '%"+ bookPublish +"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据图书ISBN查询图书所有信息
	 * @param b
	 * @return
	 */
	public Book queryBookBasisbookISBN(Book b) {
			String sql = "select * from book where bookISBN = ?";
			Book book = null;
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, b.getBookISBN());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					book = new Book();
					book.setBookName(rs.getString("bookName"));
					book.setBookPic(rs.getString("bookPic"));
					book.setBookISBN(rs.getString("bookISBN"));
					book.setBookAuthor(rs.getString("bookAuthor"));
					book.setBookPublish(rs.getString("bookPublish"));
					book.setBookPrice(rs.getFloat("bookPrice"));
					book.setBookAbstract(rs.getString("bookAbstract"));
					book.setBookEvaluate(rs.getString("bookEvaluate"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return book;
	}
	/**
	 * 查询所有收货地址
	 * @return
	 */
	public List<Address> queryAddress() {
		String sql = "select * from address";
		Address a = null;
		List<Address> list = new ArrayList<Address>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Address();
				a.setID(rs.getInt("ID"));
				a.setCollect_people(rs.getString("collect_people"));
				a.setTelephone(rs.getString("telephone"));
				a.setZipcode(rs.getInt("zipcode"));
				a.setAddress(rs.getString("address"));
				list.add(a);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 根据address表主键ID查询对应的address对象
	 * @param id
	 * @return
	 */
	public Address queryAddress(int id) {
		String sql = "SELECT * from address WHERE ID = ?";
		Address address = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				address = new Address();
				address.setID(rs.getInt("ID"));
				address.setCollect_people(rs.getString("collect_people"));
				address.setTelephone(rs.getString("telephone"));
				address.setZipcode(rs.getInt("zipcode"));
				address.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}
	public boolean AddAddress(Address a) {
		String sql = "INSERT INTO address (collect_people,telephone,zipcode,address) VALUES (?,?,?,?)";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getCollect_people());
			ps.setString(2, a.getTelephone());
			ps.setInt(3, a.getZipcode());
			ps.setString(4, a.getAddress());
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 根据地址表的主键ID删除对应表的条目
	 * @param id
	 * @return
	 */
	public boolean DeleteAddress(int id) {
		String sql = "DELETE  FROM address WHERE ID = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 根据地址表主键ID修改地址信息
	 * @param a
	 * @return
	 */
	public boolean UpdateAddress(Address a) {
		String sql = "UPDATE address SET collect_people = ?,telephone = ?,zipcode = ?,address = ? WHERE ID = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,a.getCollect_people());
			ps.setString(2, a.getTelephone());
			ps.setInt(3, a.getZipcode());
			ps.setString(4, a.getAddress());
			ps.setInt(5, a.getID());
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 添加订单条目表
	 * @param or
	 * @return
	 */
	public boolean InsertOrderForm(Orderform or) {
		String sql = "insert into orderform (orderNO,time,sumprice,name,phone,address,orderstatus,user_name) VALUES (?,?,?,?,?,?,?,?)";
		boolean flag = false;
		PreparedStatement ps;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String timestr = df.format(or.getTime());// new Date()为获取当前系统时间
			ps = conn.prepareStatement(sql);
			ps.setString(1, or.getOrderNO());
			ps.setString(2, timestr);
			ps.setFloat(3, or.getSumprice());
			ps.setString(4, or.getName());
			ps.setString(5, or.getPhone());
			ps.setString(6, or.getAddress());
			ps.setString(7, or.getOrderstatus());
			ps.setString(8, or.getUser_name());
			ps.execute();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 添加订单表
	 * @param or
	 * @return
	 */
	public boolean InsertOrderItem(Orderitem or) {
		String sql = "insert into orderitem (orderNO,bookISBN,bookPrice,count,commentstatus) VALUES (?,?,?,?,?)";
		boolean flag = false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, or.getOrderNO());
			ps.setString(2, or.getBookISBN());
			ps.setFloat(3, or.getBookPrice());
			ps.setInt(4, or.getCount());
			ps.setInt(5, or.getCommentstatus());
			ps.execute();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 查询所有订单条目
	 * @return
	 */
	public List<Orderform> queryOrderFormList(){
		String sql = "select * from orderform where orderstatus = '未结算' order by time desc";
		Orderform order = null;
		List<Orderform> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Orderform();
				order.setOrderNO(rs.getString("orderNO"));
				order.setTime(rs.getTimestamp("time"));
				order.setSumprice(rs.getFloat("sumprice"));
				order.setName(rs.getString("name"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setOrderstatus(rs.getString("orderstatus"));
				order.setUser_name(rs.getString("user_name"));
				list.add(order);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询所有已结算订单条目
	 * @return
	 */
	public List<Orderform> queryOrderFormList_orderstatus_true(){
		String sql = "select * from orderform where orderstatus = '已结算' order by time desc";
		Orderform order = null;
		List<Orderform> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Orderform();
				order.setOrderNO(rs.getString("orderNO"));
				order.setTime(rs.getTimestamp("time"));
				order.setSumprice(rs.getFloat("sumprice"));
				order.setName(rs.getString("name"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setOrderstatus(rs.getString("orderstatus"));
				order.setUser_name(rs.getString("user_name"));
				list.add(order);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询所有订单条目
	 * @return
	 */
	public List<Orderform> queryAllOrderFormList(){
		String sql = "select * from orderform order by time desc";
		Orderform order = null;
		List<Orderform> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Orderform();
				order.setOrderNO(rs.getString("orderNO"));
				order.setTime(rs.getTimestamp("time"));
				order.setSumprice(rs.getFloat("sumprice"));
				order.setName(rs.getString("name"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setOrderstatus(rs.getString("orderstatus"));
				order.setUser_name(rs.getString("user_name"));
				list.add(order);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/***
	 * 查询订单条目表的收货人姓名
	 * @return
	 */
	public List<Orderform> queryOrderName(){
		String sql = "SELECT name from orderform";
		Orderform orderform;
		List<Orderform> list = new ArrayList<>();
		try {
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   orderform = new Orderform();
			   orderform.setName(rs.getString("name"));
			   list.add(orderform);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过收货人查询待结算订单编号
	 * @param name
	 * @return
	 */
	public List<Orderform> queryOrderNO_condition_name(Orderform name){
		String sql = "SELECT orderNO from orderform WHERE name= ? and orderstatus = '未结算'";
		Orderform orderform;
		List<Orderform> list = new ArrayList<>();
		try {
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, name.getName());
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   orderform = new Orderform();
			   orderform.setOrderNO(rs.getString("orderNO"));
			   list.add(orderform);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过收货人查询待评价订单编号
	 * @param name
	 * @return
	 */
	public List<Orderform> queryOrderNO_orderstatus_true(Orderform or){
		String sql = "SELECT orderNO from orderform WHERE orderNO = ? and orderstatus = '已结算'";
		Orderform orderform;
		List<Orderform> list = new ArrayList<>();
		try {
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, or.getOrderNO());
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   orderform = new Orderform();
			   orderform.setOrderNO(rs.getString("orderNO"));
			   list.add(orderform);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过收货人查询待结算订单编号
	 * @param name
	 * @return
	 */
	public List<Orderform> queryOrderNO_condition_orderNO(Orderform orderNO){
		String sql = "SELECT orderNO from orderform WHERE orderNO = ?";
		Orderform orderform;
		List<Orderform> list = new ArrayList<>();
		try {
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, orderNO.getOrderNO());
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   orderform = new Orderform();
			   orderform.setOrderNO(rs.getString("orderNO"));
			   list.add(orderform);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过收货地址人查询地址表所有成员信息
	 * @param a
	 * @return
	 */
	public Address queryaddress(Address a){
		String sql = "select * from address where collect_people = ?";
		Address address = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getCollect_people());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				address = new Address();
				address.setCollect_people(rs.getString("collect_people"));
				address.setTelephone(rs.getString("telephone"));
				address.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}
	/**
	 * 查询未结算订单的数量
	 * @return
	 */
	public int queryOrderFromOrderStatus() {
		String sql = "SELECT count(*) from orderform WHERE orderstatus = '未结算'";
		int count = 0 ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 查询未评价订单的数量
	 * @return
	 */
	public int queryOrderItem_commentstatus() {
		String sql = "SELECT count(*) from orderitem WHERE commentstatus = '0' and orderNO in (SELECT orderNO from orderform WHERE orderstatus='已结算')";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 查询所有订单的数量
	 * @return
	 */
	public int queryOrderFormCount() {
		String sql = "SELECT count(*) FROM orderform";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 通过订单条目的编号查询图书ISBN，价格，和数量等信息
	 * @param or
	 * @return
	 */
	public List<Orderitem> queryOrderItemBookISBNAndBookPriceAndCountList(Orderitem or){
		String sql = "SELECT ID,bookISBN,bookPrice,count from orderitem WHERE orderNO = ? and commentstatus = 0";
		Orderitem order = null;
		List<Orderitem> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, or.getOrderNO());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Orderitem();
				order.setID(rs.getInt("ID"));
				order.setBookISBN(rs.getString("bookISBN"));
				order.setBookPrice(rs.getFloat("bookPrice"));
				order.setCount(rs.getInt("count"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过订单条目的编号查询图书ISBN，价格，数量和书评状态等信息
	 * @param or
	 * @return
	 */
	public List<Orderitem> queryOrderItemBookISBNAndBookPriceAndCountAndCommentstatusList(Orderitem or){
		String sql = "SELECT ID,bookISBN,bookPrice,count,commentstatus from orderitem WHERE orderNO = ?";
		Orderitem order = null;
		List<Orderitem> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, or.getOrderNO());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Orderitem();
				order.setID(rs.getInt("ID"));
				order.setBookISBN(rs.getString("bookISBN"));
				order.setBookPrice(rs.getFloat("bookPrice"));
				order.setCount(rs.getInt("count"));
				order.setCommentstatus(rs.getInt("commentstatus"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 更新订单条目表中订单的状态
	 * @return
	 */
	public boolean UpdateQueryOrderForm_orderstatus(Orderform or) {
		String sql = "UPDATE orderform SET orderstatus = '已结算' WHERE orderstatus = '未结算' and orderNO = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, or.getOrderNO());
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 更新图书表的评价
	 * @param bookevaluate
	 * @param bookISBN
	 * @return
	 */
	public boolean UpdateBookEvaluate(Book book) {
		String sql = "UPDATE book SET bookEvaluate=CONCAT(bookEvaluate,?) WHERE bookISBN = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookEvaluate());
			ps.setString(2, book.getBookISBN());
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean UpdateOrderItem_commentstatus(String bookISBN,String orderNO,String ID) {
		String sql = "UPDATE orderitem SET commentstatus = 1 WHERE bookISBN = ? AND orderNO = ? AND ID = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookISBN);
			ps.setString(2, orderNO);
			ps.setString(3, ID);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 查看图书评价
	 */
	public Book QueryBookEvaluate(String bookISBN) {
		String sql = "SELECT bookEvaluate from book WHERE bookISBN = ?";
		Book book = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookISBN);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookEvaluate(rs.getString("bookEvaluate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
}
