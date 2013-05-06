/**
 * Class used to get the user info
 * Author: Zongqing Sun
 * */
package ie.dit.zongqing.action;

import javax.servlet.http.HttpServletRequest;
/*
The jar files from struts2 (Third Party). 
*/
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
//Create a class extends from struts2 ActionSupport
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		//variable used to store the request from client
		HttpServletRequest req = ServletActionContext.getRequest();
		//Encode the username and store it to attribute
		String username = java.net.URLDecoder.decode(req.getParameter("username"), "UTF-8");
		
		req.getSession().setAttribute("userinfo", username);
		
		return "success";
	}
}
