package com.cha5.listener;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cha5.pojo.User;

/**
 * Application Lifecycle Listener implementation class UserListener
 * @param <User>
 *
 */
@WebListener
public class UserListener<User> implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	
	private int num;
	
    public UserListener() {
        
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         num++;
         ServletContext context=se.getSession().getServletContext();
         context.setAttribute("Num", num);
     
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext context=se.getSession().getServletContext();
        num=(int) context.getAttribute("Num");
        num--;
        context.setAttribute("Num", num);
    }
	
}
