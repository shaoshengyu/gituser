package com.cha5.listener;

import java.util.Hashtable;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.cha5.pojo.User;

/**
 * Application Lifecycle Listener implementation class OnlineUsersListenerXinxi
 *
 */
@WebListener
public class OnlineUsersListenerXinxi implements HttpSessionAttributeListener {

    public OnlineUsersListenerXinxi() {

    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	if("xinxi".equals(event.getName())){
    		// 获取会话域属性值：当前登录的用户对象
    		User user = (User)event.getValue();
    		event.getSession().getServletContext().log(user.getName()+"--"+user.getUrl());
    	}
    }
    public void attributeRemoved(HttpSessionBindingEvent event)  { 

    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         
    }
	
}
