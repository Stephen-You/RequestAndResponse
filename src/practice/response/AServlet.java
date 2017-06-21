package practice.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 使用Response设置响应字符数据
 * @author Yorick
 *2017年6月21日
 */
public class AServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应格式和编码方式
		resp.setHeader("Content-Type", "text/html;utf-8");
		//设置字符流的编码方式
		resp.setCharacterEncoding("utf-8");
		//获取字符响应流
		PrintWriter pw = resp.getWriter();
//		pw.write("<h>字符数据</h>");
		/*字符编码,我们要使用到字符流,response.getWriter()是PrintWriter类型，所以它有缓冲区，缓冲区的默认大小为8KB。也就是说，在响应数据没有输出8KB之前，数据都是存放在缓冲区中，而不会立刻发送到客户端。当Servlet执行结束后，服务器才会去刷新流，使缓冲区中的数据发送到客户端。
			如果希望响应数据马上发送给客户端：
				向流中写入大于8KB的数据；
				调用response.flushBuffer()方法来手动刷新缓冲区；*/
		pw.write("<h>PrintWriter是一个缓冲流,缓冲区默认大小8kb,通过flush()方法,将缓冲区推到响应请求</h>");
		pw.flush();
		pw.close();
	}
}
