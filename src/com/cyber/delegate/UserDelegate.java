package com.cyber.delegate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;
import com.cyber.servicei.UserServiceI;
import com.cyber.servicei.impl.UserServiceImpl;
import com.cyber.exception.LoginException;
import com.cyber.servicei.SecurityServiceI;
import com.cyber.servicei.impl.SecurityServiceImpl;

public class UserDelegate {

	UserServiceI usi = new UserServiceImpl();
	SecurityServiceI ssi = new SecurityServiceImpl();
	Vector<ProfileTO> vpro = null;

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
		return usi.insertNewUser(pf);
	}

	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException, SQLException {
		return usi.updateUser(pf);
	}

	public String checkUser(String userName) throws ConnectionException {

		return usi.checkUser(userName);

	}

	public Vector<ProfileTO> viewUser(String path, String user)
			throws FileNotFoundException, ConnectionException {
		return usi.viewUser(path, user);
	}

	public Vector<ProfileTO> viewAgencyChiefs() throws FileNotFoundException,
			ConnectionException {
		return usi.viewAgencyChiefs();
	}

	public Vector<ProfileTO> viewListOfUsers(String usertype, String path,int userid)
			throws FileNotFoundException, ConnectionException {
		return usi.viewListOfUsers(usertype, path,userid);
	}

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException, SQLException {
		vpro = ssi.loginCheck(pro);
		return vpro;
	}

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException {
		return ssi.changePass(pro);
	}

	public boolean postSuggesstion(ProfileTO pro) throws ConnectionException {
		return usi.postSuggesstion(pro);
	}

	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException,
			SQLException {
		return ssi.passwordRecovery(pro);
	}

	public boolean forgetPass(ProfileTO pro) throws ConnectionException,
			SQLException {
		return ssi.forgetPass(pro);
	}

	public boolean deleteUser(int userid) throws ConnectionException {
		return usi.deleteUser(userid);
	}

	public Vector<ProfileTO> viewTips() throws LoginException,
			ConnectionException, SQLException {
		vpro = ssi.viewTips();
		return vpro;
	}public boolean postResume(ProfileTO pro) throws ConnectionException {
		return usi.postResume(pro);
	}
	public Vector<ProfileTO> viewResumes(String path) throws ConnectionException {
		return usi.viewResumes(path);
	}
	public boolean deleteResume(int userid) throws ConnectionException {
		return usi.deleteResume(userid);
	}
}
