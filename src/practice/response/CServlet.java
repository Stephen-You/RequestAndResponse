package practice.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 重定向的练习
 * @author Yorick
 *2017年6月21日
 */
public class CServlet extends HttpServlet {
/*响应码为200表示响应成功，而响应码为302表示重定向。所以完成重定向的第一步就是设置响应码为302。
	因为重定向是通知浏览器再第二个请求，所以浏览器需要知道第二个请求的URL，
	所以完成重定向的第二步是设置Location头，指定第二个请求的URL地址。
 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应吗
//		resp.setStatus(302);
//		resp.setHeader("Location", "/RequestAndResponse/BServlet");
		//上边的重定向,太过繁琐,实际有简单的方法,供我们使用
//		resp.sendRedirect("/RequestAndResponse/BServlet");
		//只能存在一个重定向
		resp.sendRedirect("http://www.itcast.cn");
	}
}
