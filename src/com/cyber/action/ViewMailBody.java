package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.MailsTO;
import com.cyber.delegate.MailDelegate;
import com.cyber.util.UtilConstants;

/**
 * ViewMailBodyAction Servlet Class for to view mail details. This class Helps
 * to get view mail body.
 * 
 */
public class ViewMailBody extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		Vector<MailsTO> vmail = null;
		int messageid = Integer.parseInt(request.getParameter("messageid"));
		String mailbox = request.getParameter("mailbox");
		System.out.println(" messageid :" + messageid);
		System.out.println(" mailbox :" + mailbox);
		try {
			vmail = new MailDelegate().viewMail(messageid, mailbox);
			if (!vmail.isEmpty()) {
				request.setAttribute("msgbody", vmail);
				request.setAttribute("status", UtilConstants._MAIL_MESSAGE);
				target = UtilConstants._MAIL_BODY;
			} else {
				request.setAttribute("status",
						UtilConstants.__MAIL_MESSAGE_FAIL);
				target = UtilConstants._MAIL_BODY;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._MAIL_BODY;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
