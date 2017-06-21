package practice.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ݻ�ȡ�Ŀͻ���IP,�ж��Ƿ��ֹ��IP
 * @author Yorick
 *2017��6��21��
 */
@WebServlet(name = "ReqEServlet", urlPatterns = { "/ReqEServlet" })
public class EServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�ͻ���IP
		String ip = request.getRemoteAddr();
		if(ip.equals("127.0.0.1")){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("�Բ���,����IP����ֹ����!");
		}
	}

}
