package practice.request.to;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
@WebServlet(name = "ReBServlet", urlPatterns = { "/ReBServlet" })
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = (String) request.getAttribute("张三");
//		System.out.println(username);
		response.getWriter().write("我是BServlet!");
		String username = (String) request.getAttribute("张三");
		System.out.println(username);
	}

}
