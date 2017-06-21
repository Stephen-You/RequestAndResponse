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
		 * 默认getParameter()获取参数时使用的是iso-8859-1
		 * 对于GET请求而言，我们需要先获取数据，这时可能是乱码！
		 * 然后再处理这个乱码即可！
		 */
		
		String username = request.getParameter("username");
//		
//		/*
//		 * tomcat错误的使用iso来解读
//		 * 我们需要把解读的结果退回到字节数组
//		 * 然后再使用正确的utf-8来进行解读
//		 */
		byte[] bytes = username.getBytes("iso-8859-1");//回退
		username = new String(bytes, "utf-8");//再解
//		request.setCharacterEncoding("utf-8");获取到的仍是乱码,这是因为get没有请求体,我们设置编码是为请求体设置的
//		String username = request.getParameter("username");
		
		System.out.println(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * POST请求参数的乱码问题
		 * 1. 在获取参数之前，调用request.setCharacterEncoding("utf-8");
		 *   setCharacterEncoding()：告诉request对象，我们使用utf-8来解读请求体！
		 */
		//这也可行,只是过于麻烦
//		String username1 = request.getParameter("username");
//		byte[] user = username1.getBytes("iso-8859-1");
//		String user1 = new String(user, "utf-8");
//		System.out.println(user1);
		//如果我们在上面执行操作后,紧接着在下买执行,那么输出不识别,这是因为我们已经把按照iso编码的数据放入了request域
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
	}

}
