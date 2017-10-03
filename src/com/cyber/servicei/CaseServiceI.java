package com.cyber.servicei;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.CaseTO;
import com.cyber.exception.ConnectionException;

public interface CaseServiceI {
	public boolean insestCaseFile(CaseTO cas) throws FileNotFoundException,
			SQLException, ConnectException, ConnectionException;

	public boolean insestCaseEvicences(CaseTO cas)
			throws FileNotFoundException, SQLException, ConnectException,
			ConnectionException;

	public boolean insestCaseNameDetails(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException;

	public boolean updateCase(CaseTO cas) throws SQLException, ConnectException, ConnectionException;

	public Vector<CaseTO> viewCaseDetails() throws FileNotFoundException,
			ConnectionException, SQLException;

	public Vector<CaseTO> viewUpdateCases(int caseid)
			throws FileNotFoundException, ConnectionException, SQLException;

	public boolean deleteCases(int caseid) throws SQLException,
			ConnectException, ConnectionException;

	public Vector<CaseTO> viewCaseFiles(int caseid, String path,String casename)
			throws FileNotFoundException, ConnectionException;

	public boolean addAgency(CaseTO cas) throws SQLException, ConnectException, ConnectionException;

	public Vector<CaseTO> viewAgencyDetails() throws FileNotFoundException,
			ConnectionException;

	public Vector<CaseTO> viewAgencyNames() throws ConnectionException;

	public Vector<CaseTO> viewCasesNames() throws ConnectionException;

	public boolean assignCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException;

	public Vector<CaseTO> viewAssignedCaseDetails() throws ConnectionException, SQLException;

	public Vector<CaseTO> viewAgencyCaseDetails(int userid)
			throws ConnectionException;

	public Vector<CaseTO> viewAgencyCaseNames(int userid)
			throws ConnectionException;

	public Vector<CaseTO> viewAgentNames(int userid) throws ConnectionException, SQLException;

	public boolean assignAgencyCases(CaseTO cas) throws SQLException,
			ConnectException, ConnectionException;

	public Vector<CaseTO> viewAgentCaseAssinged(int userid) throws ConnectionException, SQLException;

	public Vector<CaseTO> viewAgentCaseDetails(int userid)
			throws FileNotFoundException, ConnectionException;
}
