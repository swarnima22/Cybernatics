package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;

public class ViewApplecantResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vector<ProfileTO> vpro = null;
		String path = "";
		try {
			path = request.getRealPath("/images");
			vpro = new UserDelegate().viewResumes(path);
			if (!vpro.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_RESUME_DOWNLOAD);
				request.setAttribute("vpro", vpro);
				path = UtilConstants._VIEW_RESUME;
			} else {
				request.setAttribute("status", UtilConstants._VIEW_RESUME_FAIL);
				path = UtilConstants._VIEW_RESUME;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", UtilConstants._VIEW_RESUME_FAIL);
			path = UtilConstants._VIEW_RESUME;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
