/**
 *Class used to set the new messages flag to false
 *Author: Zongqing Sun 
 */
package ie.dit.zongqing.action;

/*
The jar files from struts2 (Third Party). 
*/
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
//Create a class extends from struts2 ActionSupport
public class HandleErAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		//Set the new message flag to false
		ServletActionContext.getServletContext().setAttribute("app_flag", "false");
		return "success";
	}
}
