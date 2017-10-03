package com.cyber.daoi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.cyber.bean.MailsTO;
import com.cyber.dao.AbstractDataAccessObject;
import com.cyber.dao.SqlConstants;
import com.cyber.daoi.MailDaoI;
import com.cyber.exception.ConnectionException;
import com.cyber.util.DateWrapper;

public class MailDaoImpl implements MailDaoI {
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
	 * The deleteMails method of the MailDaoImpl Class.
	 * 
	 * This method is called when to deletemails details.
	 * 
	 * @param Passing
	 *            msgid as a one parameter.
	 * @param Passing
	 *            mailbox as a one parameter.
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = AbstractDataAccessObject.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._DELETE_MAIL);
			else
				pstmt = con.prepareStatement(SqlConstants._DELETE_MAIL1);
			pstmt.setInt(1, msgid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}

		finally {
			closeConnection();
		}
		return flag;
	}

	public boolean deleteTips(int messageidx) throws ConnectionException,
			SQLException {
		boolean flag = false;

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._TIPS_SUGGESTION);
			pstmt.setInt(1, messageidx);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}
		finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The mailContacts method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mailContacts.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with mail details depends upon operations.
	 */
	public Vector<MailsTO> mailContacts() throws ConnectionException,
			SQLException {
		Vector<MailsTO> vmail = new Vector<MailsTO>();
		MailsTO mail = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._MAIL_CONTACTS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailsTO();
				mail.setEmpid(rs.getInt(1));
				mail.setMailid(rs.getString(2));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return vmail;
	}

	/**
	 * The viewMails method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mails.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with mail details depends upon operations.
	 */
	public Vector<MailsTO> viewMails(MailsTO mailsTO)
			throws ConnectionException {
		Vector<MailsTO> vmail = new Vector<MailsTO>();
		int empid = mailsTO.getEmpid();
		System.out.println(empid);
		String mailbox = mailsTO.getRequesttype();
		MailsTO mail = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._VIEW_OUT_MAILS);
			else
				pstmt = con.prepareStatement(SqlConstants._VIEW_IN_MAILS);
			pstmt.setInt(1, empid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailsTO();
				mail.setMessageid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				mail.setFrommailid(rs.getInt(2));
				mail.setTomailid(rs.getInt(3));
				pstmt = con.prepareStatement(SqlConstants._VIEW_MAILID);
				pstmt.setInt(1, rs.getInt(3));
				System.out.println(rs.getInt(3));
				rs1 = pstmt.executeQuery();
				if (rs1.next()) {
					mail.setEmploginid(rs1.getString(1));
				}
				mail.setMailsub(rs.getString(4));
				mail.setMailbody(rs.getString(5));
				mail.setMaildate(DateWrapper.parseDate(rs.getDate(6)));
				mail.setMailbox(mailbox);
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}

		return vmail;
	}

	/**
	 * The sendMail method of the MailDaoImpl Class.
	 * 
	 * This method is called when to sensMails details.
	 * 
	 * @param Passing
	 *            Mail bean as a one parameter.
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws ConnectionException
	 */
	public boolean sendMail(MailsTO mail) throws ConnectionException,
			SQLException {
		boolean flag = false;
		try {
			con = AbstractDataAccessObject.getConnection();
			int frommailid = mail.getFrommailid();
			int empid = mail.getEmpid();
			System.out.println(empid);
			System.out.println(frommailid);
			String mailsub = mail.getMailsub();
			String mailbody = mail.getMailbody();
			pstmt = con.prepareStatement(SqlConstants._SEND_MAIL);
			pstmt1 = con.prepareStatement(SqlConstants._SEND_MAIL1);
			pstmt.setInt(1, frommailid);
			pstmt1.setInt(1, frommailid);
			pstmt.setInt(2, empid);
			pstmt1.setInt(2, empid);
			pstmt.setString(3, mailsub);
			pstmt1.setString(3, mailsub);
			pstmt.setString(4, mailbody);
			pstmt1.setString(4, mailbody);

			int i = pstmt.executeUpdate();
			int j = pstmt1.executeUpdate();
			if (i > 0 && j > 0) {
				flag = true;
				con.commit();
			} else
				flag = false;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}

		finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewMail method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mails.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with maildetails depends upon operations.
	 */
	public Vector<MailsTO> viewMail(int msgid, String mailbox)
			throws ConnectionException {
		Vector<MailsTO> vmail = new Vector<MailsTO>();
		System.out.println(msgid);
		System.out.println(mailbox);
		MailsTO mail = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._VIEW_OUT_MAIL);
			else
				pstmt = con.prepareStatement(SqlConstants._VIEW_IN_MAIL);
			pstmt.setInt(1, msgid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailsTO();
				mail.setMessageid(rs.getInt(1));
				mail.setFrommailid(rs.getInt(2));
				mail.setTomailid(rs.getInt(3));
				pstmt = con.prepareStatement(SqlConstants._VIEW_MAILID);
				pstmt.setInt(1, rs.getInt(3));
				rs1 = pstmt.executeQuery();
				if (rs1.next()) {
					mail.setEmploginid(rs1.getString(1));
				}
				mail.setMailsub(rs.getString(4));
				mail.setMailbody(rs.getString(5));
				System.out.println(rs.getString(5));
				mail.setMaildate(DateWrapper.parseDate(rs.getDate(6)));
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return vmail;
	}

}
