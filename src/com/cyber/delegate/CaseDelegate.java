package com.cyber.delegate;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.CaseTO;
import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;
import com.cyber.servicei.CaseServiceI;
import com.cyber.servicei.SecurityServiceI;
import com.cyber.servicei.UserServiceI;
import com.cyber.servicei.impl.CaseServiceImpl;
import com.cyber.servicei.impl.SecurityServiceImpl;
import com.cyber.servicei.impl.UserServiceImpl;

public class CaseDelegate {
	CaseServiceI usi = new CaseServiceImpl();

	Vector<ProfileTO> vpro = null;

	public boolean insestCaseFile(CaseTO cas) throws FileNotFoundException,
			SQLException, ConnectException, ConnectionException {
		return usi.insestCaseFile(cas);
	}

	public boolean insestCaseEvicences(CaseTO cas)
			throws FileNotFoundException, SQLException, ConnectException,
			ConnectionException {
		return usi.insestCaseEvicences(cas);
	}

	public boolean insestCaseNameDetails(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return usi.insestCaseNameDetails(cas);
	}

	public boolean updateCase(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return usi.updateCase(cas);
	}

	public Vector<CaseTO> viewCaseDetails() throws FileNotFoundException,
			ConnectionException, SQLException {
		return usi.viewCaseDetails();
	}

	public Vector<CaseTO> viewAgentCaseDetails(int userid)
			throws FileNotFoundException, ConnectionException {
		return usi.viewAgentCaseDetails(userid);
	}

	public Vector<CaseTO> viewAgencyCaseDetails(int userid)
			throws ConnectionException {
		return usi.viewAgencyCaseDetails(userid);
	}

	public Vector<CaseTO> viewAgencyDetails() throws FileNotFoundException,
			ConnectionException {
		return usi.viewAgencyDetails();
	}

	public Vector<CaseTO> viewUpdateCases(int caseid)
			throws FileNotFoundException, ConnectionException, SQLException {
		return usi.viewUpdateCases(caseid);
	}

	public boolean deleteCases(int caseid) throws SQLException,
			ConnectException, ConnectionException {
		return usi.deleteCases(caseid);
	}

	public Vector<CaseTO> viewCaseFiles(int caseid, String path,String casename)
			throws FileNotFoundException, ConnectionException {
		return usi.viewCaseFiles(caseid, path,casename);
	}

	public boolean addAgency(CaseTO cas) throws SQLException, ConnectException,
			ConnectionException {
		return usi.addAgency(cas);
	}

	public boolean assignCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return usi.assignCases(cas);
	}

	public Vector<CaseTO> viewAgencyNames() throws ConnectionException {
		return usi.viewAgencyNames();
	}

	public Vector<CaseTO> viewCasesNames() throws ConnectionException {
		return usi.viewCasesNames();
	}

	public Vector<CaseTO> viewAgencyCaseNames(int userid)
			throws ConnectionException {
		return usi.viewAgencyCaseNames(userid);
	}

	public Vector<CaseTO> viewAgentNames(int userid)
			throws ConnectionException, SQLException {
		return usi.viewAgentNames(userid);
	}

	public Vector<CaseTO> viewAssignedCaseDetails() throws ConnectionException,
			SQLException {
		return usi.viewAssignedCaseDetails();
	}

	public boolean assignAgencyCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return usi.assignAgencyCases(cas);
	}

	public Vector<CaseTO> viewAgentCaseAssinged(int userid) throws ConnectionException,
			SQLException {
		return usi.viewAgentCaseAssinged(userid);
	}
}
