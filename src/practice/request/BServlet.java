package practice.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取request域内参数
		String str = (String) req.getAttribute("aa");
		System.out.println("重定向是两次请求,所以我们获取到值为null;"+str);
		/**
		 * 识别客户端的浏览器
		 */
		//处理响应编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		// 获取User-Agent请求头
		String browser = req.getHeader("User-Agent");
		if(browser.contains("MSIE")){
			pw.write("您使用的浏览器是IE浏览器!");
		}else if (browser.contains("Firefox")) {
			pw.write("您使用的浏览器是Firefox浏览器!");
		}else if (browser.contains("Chrome")) {
			pw.write("您使用的浏览器是Chrome浏览器!");
		}
		pw.println(str);
		pw.close();
	}
}
