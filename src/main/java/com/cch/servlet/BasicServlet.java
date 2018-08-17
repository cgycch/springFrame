package com.cch.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasicServlet() {
        super();
        System.out.println("BasicServlet::BasicServlet()");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	 System.out.println("BasicServlet::init()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BasicServlet::service()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
