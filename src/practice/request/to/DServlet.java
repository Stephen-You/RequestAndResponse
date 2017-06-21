package practice.request.to;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求包含
 * @author Yorick
 *2017年6月21日
 */
@WebServlet(name = "ReDServlet", urlPatterns = { "/ReDServlet" })
public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(String.valueOf(request.getAttribute("张三")));
		response.getWriter().write("请求包含我是DServlet");
	}

}
