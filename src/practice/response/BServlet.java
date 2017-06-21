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
 * 演示响应字节数据
 * @author Yorick
 *2017年6月21日
 */
public class BServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取字节流
		OutputStream os = resp.getOutputStream();
		//传统我们处理字节流,是将一个文件转变为字节数组,然后通过流处理,在IOUtils中有这么个方法可以将文件转变为字节数组
//		byte[] image = IOUtils.toByteArray(new FileInputStream("F://bai.jpg"));
//		//然后通过输出流输出
//		os.write(image);
//		//关闭流
//		os.close();
		//这样的操作看起来有点繁琐,我们可不可以简化呢,实际上是可以的IOUtils实际还有一个方法就是把输入流转变为输出流的copy方法
		IOUtils.copy(new FileInputStream("F://bai.jpg"), os);
		//关闭流
		os.close();
	}
}
