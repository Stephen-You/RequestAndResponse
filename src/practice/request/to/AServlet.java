package practice.request.to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ת��,����һ��������ض�������������ǲ�ͬ��
 * @author Yorick
 *2017��6��21��
 */
@WebServlet(name = "ReAServlet", urlPatterns = { "/ReAServlet" })
public class AServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��request���д������
		request.setAttribute("����","����");
		//��ȡת����
		RequestDispatcher rd = request.getRequestDispatcher("/ReBServlet");
		//ת��֮ǰ����ʾһЩ����
		response.setContentType("text/html;charset=utf-8");
		/*AServlet�в�����������Ӧ�����ݣ���ΪTomcat��ѻ����������ת����BServlet��
		 * ���ύ֮�󣬲�����ת������Ȼ����쳣��
			�ܽ᣺��ͷ�����壬�������쳣������
		 * */
		response.getWriter().write("����AServlet���Ҹ�����Ӧ�ˣ�");
		//���ǲ�����response�ύ���ٽ�������ת������,�ض���Ҳ������
//		response.getWriter().flush();
		//2. ����ת������forward����������request��response
		//���ǰѵ�ǰAServlet��request��response���ݸ�BServlet��
		rd.forward(request, response);
	}

}
