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
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		res.setContentType("text/xml;charset=UTF-8");
		res.setHeader("Cacheo-Control", "no-cache");
		
		PrintWriter out = res.getWriter();
		StringBuffer sb = new StringBuffer();
		
		String username = java.net.URLDecoder.decode(req.getParameter("username"), "UTF-8");
		
		req.getSession().setAttribute("userinfo", username);
		
		out.print(sb.toString());
		out.close();
		
		return "success";
	}
}
