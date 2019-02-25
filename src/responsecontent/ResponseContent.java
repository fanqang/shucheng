package responsecontent;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class ResponseContent {
	//用于将指定字符串快�?�输出到response�?
	public static void setContentAtJson(HttpServletResponse response, String json) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");//允许跨域访问
		//将指定字符串添加到页面中
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");
        OutputStream out = response.getOutputStream();  
        out.write(json.getBytes("UTF-8"));  
        out.flush(); 
	}
	
	public static void setContentAtJs(HttpServletResponse response, String json) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");//允许跨域访问
		//将指定字符串添加到页面中
		response.setContentType("application/js; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");
        OutputStream out = response.getOutputStream();  
        out.write(json.getBytes("UTF-8"));  
        out.flush(); 
	}
}
