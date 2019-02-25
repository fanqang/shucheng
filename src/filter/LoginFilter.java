package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {
	String [] exclude;//排出的�?�项，不经过过滤�??
	//String [] excludeFolder;//排出的文件夹，不经过过滤�??
	String [] HTMLFolder;//要经过过滤的页面
    /**
     * Default constructor. 
     */
    public LoginFilter() {
      	exclude = new String[]{"ShowAllBook.jsp","ShowBook.jsp"};
      	HTMLFolder = new String[]{"ShoppingCar.jsp","address.jsp","order.jsp"};
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String url = request.getRequestURI();//获取访问的url
		String ctxPath = request.getContextPath();//获取网站上下文路�??
		System.out.println(url);
		System.out.println(ctxPath);
		boolean needFilter = true;//默认�??要过�??
		for(int i = 0; i < exclude.length; i++) {
			if(!"".equals(exclude[i]) && url.equals(ctxPath+"/"+"/admin/"+exclude[i])) {
				needFilter = false;
				break;
			}
		}
		if (needFilter) {//如果�??要进行过�??
			//�??测用户是否登�??
			HttpSession session = request.getSession();
			String logname = (String) session.getAttribute("success");
			if(logname == null) {
				for(int i = 0; i < HTMLFolder.length; i++) {
					if (!"".equals(HTMLFolder[i]) && url.startsWith(ctxPath + "/" + "admin/" + HTMLFolder[i])) {//�??测是否要返回HTML页面
						response.sendRedirect(ctxPath + "/" + "/admin/" + "Filter.jsp");//重定向到未登录过滤的jsp页面
					}
				}
			}
		}
		chain.doFilter(servletRequest, servletResponse);//跳转到下�??个过滤器
		return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
