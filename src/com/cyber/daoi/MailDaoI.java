package com.cyber.daoi;

import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.MailsTO;
import com.cyber.exception.ConnectionException;

public interface MailDaoI {
	public boolean sendMail(MailsTO mail) throws ConnectionException,
			SQLException;

	public Vector<MailsTO> mailContacts() throws ConnectionException,
			SQLException;

	public Vector<MailsTO> viewMails(MailsTO mail) throws ConnectionException,
			SQLException;

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException;

	public Vector<MailsTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException;

	public boolean deleteTips(int messageidx) throws ConnectionException,
			SQLException;
}