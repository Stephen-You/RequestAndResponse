package practice.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �ض������ϰ
 * @author Yorick
 *2017��6��21��
 */
public class CServlet extends HttpServlet {
/*��Ӧ��Ϊ200��ʾ��Ӧ�ɹ�������Ӧ��Ϊ302��ʾ�ض�����������ض���ĵ�һ������������Ӧ��Ϊ302��
	��Ϊ�ض�����֪ͨ������ٵڶ������������������Ҫ֪���ڶ��������URL��
	��������ض���ĵڶ���������Locationͷ��ָ���ڶ��������URL��ַ��
 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������Ӧ��
//		resp.setStatus(302);
//		resp.setHeader("Location", "/RequestAndResponse/BServlet");
		//�ϱߵ��ض���,̫������,ʵ���м򵥵ķ���,������ʹ��
//		resp.sendRedirect("/RequestAndResponse/BServlet");
		//ֻ�ܴ���һ���ض���
		resp.sendRedirect("http://www.itcast.cn");
	}
}
