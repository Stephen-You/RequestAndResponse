package practice.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求相关的各种方法
 * int getContentLength()：获取请求体的字节数，GET请求没有请求体，没有请求体返回-1；
String getContentType()：获取请求类型，如果请求是GET，那么这个方法返回null；如果是POST请求，那么默认为application/x-www-form-urlencoded，表示请求体内容使用了URL编码；
String getMethod()：返回请求方法，例如：GET
Locale getLocale()：返回当前客户端浏览器的Locale。java.util.Locale表示国家和言语，这个东西在国际化中很有用；zh_CN、en_US
String getCharacterEncoding()：获取请求编码，如果没有setCharacterEncoding()，那么返回null，表示使用ISO-8859-1编码；
void setCharacterEncoding(String code)：设置请求编码，只对请求体有效！注意，对于GET而言，没有请求体！！！所以此方法只能对POST请求中的参数有效！
String getContextPath()：返回上下文路径，例如：/hello
String getQueryString()：返回请求URL中的参数，例如：name=zhangSan
String getRequestURI()：返回请求URI路径，例如：/hello/oneServlet
StringBuffer getRequestURL()：返回请求URL路径，例如：http://localhost/hello/oneServlet，即返回除了参数以外的路径信息；
String getServletPath()：返回Servlet路径，例如：/oneServlet
String getRemoteAddr()：返回当前客户端的IP地址；
String getRemoteHost()：返回当前客户端的主机名，但这个方法的实现还是获取IP地址；
String getScheme()：返回请求协议，例如：http；
String getServerName()：返回主机名，例如：localhost
int getServerPort()：返回服务器端口号，例如：8080
 * @author Yorick
 *2017年6月21日
 */
 
@WebServlet(name = "ReqDServlet", urlPatterns = { "/ReqDServlet" })
public class DServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		//获取请求体的字节数，GET请求没有请求体，没有请求体返回-1
		int length = request.getContentLength();
		pw.write("请求体长度为:"+length+"</br>");
		//获取请求类型，如果请求是GET，那么这个方法返回null；如果是POST请求，那么默认为application/x-www-form-urlencoded，表示请求体内容使用了URL编码；
		String contentType = request.getContentType();
		pw.write("请求类型是:"+contentType+"</br>");
		//获取请求方法
		String method = request.getMethod();
		pw.write("请求方法为:"+method+"</br>");
		//返回当前客户端浏览器的Locale。java.util.Locale表示国家和言语，这个东西在国际化中很有用；zh_CN、en_US
		Locale locale = request.getLocale();
		pw.write("当前客户端浏览器国家语言为:"+locale+"</br>");
		//获取请求编码
		request.setCharacterEncoding("utf-8");
		String encoding = request.getCharacterEncoding();
		pw.write("请求编码为:"+encoding+"</br>");
		//String getContextPath()：返回上下文路径，例如：/hello,以后使用最多的
		String contextPath = request.getContextPath();
		pw.write("上下问文路径:"+contextPath+"</br>");
		//String getQueryString()：返回请求URL中的参数，例如：name=zhangSan
		String queryString = request.getQueryString();
		pw.write("请求参数:"+queryString+"</br>");
		//String getRequestURI()：返回请求URI路径，例如：/hello/oneServlet
		StringBuffer requestURL = request.getRequestURL();
		pw.write("返回URL路径:"+requestURL+"</br>");
		//StringBuffer getRequestURL()：返回请求URL路径，例如：http://localhost/hello/oneServlet，即返回除了参数以外的路径信息；
		String requestURI = request.getRequestURI();
		pw.write("返回请求的URI:"+requestURI+"</br>");
		//String getServletPath()：返回Servlet路径，例如：/oneServlet
		pw.write("Servlet路径,即url-pattern:"+request.getServletPath()+"</br>");
		//String getRemoteAddr()：返回当前客户端的IP地址；
		pw.write("返回当前客户端的IP地址:"+request.getRemoteAddr()+"</br>");
		//String getRemoteHost()：返回当前客户端的主机名，但这个方法的实现还是获取IP地址；
		pw.write("返回当前客户端的主机名:"+request.getRemoteHost()+"</br>");
		//String getScheme()：返回请求协议，例如：http；
		pw.write("返回请求协议:"+request.getScheme()+"</br>");
		//String getServerName()：返回主机名，例如：localhost
		pw.write("返回服务器主机名:"+request.getServerName()+"</br>");
		//int getServerPort()：返回服务器端口号，例如：8080
		pw.write("返回服务器端口号::"+request.getServerPort()+"</br>");
		pw.write("返回当前ServletContext:"+request.getServletContext()+"</br>");
		pw.write("返回当前请求的url-pattern:"+request.getServletPath()+"</br>");
		//组织一个URL
		pw.write("通过方法组件一个URL:"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+request.getServletPath());
	}

}
