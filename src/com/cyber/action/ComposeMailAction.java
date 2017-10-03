package com.cyber.action;

import java.io.IOException;
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
 * The ComposeMailAction servlet class implements for to compose mails.
 */
public class ComposeMailAction extends HttpServlet {

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
		try {
			vmail = new MailDelegate().mailContacts();
			if (!vmail.isEmpty()) {
				request.setAttribute("mailcontacts", vmail);
				target = UtilConstants._COMPOSE_MAIL;
			} else {
				request.setAttribute("status", UtilConstants._NO_CONTACTS);
				target = UtilConstants._COMPOSE_MAIL;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._COMPOSE_MAIL;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
