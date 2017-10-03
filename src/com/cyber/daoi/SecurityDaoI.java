package com.cyber.daoi;

import java.sql.SQLException;
import java.util.Vector;
import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;

public interface SecurityDaoI {
	public Vector<ProfileTO> loginCheck(ProfileTO pro)
			throws ConnectionException, SQLException;

	public Vector<ProfileTO> viewTips() throws ConnectionException,
			SQLException;

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException;

	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException,
			SQLException;

	public boolean forgetPass(ProfileTO pro) throws ConnectionException,
			SQLException;
}
