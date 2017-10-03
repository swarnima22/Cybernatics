package com.cyber.daoi.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

import com.cyber.bean.CaseTO;
import com.cyber.crypt.util.CryptMsgUtil;
import com.cyber.crypt.util.DecryptFileUtil;
import com.cyber.crypt.util.EncryptFile1Util;
import com.cyber.dao.AbstractDataAccessObject;
import com.cyber.daoi.CaseDAOI;
import com.cyber.util.LoggerManager;
import com.cyber.dao.SqlConstants;
import com.cyber.delegate.CaseDelegate;
import com.cyber.exception.ConnectionException;
import com.cyber.util.DateWrapper;

public class CaseDaoImpl implements CaseDAOI {
	Connection con;
	PreparedStatement pstmt, pstmt1;
	Statement stmt;
	ResultSet rs, rs1;
	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (pstmt1 != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * The insestCaseFile method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when add new case details.....
	 * 
	 * @throws FileNotFoundException
	 *             if an error occurred
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean insestCaseFile(CaseTO cas) throws FileNotFoundException,
			ConnectionException {
		boolean flag = false;
		String casename = cas.getCasename();
		String casedescription = cas.getCasedescription();
		// String filename = cas.getCasefile();
		File file1 = null;
		String filepath = cas.getFilepath();
		CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
		if (filepath != null) {
			System.out.println(casename);
			file1 = EncryptFile1Util.encryptFile(casename, filepath);
			file1.toString().length();
			if (file1 != null) {
				System.out.println("file encrypted   ");
			} else {
				System.out.println("file cannot be encrypted ");
			}
		}
		System.out.println(casename);
		System.out.println(casedescription);
		System.out.println(filepath);
		String fileType = "";
		String fullpath = filepath;
		String[] extension = fullpath.split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			System.out.println(extension[i]);
			fileType = extension[i];
		}

		File file = new File(cas.getFilepath());
		FileInputStream fisfile = new FileInputStream(file);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_CASE_FILE);
			pstmt.setBinaryStream(1, fisfile, (int) file.length());
			pstmt.setString(2, fileType);
			int j = pstmt.executeUpdate();
			if (j > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean insestCaseEvicences(CaseTO cas)
			throws FileNotFoundException, ConnectionException {
		boolean flag = false;
		File encriptFile = null;
		int caseid = cas.getCaseid();
		String casefilename = cas.getCasefile();
		String casename = cas.getCasename();
		System.out.println(caseid);
		System.out.println(casefilename);
		File file1 = null;
		String filepath = casefilename;
		System.out.println(filepath);
		CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
		if (filepath != null) {
			System.out.println(casefilename);
			file1 = EncryptFile1Util.encryptFile(casefilename, filepath);
			file1.toString().length();
			if (file1 != null) {
				System.out.println("file encrypted   ");
			} else {
				System.out.println("file cannot be encrypted ");
			}
		}
		File ff = new File(casefilename);
		FileInputStream fisfile = new FileInputStream(ff);
		System.out.println("fole=" + ff.length());
		String fileType = "";
		String fullpath = casefilename;
		String[] extension = fullpath.split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			System.out.println(extension[i]);
			fileType = extension[i];
		}
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_CASE_EVIDENCES);
			pstmt.setInt(1, caseid);
			pstmt.setBinaryStream(2, fisfile, (int) ff.length());
			pstmt.setString(3, fileType);
			int j = pstmt.executeUpdate();
			if (j > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The insestCaseNameDetails method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when add new caseName details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean insestCaseNameDetails(CaseTO cas)
			throws ConnectionException, SQLException {
		boolean flag = false;
		String casename = cas.getCasename();
		String casedescription = cas.getCasedescription();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_CASE_DETAILS);
			pstmt.setString(1, casename);
			pstmt.setString(2, casedescription);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewCaseDetails method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when add new caseName details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with case details depends upon operation
	 */
	public Vector<CaseTO> viewCaseDetails() throws FileNotFoundException,
			ConnectionException, SQLException {

		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_CASES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(3)));
				cas.setCasedescription(rs.getString(4));
				cas.setCasestatus(rs.getString(5));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgentCaseDetails method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view AgentCaseDetails details.....
	 * 
	 * @param passing
	 *            userid as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with view Agents details depends upon operation
	 */
	public Vector<CaseTO> viewAgentCaseDetails(int userid)
			throws FileNotFoundException, ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;
		System.out.println(userid);
		try {
			System.out.println("hai");
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENT_CASES);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(3)));
				cas.setCasestatus(rs.getString(4));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgencyCaseDetails method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view gency Details details.....
	 * 
	 * @param passing
	 *            userid as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with view Case details depends upon operation
	 */
	public Vector<CaseTO> viewAgencyCaseDetails(int userid)
			throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;
		System.out.println(userid);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENCY_CASES);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseassignid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setAgencyname(rs.getString(3));
				cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(4)));
				cas.setCasestatus(rs.getString(5));
				cas.setCaseid(rs.getInt(6));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewUpdateCases method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Update Cases Details details.....
	 * 
	 * @param passing
	 *            caseid as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with view Case details depends upon operation
	 */
	public Vector<CaseTO> viewUpdateCases(int caseid)
			throws ConnectionException, SQLException {
		Vector<CaseTO> vcmp = new Vector<CaseTO>();
		CaseTO cmp = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_CASES_UPDATE);
			pstmt.setInt(1, caseid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cmp = new CaseTO();
				cmp.setCaseid(rs.getInt(1));
				cmp.setCasename(rs.getString(2));
				cmp.setCaseregdate(DateWrapper.parseDate(rs.getDate(3)));
				cmp.setCasedescription(rs.getString(4));
				cmp.setCasestatus(rs.getString(5));
				vcmp.add(cmp);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcmp;
	}

	/**
	 * The updateCase method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when Update Cases Details details.....
	 * 
	 * @param passing
	 *            Case bean with case details as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with update Case details depends upon operation
	 */
	public boolean updateCase(CaseTO cas) throws ConnectionException {
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._UPDATE_CASE);
			pstmt.setString(1, cas.getCasedescription());
			pstmt.setString(2, cas.getCasestatus());
			pstmt.setInt(3, cas.getCaseid());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {

			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The deleteCases method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when deleteCases Details details.....
	 * 
	 * @param passing
	 *            Caseid as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return true or false depends upon operation
	 */
	public boolean deleteCases(int caseid) throws ConnectionException {
		boolean flag = false;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DELETE_HOLIDAY);
			pstmt.setInt(1, caseid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewCaseFiles method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Case Files details.....
	 * 
	 * @param passing
	 *            Caseid as a one parameter
	 * @param passing
	 *            realpathfor image as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewCaseFiles(int caseid, String realpath,
			String casename) throws FileNotFoundException, ConnectionException {
		Vector<CaseTO> vani = new Vector<CaseTO>();
		CaseTO cas = null;
		String token = null;
		FileOutputStream out = null;
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		File file = null;
		File file1 = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_CASE_FILES);
			pstmt.setInt(1, caseid);
			pstmt.setInt(2, caseid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String path = realpath;
				cas = new CaseTO();
				cas.setCaseid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				cas.setCasedetailsid(rs.getInt(2));
				int caseid1 = cas.getCasedetailsid();
				String path1 = Integer.toString(caseid1);

				/*
				 * file = new File(path = path + "/" + rs.getInt(2) + "." +
				 * rs.getString(4)); out = new FileOutputStream(file); bis = new
				 * BufferedInputStream(rs.getBinaryStream(3)); byte[] bt = new
				 * byte[14170]; System.out.println(bt.length);
				 * System.out.println("folder created"); int ln = 0; while ((ln
				 * = bis.read(bt, 0, bt.length)) != -1) { out.write(bt, 0,
				 * bt.length); file1 = new
				 * DecryptFileUtil().fileDecrypt(file,casename); } fis = new
				 * FileInputStream(file1); bis = new BufferedInputStream(fis);
				 * byte[] bt1 = new byte[14170]; while ((ln = bis.read(bt1, 0,
				 * bt1.length)) != -1) { //fis.write(bt1, 0, bt1.length); }
				 */

				Blob b = rs.getBlob(3);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = path + "/" + rs.getInt(2) + "." + rs.getString(4);
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				cas.setCasefile(rs.getString(4));
				cas.setFilepath(path);
				vani.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vani;
	}

	private File File(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The addAgency method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when addAgency details.....
	 * 
	 * @param passing
	 *            Case bean as one parameter contains casedetails
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return true or false depends upon operation
	 */
	public boolean addAgency(CaseTO cas) throws ConnectException,
			ConnectionException {
		boolean flag = false;
		String agencyname = cas.getAgencyname();
		String agenydescription = cas.getAgencydescription();
		String agencyaddress = cas.getAgencyaddress();
		String agencycontact = cas.getAgencycontact();
		int userid = cas.getCaseid();
		System.out.println(agencyname);
		System.out.println(agenydescription);
		System.out.println(agencyaddress);
		System.out.println(userid);
		System.out.println(agencycontact);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_AGENCY_DETAILS);
			pstmt.setString(1, agencyname);
			pstmt.setString(2, agenydescription);
			pstmt.setString(3, agencyaddress);
			pstmt.setString(4, agencycontact);
			pstmt.setInt(5, userid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;

		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewAgencyDetails method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Agency Details details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAgencyDetails() throws FileNotFoundException,
			ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENCY);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setAgencyid(rs.getInt(1));
				cas.setAgencyname(rs.getString(2));
				cas.setAgencydescription(rs.getString(3));
				cas.setAgencyaddress(rs.getString(4));
				cas.setAgencycontact(rs.getString(5));
				cas.setLoginid(rs.getString(6));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgencyNames method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Agency Names details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAgencyNames() throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENCY);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setAgencyid(rs.getInt(1));
				cas.setAgencyname(rs.getString(2));
				cas.setAgencydescription(rs.getString(3));
				cas.setAgencyaddress(rs.getString(4));
				cas.setAgencycontact(rs.getString(5));
				cas.setLoginid(rs.getString(6));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgentNames method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Agent Names details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAgentNames(int userid)
			throws ConnectionException, SQLException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENTS);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setUserid(rs.getInt(1));
				cas.setLoginid(rs.getString(2));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgentNames method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Agent Names details.....
	 * 
	 * @param passing
	 *            one parameter as userid
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAgencyCaseNames(int userid)
			throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_ASSIGNED_CASES);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, userid);
			pstmt.setInt(3, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setAgencyid(rs.getInt(3));
				cas.setAgencyname(rs.getString(4));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The view Cases Names method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Cases Names Details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewCasesNames() throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_CASES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(3)));
				cas.setCasedescription(rs.getString(4));
				cas.setCasestatus(rs.getString(5));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The assignCases Names method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when Assign Cases Details.....
	 * 
	 * @param passing
	 *            case bean as a one parameter contains case details details
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public boolean assignCases(CaseTO cas) throws ConnectionException {
		boolean flag = false;
		int agencyid = cas.getAgencyid();
		int caseid = cas.getCaseid();
		System.out.println(agencyid);
		System.out.println(caseid);

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._ASSIGN_CASE_AGENCY_DETAILS);
			pstmt.setInt(1, caseid);
			pstmt.setInt(2, agencyid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;

		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewAssignedCaseDetails Names method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view Assigned Case Details.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAssignedCaseDetails() throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._VIEW_AGENCY_ASSIGNED_CASES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cas = new CaseTO();
				cas.setCaseassignid(rs.getInt(1));
				cas.setCasename(rs.getString(2));
				cas.setAgencyname(rs.getString(3));
				cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(4)));
				cas.setCasestatus(rs.getString(5));
				cas.setCaseid(rs.getInt(6));
				vcas.add(cas);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;
	}

	/**
	 * The viewAgentCaseAssinged Names method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when view view AgentCase AssingedDetails.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public Vector<CaseTO> viewAgentCaseAssinged(int userid)
			throws ConnectionException {
		Vector<CaseTO> vcas = new Vector<CaseTO>();
		CaseTO cas = null;
		try {
			con = AbstractDataAccessObject.getConnection();

			pstmt1 = con.prepareStatement(SqlConstants._VIEW_CASE_AGENTS);
			pstmt1.setInt(1, userid);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {

				pstmt = con
						.prepareStatement(SqlConstants._VIEW_AGENT_ASSIGNED_CASES);
				pstmt.setInt(1, rs1.getInt(1));
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cas = new CaseTO();
					cas.setCaseassignid(rs.getInt(1));
					cas.setCasename(rs.getString(2));
					cas.setAgentname(rs.getString(3));
					cas.setCaseregdate(DateWrapper.parseDate(rs.getDate(4)));
					cas.setCasestatus(rs.getString(5));
					vcas.add(cas);
				}
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return vcas;

	}

	/**
	 * The assignAgencyCases Names method of the CaseDaoImpl Class. <br>
	 * 
	 * This method is called when AssignAgencyCases AssingedDetails.....
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector with case details depends upon operation
	 */
	public boolean assignAgencyCases(CaseTO cas) throws ConnectionException {
		boolean flag = false;
		int caseid = cas.getCaseid();
		int agentid = cas.getAgentid();
		int agencyid = cas.getAgencyid();
		System.out.println(caseid);
		System.out.println(agentid);
		System.out.println(agencyid);

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_CASE_AGENT);
			pstmt.setInt(1, caseid);
			// pstmt.setInt(2, agencyid);
			pstmt.setInt(2, agentid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}
}
