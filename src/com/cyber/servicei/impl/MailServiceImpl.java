package com.cyber.servicei.impl;

import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.MailsTO;
import com.cyber.bean.ProfileTO;
import com.cyber.daoi.MailDaoI;
import com.cyber.daoi.impl.MailDaoImpl;
import com.cyber.exception.ConnectionException;
import com.cyber.servicei.MailServiceI;

public class MailServiceImpl implements MailServiceI{

	boolean flag=false;
	Vector<ProfileTO> vpro=null;
	MailDaoI mdaoi=new MailDaoImpl();
	
	public Vector<MailsTO> mailContacts() throws ConnectionException, SQLException{
		return mdaoi.mailContacts();
	}
	public boolean sendMail(MailsTO mail) throws ConnectionException,SQLException {
		flag = mdaoi.sendMail(mail);
		return flag;
	}
	public Vector<MailsTO> viewMails(MailsTO mail) throws ConnectionException, SQLException
	{
		return mdaoi.viewMails(mail);
	}
	public boolean 	deleteMails(int msgid,String mailbox) throws ConnectionException,SQLException {
		flag = mdaoi.deleteMails(msgid,mailbox);
		return flag;
	}
	public Vector<MailsTO> viewMail(int messageid,String mailbox)
	 throws ConnectionException, SQLException {
		return mdaoi.viewMail(messageid,mailbox);
	}
	public boolean 	deleteTips(int msgid) throws ConnectionException,SQLException{
		flag = mdaoi.deleteTips(msgid);
		return flag;}
	}

