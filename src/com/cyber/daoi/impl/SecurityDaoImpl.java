package com.cyber.daoi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cyber.bean.ProfileTO;
import com.cyber.daoi.SecurityDaoI;
import com.cyber.dao.AbstractDataAccessObject;
import com.cyber.dao.SqlConstants;
import com.cyber.exception.ConnectionException;
import com.cyber.util.UtilConstants;

public class SecurityDaoImpl implements SecurityDaoI {

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
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
	 * The loginCheck method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to Check login user details.....
	 * 
	 * @param passing
	 *            Profile bean with login id, passord as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with user details depends upon operation
	 */
	public Vector<ProfileTO> loginCheck(ProfileTO pro)
			throws ConnectionException {
		String logintype = "";
		ProfileTO profileTO = null;
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._CHECK_USER);
			String username = pro.getUserName();
			System.out.println("in Security DAO class.....uname is" + username);
			String password = pro.getPassword();
			System.out.println("in Security DAO class.....password is"
					+ password);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				profileTO = new ProfileTO();
				profileTO.setUserid(rs.getInt(1));
				profileTO.setLogintype(rs.getString(3));
				profileTO.setLoginid(rs.getString(2));
				vpro.add(profileTO);
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
		return vpro;
	}

	public Vector<ProfileTO> viewTips() throws ConnectionException {
		String logintype = "";
		ProfileTO profileTO = null;
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._TIPS_SUGGESSTIONS);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				profileTO = new ProfileTO();
				profileTO.setTipid(rs.getInt(1));
				profileTO.setCitizen(rs.getString(2));
				profileTO.setCitizenemail(rs.getString(3));
				profileTO.setTipssuggestions(rs.getString(4));
				vpro.add(profileTO);
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
		return vpro;
	}

	/**
	 * The changePass method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to Password change details.....
	 * 
	 * @param passing
	 *            Profile bean with login id, passord as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return Vector bean with user details depends upon operation
	 */
	public boolean changePass(ProfileTO pf) throws ConnectionException {
		try {
			con = AbstractDataAccessObject.getConnection();
			String newpass = pf.getNewpassword();
			System.out.println(" security dao new pass " + newpass);
			String user = pf.getUserName();
			System.out.println("security	  dao user :" + user);
			String oldpass = pf.getOldpassword();
			System.out.println("security dao oldpass :" + oldpass);
			pstmt = con.prepareStatement(SqlConstants._CHANGE_PASSWORD);
			pstmt.setString(1, newpass);
			pstmt.setString(2, user);
			pstmt.setString(3, oldpass);
			int c = pstmt.executeUpdate();
			if (c > 0) {
				flag = true;
				con.commit();
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
	 * The passwordRecovery method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to Recover password user details.....
	 * 
	 * @param passing
	 *            Profile bean with login id, passord as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return true or false depends upon operation
	 */
	public boolean passwordRecovery(ProfileTO pf) throws ConnectionException {
		try {
			con = AbstractDataAccessObject.getConnection();
			String question = pf.getSquest();
			if (question == null)
				question = pf.getOwnquest();
			String ans = pf.getSecrete();
			String loginid = pf.getUserName();
			pstmt = con.prepareStatement(SqlConstants._RECOVER_PASSWORD);
			pstmt.setString(1, loginid);
			pstmt.setString(2, question);
			pstmt.setString(3, ans);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
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
	 * The forgetPass method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to forget password user details.....
	 * 
	 * @param passing
	 *            Profile bean with login id, passord as a one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @return true or false depends upon operation
	 */
	public boolean forgetPass(ProfileTO pf) throws ConnectionException {
		boolean flag = true;

		try {
			con = AbstractDataAccessObject.getConnection();
			String pwd = pf.getPassword();
			System.out.println("in Dao pwd is..." + pwd);
			String loginid = pf.getUserName();
			System.out.println("in Dao loginid is..." + loginid);
			pstmt = con.prepareStatement(SqlConstants._NEW_PASSWORD);
			pstmt.setString(1, pwd);
			pstmt.setString(2, loginid);

			int update = pstmt.executeUpdate();
			if (update > 0) {
				con.commit();
			} else {
				flag = false;
				con.rollback();
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

}