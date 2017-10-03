package com.cyber.servicei.impl;

import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.ProfileTO;
import com.cyber.daoi.SecurityDaoI;
import com.cyber.daoi.impl.SecurityDaoImpl;
import com.cyber.exception.ConnectionException;
import com.cyber.exception.LoginException;
import com.cyber.servicei.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI {

	String logintype = "";
	boolean flag = false;
	Vector<ProfileTO> vpro = null;
	SecurityDaoI sdaoi = new SecurityDaoImpl();

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException, SQLException {
		vpro = sdaoi.loginCheck(pro);
		return vpro;
	}

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException {
		flag = sdaoi.changePass(pro);
		if (flag == false) {
			throw new ConnectionException();
		}
		return flag;
	}

	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException,
			SQLException {
		return sdaoi.passwordRecovery(pro);
	}

	public boolean forgetPass(ProfileTO pro) throws ConnectionException,
			SQLException {
		return sdaoi.forgetPass(pro);
	}

	public Vector<ProfileTO> viewTips() throws LoginException,
			ConnectionException, SQLException {
		return sdaoi.viewTips();
	}
}
