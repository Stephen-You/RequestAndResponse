package practice.request.to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �������:����ת��Tomcat��ѻ����������ת����BServlet��
 * 		�������Tomcat�Ὣ�������ı���Ȼ��ת��,
 * @author Yorick
 *2017��6��21��
 */
@WebServlet(name = "ReCServlet", urlPatterns = { "/ReCServlet" })
public class CServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CServlet!");
		//��request��洢
		request.setAttribute("����","����");
		//������Ӧ��
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��������������CServlet!");
		//��ȡ����ת��ת����
		RequestDispatcher rd = request.getRequestDispatcher("/ReDServlet");
		//2. ����include������request��response	 
		rd.include(request, response);
	}

}
