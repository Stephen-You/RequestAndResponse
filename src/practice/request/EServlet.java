package practice.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据获取的客户端IP,判断是否禁止该IP
 * @author Yorick
 *2017年6月21日
 */
@WebServlet(name = "ReqEServlet", urlPatterns = { "/ReqEServlet" })
public class EServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端IP
		String ip = request.getRemoteAddr();
		if(ip.equals("127.0.0.1")){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("对不起,您的IP被禁止访问!");
		}
	}

}
