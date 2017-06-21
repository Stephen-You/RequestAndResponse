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
 * �����Ļ�ȡ
 * @author Yorick
 *2017��6��21��
 */
 
@WebServlet(name = "ReqFServlet", urlPatterns = { "/ReqFServlet" })
public class FServlet extends HttpServlet {

	/**
	  String getParameter(String name)��ͨ���������õ�����ֵ��һ��һֵ��
	 * String[] getParameterValues(String name)��ͨ���������õ�����ֵ��һ�ζ�ֵ��
	 * Map getParameterMap()�������еĲ�����װ��Map�У�����key�ǲ�������value�ǲ���ֵ��
	 * key��������������String
	 * value������ֵ����String[]
	 * Enumeration getParameterNames()����ȡ���в���������
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ͨ����������ȡ����ֵ,
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("ͨ����������ȡ����ֵ,һ��һֵ:"+request.getParameter("username")+"</br>");
		//����ͨ����ȡ������,��ȡһ�ζ�ֵ��ֵ,ֻ�ܻ�ȡ����һ������ֵ
		response.getWriter().write("ͨ����������ȡ����ֵ,һ��һֵ:"+request.getParameter("user")+"</br>");
		response.getWriter().write("ͨ����������ȡ����ֵ,һ�ζ�ֵ:"+Arrays.toString(request.getParameterValues("user"))+"</br>");
		//��ȡ���в���
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> entry: map.entrySet()) {
			response.getWriter().write(entry.getKey().toString()+"  "+Arrays.toString(entry.getValue())+"</br>");
		}
	}

}
