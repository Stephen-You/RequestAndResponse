package practice.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 参数的获取
 * @author Yorick
 *2017年6月21日
 */
 
@WebServlet(name = "ReqFServlet", urlPatterns = { "/ReqFServlet" })
public class FServlet extends HttpServlet {

	/**
	  String getParameter(String name)：通过参数名得到参数值（一参一值）
	 * String[] getParameterValues(String name)：通过参数名得到参数值（一参多值）
	 * Map getParameterMap()：把所有的参数封装到Map中，其中key是参数名，value是参数值！
	 * key：参数名，就是String
	 * value：参数值，是String[]
	 * Enumeration getParameterNames()：获取所有参数的名称
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过参数名获取参数值,
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("通过参数名获取参数值,一参一值:"+request.getParameter("username")+"</br>");
		//尝试通过获取参数名,获取一参多值的值,只能获取到第一个参数值
		response.getWriter().write("通过参数名获取参数值,一参一值:"+request.getParameter("user")+"</br>");
		response.getWriter().write("通过参数名获取参数值,一参多值:"+Arrays.toString(request.getParameterValues("user"))+"</br>");
		//获取所有参数
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> entry: map.entrySet()) {
			response.getWriter().write(entry.getKey().toString()+"  "+Arrays.toString(entry.getValue())+"</br>");
		}
	}

}
