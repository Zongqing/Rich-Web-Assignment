/**
 * Class used to identify the login actions
 * Author: Zongqing Sun
 * */
package ie.dit.zongqing.sun;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cacheo-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		String username = java.net.URLDecoder.decode(request.getParameter("username"), "UTF-8");
		
		request.getSession().setAttribute("userinfo", username);
		
		out.print(sb.toString());
		out.close();
		
		return "success";
	}
}
