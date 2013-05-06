/**
 *The check action class
 *Author: Zongqing Sun 
 */
package ie.dit.zongqing.sun;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		res.setContentType("text/xml;charset=UTF-8");
		res.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = res.getWriter();
		StringBuffer sb = new StringBuffer();
		
		String app_flag=(String)ServletActionContext.getServletContext().getAttribute("app_flag");
		
		sb.append("<Lists>");
			sb.append("<app_flag>");
			sb.append(app_flag);
			sb.append("</app_flag>");
		sb.append("</Lists>");
		
		out.print(sb.toString());
		out.close();
		return "success";
	}
}
