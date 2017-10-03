package com.cyber.servicei.impl;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.CaseTO;
import com.cyber.bean.ProfileTO;
import com.cyber.daoi.CaseDAOI;
import com.cyber.daoi.UserDAOI;
import com.cyber.daoi.impl.CaseDaoImpl;
import com.cyber.daoi.impl.UserDaoImpl;
import com.cyber.exception.ConnectionException;
import com.cyber.servicei.CaseServiceI;

public class CaseServiceImpl implements CaseServiceI {
	CaseDAOI rdao = new CaseDaoImpl();
	boolean flag = false;
	Vector<ProfileTO> vpro = new Vector<ProfileTO>();

	public boolean insestCaseFile(CaseTO cas) throws FileNotFoundException,
			SQLException, ConnectException, ConnectionException {
		return rdao.insestCaseFile(cas);
	}
	public boolean insestCaseEvicences(CaseTO cas) throws FileNotFoundException,
	SQLException, ConnectException, ConnectionException {
return rdao.insestCaseEvicences(cas);
}
	
	public boolean insestCaseNameDetails(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return rdao.insestCaseNameDetails(cas);
	}

	public Vector<CaseTO> viewCaseDetails() throws FileNotFoundException,
			ConnectionException, SQLException {
		return rdao.viewCaseDetails();
	}

	public Vector<CaseTO> viewAgencyDetails() throws FileNotFoundException,
			ConnectionException {
		return rdao.viewAgencyDetails();
	}

	public Vector<CaseTO> viewUpdateCases(int caseid)
			throws FileNotFoundException, ConnectionException, SQLException {
		return rdao.viewUpdateCases(caseid);
	}

	public boolean updateCase(CaseTO cas) throws SQLException, ConnectException, ConnectionException {
		return rdao.updateCase(cas);
	}

	public boolean deleteCases(int caseid) throws SQLException,
			ConnectException, ConnectionException {
		return rdao.deleteCases(caseid);
	}

	public Vector<CaseTO> viewCaseFiles(int caseid, String path,String casename)
			throws FileNotFoundException, ConnectionException {
		return rdao.viewCaseFiles(caseid, path,casename);
	}

	public boolean addAgency(CaseTO cas) throws SQLException, ConnectException, ConnectionException {
		return rdao.addAgency(cas);
	}

	public Vector<CaseTO> viewAgencyNames() throws ConnectionException {
		return rdao.viewAgencyNames();
	}

	public Vector<CaseTO> viewCasesNames() throws ConnectionException {
		return rdao.viewCasesNames();
	}

	public boolean assignCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return rdao.assignCases(cas);
	}

	public Vector<CaseTO> viewAssignedCaseDetails() throws ConnectionException, SQLException {
		return rdao.viewAssignedCaseDetails();
	}

	public Vector<CaseTO> viewAgencyCaseDetails(int userid)
			throws ConnectionException {
		return rdao.viewAgencyCaseDetails(userid);
	}

	public Vector<CaseTO> viewAgencyCaseNames(int userid)
			throws ConnectionException {
		return rdao.viewAgencyCaseNames(userid);
	}

	public Vector<CaseTO> viewAgentNames(int userid) throws ConnectionException, SQLException {
		return rdao.viewAgentNames(userid);
	}

	public boolean assignAgencyCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException {
		return rdao.assignAgencyCases(cas);
	}

	public Vector<CaseTO> viewAgentCaseAssinged(int userid) throws ConnectionException, SQLException {
		return rdao.viewAgentCaseAssinged(userid);
	}

	public Vector<CaseTO> viewAgentCaseDetails(int userid) throws FileNotFoundException,
			ConnectionException {
		return rdao.viewAgentCaseDetails(userid);
	}
}
