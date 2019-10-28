package com.cha5.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.cha5.pojo.User;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 

    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();;
		// 获取应用上下文对象
    	StringBuffer url=request.getRequestURL();
        String name= (String) request.getSession().getAttribute("name");
        name= (name==null) ? "游客":name;
        StringBuffer b = new StringBuffer();
        b.append(name);
        b.append("---");
        b.append(url);
        request.getServletContext().log(b.toString());
    }
}
