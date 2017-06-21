package practice.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ����ͷ����
 * @author Yorick
 *2017��6��21��
 */
@WebServlet(name = "ReqCServlet", urlPatterns = { "/ReqCServlet" })
public class CServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ���е�����ͷ,ѭ����ӡ��ҳ��
		Enumeration<String> en = req.getHeaderNames();
		//������Ӧ�ַ�����
		resp.setContentType("text/html;charset=utf-8");
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			resp.getWriter().write(string);
			resp.getWriter().write("</br>");
		}
	}

}
