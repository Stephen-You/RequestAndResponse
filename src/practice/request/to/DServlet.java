package practice.request.to;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �������
 * @author Yorick
 *2017��6��21��
 */
@WebServlet(name = "ReDServlet", urlPatterns = { "/ReDServlet" })
public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(String.valueOf(request.getAttribute("����")));
		response.getWriter().write("�����������DServlet");
	}

}
