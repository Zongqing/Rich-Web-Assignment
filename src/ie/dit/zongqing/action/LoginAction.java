/**
 * Class used to identify the login actions
 * Author: Zongqing Sun
 * */
package ie.dit.zongqing.action;

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
		
		String username = java.net.URLDecoder.decode(req.getParameter("username"), "UTF-8");
		
		req.getSession().setAttribute("userinfo", username);
//		req.setAttribute("userinfo", username);
		
		return "success";
	}
}
