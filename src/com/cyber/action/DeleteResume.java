package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;

public class DeleteResume extends HttpServlet {

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
		String ch[] = request.getParameterValues("ch");
		try {
			for (int i = 0; i < ch.length; i++) {
				System.out.println(ch[i]);
				flag = new UserDelegate().deleteResume(Integer.parseInt(ch[i]));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			if (flag) {
				request.setAttribute("status",
						UtilConstants._RESUME_DELETE_SUCCESS);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._RESUME_DELETE_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", UtilConstants._RESUME_DELETE_FAIL);
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
