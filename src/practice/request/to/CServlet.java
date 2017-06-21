package practice.request.to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求包含:请求转发Tomcat会把缓冲区清空再转发到BServlet！
 * 		请求包含Tomcat会将缓冲区的保留然后转发,
 * @author Yorick
 *2017年6月21日
 */
@WebServlet(name = "ReCServlet", urlPatterns = { "/ReCServlet" })
public class CServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CServlet!");
		//向request域存储
		request.setAttribute("张三","张三");
		//设置响应体
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("你好我是请求包含CServlet!");
		//获取请求转发转发器
		RequestDispatcher rd = request.getRequestDispatcher("/ReDServlet");
		//2. 调用include，传递request和response	 
		rd.include(request, response);
	}

}
