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

/**
 * The AgencyChieffAction servlet class implements for to view AgencyChiefs
 * details.
 */
public class AgencyChieffAction extends HttpServlet {

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
		Vector<ProfileTO> vprofile = null;
		try {
			vprofile = new UserDelegate().viewAgencyChiefs();
			if (!vprofile.isEmpty()) {
				request.setAttribute("agencychiefnames", vprofile);
				target = UtilConstants._AGENCY_CHIEF_NAMES;
			} else {
				request.setAttribute("status1",
						UtilConstants._AGENCY_CHIEF_NAMES_FAIL);
				target = UtilConstants._AGENCY_CHIEF_NAMES;
			}
		} catch (Exception e) {
			request.setAttribute("status1", e.getMessage());
			target = UtilConstants._AGENCY_CHIEF_NAMES;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
