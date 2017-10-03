package com.cyber.servicei;

import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;
import com.cyber.exception.LoginException;

public interface SecurityServiceI {

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException, SQLException;

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException;

	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException,
			SQLException;

	public boolean forgetPass(ProfileTO pro) throws ConnectionException,
			SQLException;

	public Vector<ProfileTO> viewTips() throws LoginException,
			ConnectionException, SQLException;
}
