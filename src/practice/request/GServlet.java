package practice.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GServlet
 */
@WebServlet(name = "/GServlet", urlPatterns = { "/GServlet" })
public class GServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Ĭ��getParameter()��ȡ����ʱʹ�õ���iso-8859-1
		 * ����GET������ԣ�������Ҫ�Ȼ�ȡ���ݣ���ʱ���������룡
		 * Ȼ���ٴ���������뼴�ɣ�
		 */
		
		String username = request.getParameter("username");
//		
//		/*
//		 * tomcat�����ʹ��iso�����
//		 * ������Ҫ�ѽ���Ľ���˻ص��ֽ�����
//		 * Ȼ����ʹ����ȷ��utf-8�����н��
//		 */
		byte[] bytes = username.getBytes("iso-8859-1");//����
		username = new String(bytes, "utf-8");//�ٽ�
//		request.setCharacterEncoding("utf-8");��ȡ������������,������Ϊgetû��������,�������ñ�����Ϊ���������õ�
//		String username = request.getParameter("username");
		
		System.out.println(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * POST�����������������
		 * 1. �ڻ�ȡ����֮ǰ������request.setCharacterEncoding("utf-8");
		 *   setCharacterEncoding()������request��������ʹ��utf-8����������壡
		 */
		//��Ҳ����,ֻ�ǹ����鷳
//		String username1 = request.getParameter("username");
//		byte[] user = username1.getBytes("iso-8859-1");
//		String user1 = new String(user, "utf-8");
//		System.out.println(user1);
		//�������������ִ�в�����,������������ִ��,��ô�����ʶ��,������Ϊ�����Ѿ��Ѱ���iso��������ݷ�����request��
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
	}

}
