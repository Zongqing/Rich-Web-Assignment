/**
 Class which used to add the input messages onto chat board.
 Author:Zongqing Sun
 */
package ie.dit.zongqing.action;

import javax.servlet.http.HttpServletRequest;
/*
 The jar files from struts2 (Third Party). 
 */
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

//Create a class extends from struts2 ActionSupport 
public class HandleAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		//Variable used to get the request
		HttpServletRequest req = ServletActionContext.getRequest();
		
		//The input content from the client.
		String content = java.net.URLDecoder.decode(req.getParameter("content"),"UTF-8");
		
		//The username from login page
		String username=(String)req.getSession().getAttribute("userinfo");
		
		//Combination of username and content
		String content_1=username+" : "+content + "\r\n";
		/*
		 Add the new content append after name to the chat board.
		 */
		if(""!=content && null != content){
			ServletActionContext.getServletContext().setAttribute("app_flag", "true");
			String timp = (String)ServletActionContext.getServletContext().getAttribute("suoYou_content");

			if(timp!="null" && timp!=null){
				ServletActionContext.getServletContext().setAttribute("suoYou_Content", timp+content_1);
			}else
			{
				ServletActionContext.getServletContext().setAttribute("suoYou_content", content_1);
			}
		}
        //The symbol will be used in struts.xml config file.
		return "success";
	}
}
