package practice.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * ��ʾ��Ӧ�ֽ�����
 * @author Yorick
 *2017��6��21��
 */
public class BServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�ֽ���
		OutputStream os = resp.getOutputStream();
		//��ͳ���Ǵ����ֽ���,�ǽ�һ���ļ�ת��Ϊ�ֽ�����,Ȼ��ͨ��������,��IOUtils������ô���������Խ��ļ�ת��Ϊ�ֽ�����
//		byte[] image = IOUtils.toByteArray(new FileInputStream("F://bai.jpg"));
//		//Ȼ��ͨ����������
//		os.write(image);
//		//�ر���
//		os.close();
		//�����Ĳ����������е㷱��,���ǿɲ����Լ���,ʵ�����ǿ��Ե�IOUtilsʵ�ʻ���һ���������ǰ�������ת��Ϊ�������copy����
		IOUtils.copy(new FileInputStream("F://bai.jpg"), os);
		//�ر���
		os.close();
	}
}
