<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>Chatting Room</title>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-ocontrol" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1, keyword2, keyword3">
    <meta http-equiv="description" content="The Chatting Page">
    
    <!--
        <link rel="stylesheet" type="text/css" href="style.css">
    -->
    
    <script type="text/javascript">
    
    //The XHR variable
    var xmlHttp;
    //Function to active XHR
    function createXMLHttpRequest()
    {
        if(window.ActiveXObject)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest)
        {
            xmlHttp = new XMLHttpRequest();
        }
    }
    /*
    Four functions (submit, submit_change, submit_update, submit_clear) 
    to implement the send message function
    */
    function submit()
    {
        var content = document.getElementById("content").value;
        var url = "/RichWeb/handleAction.action?content="+content;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = submit_change;
        url=encodeURI(url);
        xmlHttp.open("GET",url,true);
        xmlHttp.send(null);
    }
    function submit_change()
    {
    	
    	if(xmlHttp.readyState==4)
    	{
    		if(xmlHttp.status == 200)
    		{
    			submit_update();
    		}	
    	}
    }
    function submit_update()
    {
    	submit_clear();
    	var xml=xmlHttp.responseXML;
    }
    function submit_clear()
    {
    	document.getElementById("content").value="";
    }
    /*
    Four functions (check, check_change, check_update, check_clear) used to
    get the messages from other clients.
    */
    function check()
    {
    	
    	var url="/RichWeb/checkAction.action";
    	createXMLHttpRequest();
    	xmlHttp.onreadystatechange = check_change;
    	url=encodeURI(url);
    	xmlHttp.open("GET",url,true);
    	xmlHttp.send(null);
    }
    function check_change()
    {
    	if(xmlHttp.readyState ==4)
    	{
    		if(xmlHttp.status == 200)
    		{
    			check_update();
    		}
    	}
    }
    function check_update()
    {
    	check_clear();
    	var xml=xmlHttp.responseXML;
    	var app_flags=xml.getElementsByTagName("app_flag");
    	var app_flag=app_flags[0].firstChild==null?"":app_flags[0].firstChild.nodeValue;
    	
    	//Somebody sent messages, add it to board
    	if(app_flag == "true")
    	{
    		read();
    	}
    }
    function check_clear()
    {
    	
    }
    /*
    Four functions(read, read_change, read_update, read_clear) used to
    add new messages to chat board
    */
    function read()
    {
    	
    	var url = "/RichWeb/readAction.action";
    	createXMLHttpRequest();
    	xmlHttp.onreadystatechange = read_change;
    	url = encodeURI(url);
    	xmlHttp.open("GET",url,true);
    	xmlHttp.send(null);
    }
    function read_change()
    {
    	if (xmlHttp.readyState == 4)
    	{
    		if(xmlHttp.status == 200)
    		{
    			read_update();
    		}
    	}
    }
    function read_update()
    {
    	read_clear();
    	var xml = xmlHttp.responseXML;
    	var app_contents=xml.getElementsByTagName("app_content");
    	var app_content=app_contents[0].firstChild==null?"":app_contents[0].firstChild.nodeValue;
    	
    	if(app_content!="")
    	{
    		document.getElementById("ChatContent").value=app_content;
    		setTimeout("HandleEr()",2000);
    	}
    }
    function read_clear()
    {
    	
    }
    /*
    Fout functions (handleEr, handleEr_change, handleEr_update, handleEr_clear) used to
    check if the new messages have beed added to the chat board.
    */
    function handleEr()
    {
    	var url = "/RichWeb/handleErAction.action";
    	createXMLHttpRequest();
    	xmlHttp.onreadystatechange = handleEr_change;
    	url = encodeURI(url);
    	xmlHttp.open("GET",url,true);
    	xmlHttp.send(null);
    }
    function handleEr_change()
    {
    	if (xmlHttp.readyState == 4)
    	{
    		if(xmlHttp.status == 200)
    		{
    			handleEr_update();
    		}
    	}
    }
    function handleEr_update()
    {
    	handleEr_clear();
    	var xml=xmlHttp.responseXML;
    }
    function handleEr_clear()
    {
    	
    }
    
    /*
     The start function used to active the check action
    */
    function start()
    {
    	setInterval(check,"200");
    	
    }
    //Set the onload function
    window.onload=start;
    </script>
</head>
<body >
    <table cellpadding="0" cellspacing="0" width="100%" style="font-size:10px">
    	<tr>
    	<td>
    	    <textarea rows="20" cols="50" id="ChatContent" name="ChatContent">
    	    </textarea>
    	</td>
    	</tr>
    	<tr>
    	<td>
    	    <input type="text" id="content" name="content"/>
    	    <button onclick="submit()">Send</button>
    	</td>
    	</tr>
    </table>
</body>
</html>