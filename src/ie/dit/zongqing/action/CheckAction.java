/**
 *Class used to check if there are new response from clients
 *Author: Zongqing Sun 
 */
package ie.dit.zongqing.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/*
The jar files from struts2 (Third Party). 
*/
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
//Create a class extends from struts2 ActionSupport 
public class CheckAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    	
	public String execute() throws Exception{
		//Variable used to store the response to client
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//Response format
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		//Response to client
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		//Get the current contents
		String app_flag=(String)ServletActionContext.getServletContext().getAttribute("app_flag");
		
		//Add the new content to current content
		sb.append("<Lists>");
			sb.append("<app_flag>");
			sb.append(app_flag);
			sb.append("</app_flag>");
		sb.append("</Lists>");
		
		//Responese to client
		out.print(sb.toString());
		out.close();
		
		//The symbol will be used in struts.xml config file.
		return "success";
	}
}
