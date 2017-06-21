package practice.request.to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发,这是一个请求和重定向的两个请求是不同的
 * @author Yorick
 *2017年6月21日
 */
@WebServlet(name = "ReAServlet", urlPatterns = { "/ReAServlet" })
public class AServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向request域中存放数据
		request.setAttribute("张三","张三");
		//获取转发器
		RequestDispatcher rd = request.getRequestDispatcher("/ReBServlet");
		//转发之前向显示一些内容
		response.setContentType("text/html;charset=utf-8");
		/*AServlet中不能再设置响应体内容，因为Tomcat会把缓冲区清空再转发到BServlet！
		 * 在提交之后，不能再转发！不然输出异常！
			总结：留头不留体，留体抛异常！！！
		 * */
		response.getWriter().write("我是AServlet，我给你响应了！");
		//我们不能在response提交后再进行请求转发操作,重定向也不可以
//		response.getWriter().flush();
		//2. 调用转发器的forward方法，传递request和response
		//就是把当前AServlet的request和response传递给BServlet了
		rd.forward(request, response);
	}

}
