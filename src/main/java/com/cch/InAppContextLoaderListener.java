package com.cch;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class InAppContextLoaderListener extends ContextLoaderListener {
	
	public void contextInitialized(ServletContextEvent event) {
		initInAppCfg();
		super.contextInitialized(event);
	}
	
	private void initInAppCfg() {
		System.out.println("customed initialization...");
	}

}
