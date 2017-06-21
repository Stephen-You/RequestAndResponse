package practice.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request是一个域对象,他的作用空间是一个请求,如果一个请求经历了多个servlet,那么是可以被多个servlet共享数据的
 * request域对象方法:
 *void setAttribute(String name, Object value)：用来存储一个对象，也可以称之为存储一个域属性，例如：servletContext.setAttribute(“xxx”, “XXX”)，在request中保存了一个域属性，域属性名称为xxx，域属性的值为XXX。请注意，如果多次调用该方法，并且使用相同的name，那么会覆盖上一次的值，这一特性与Map相同；
Object getAttribute(String name)：用来获取request中的数据，当前在获取之前需要先去存储才行，例如：String value = (String)request.getAttribute(“xxx”);，获取名为xxx的域属性；
void removeAttribute(String name)：用来移除request中的域属性，如果参数name指定的域属性不存在，那么本方法什么都不做；
Enumeration getAttributeNames()：获取所有域属性的名称；
 * @author Yorick
 *2017年6月21日
 */
public class AServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//我们实现一个功能,请求过来的时候,向请求中添加参数,然后重定向,让另一个Servlet处理这个参数
		req.setAttribute("aa","zhangsan");
		resp.sendRedirect("/RequestAndResponse/ReqBServlet");
		System.out.println(this.getServletName());
	}
}
