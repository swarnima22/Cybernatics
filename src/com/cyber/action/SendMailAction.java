package com.cyber.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cyber.bean.MailsTO;
import com.cyber.delegate.MailDelegate;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The SendMailAction servlet class implements for to Send Mails.
 * 
 */
public class SendMailAction extends HttpServlet {

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
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		MailsTO mail = new MailsTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(mail, map);
			flag = new MailDelegate().sendMail(mail);
			if (flag) {
				request.setAttribute("status", UtilConstants._SEND_MAIL);
				path = UtilConstants._SEND_MAILS;
			} else {
				request.setAttribute("status", UtilConstants._SEND_MAIL_FAIL);
				path = UtilConstants._SEND_MAILS;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._SEND_MAILS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
