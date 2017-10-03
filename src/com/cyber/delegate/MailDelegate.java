package com.cyber.delegate;

import java.sql.SQLException;
import java.util.Vector;
import com.cyber.bean.MailsTO;
import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;
import com.cyber.servicei.MailServiceI;
import com.cyber.servicei.impl.MailServiceImpl;

public class MailDelegate {
	MailServiceI usi = new MailServiceImpl();
	boolean flag = false;
	Vector<ProfileTO> vpro = null;

	public Vector<MailsTO> mailContacts() throws ConnectionException, SQLException {
		return usi.mailContacts();
	}

	public boolean sendMail(MailsTO mail) throws ConnectionException,
			SQLException {
		flag = usi.sendMail(mail);
		return flag;
	}

	public Vector<MailsTO> viewMails(MailsTO mail) throws ConnectionException, SQLException {
		return usi.viewMails(mail);
	}

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException {
		flag = usi.deleteMails(msgid, mailbox);
		return flag;
	}

	public Vector<MailsTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException {
		return usi.viewMail(messageid, mailbox);
	}
	public boolean deleteTips(int messageid)
	throws ConnectionException, SQLException {
return usi.deleteTips(messageid);
}
	
}
