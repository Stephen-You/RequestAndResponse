package practice.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡrequest���ڲ���
		String str = (String) req.getAttribute("aa");
		System.out.println("�ض�������������,�������ǻ�ȡ��ֵΪnull;"+str);
		/**
		 * ʶ��ͻ��˵������
		 */
		//������Ӧ����
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		// ��ȡUser-Agent����ͷ
		String browser = req.getHeader("User-Agent");
		if(browser.contains("MSIE")){
			pw.write("��ʹ�õ��������IE�����!");
		}else if (browser.contains("Firefox")) {
			pw.write("��ʹ�õ��������Firefox�����!");
		}else if (browser.contains("Chrome")) {
			pw.write("��ʹ�õ��������Chrome�����!");
		}
		pw.println(str);
		pw.close();
	}
}
