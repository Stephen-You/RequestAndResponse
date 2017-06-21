package practice.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求头数据
 * @author Yorick
 *2017年6月21日
 */
@WebServlet(name = "ReqCServlet", urlPatterns = { "/ReqCServlet" })
public class CServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取所有的请求头,循环打印到页面
		Enumeration<String> en = req.getHeaderNames();
		//设置响应字符编码
		resp.setContentType("text/html;charset=utf-8");
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			resp.getWriter().write(string);
			resp.getWriter().write("</br>");
		}
	}

}
