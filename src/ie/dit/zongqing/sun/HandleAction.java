package ie.dit.zongqing.sun;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class HandleAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		res.setContentType("text/xml;charset=UTF-8");
		res.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = res.getWriter();
		StringBuffer sb = new StringBuffer();
		
		String content = java.net.URLDecoder.decode(req.getParameter("content"),"UTF-8");
		
		String username=(String)req.getSession().getAttribute("userinfo");
		
		String content_1=username+" : "+content + "\r\n";
		
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
		return "success";
	}
}
