package com.cyber.servicei.impl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import com.cyber.bean.ProfileTO;
import com.cyber.daoi.UserDAOI;
import com.cyber.daoi.impl.UserDaoImpl;
import com.cyber.exception.ConnectionException;
import com.cyber.exception.DataNotFoundException;
import com.cyber.servicei.UserServiceI;

public class UserServiceImpl implements UserServiceI {

	UserDAOI rdao = new UserDaoImpl();
	boolean flag = false;
	Vector<ProfileTO> vpro = new Vector<ProfileTO>();

	public boolean postSuggesstion(ProfileTO pf) throws ConnectionException {
		// TODO Auto-generated method stub
		return rdao.postSuggesstion(pf);
	}

	public boolean changeQuestion(ProfileTO pf) throws ConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
		flag = rdao.insertNewUser(pf);
		return flag;
	}

	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException, SQLException {
		flag = rdao.updateUser(pf);
		return flag;
	}

	public boolean logout(String loginid) throws ConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<ProfileTO> viewUser(String path, String user)
			throws FileNotFoundException, ConnectionException {
		vpro = rdao.viewUser(path, user);
		return vpro;
	}

	public String checkUser(String userName) throws ConnectionException {
		userName = rdao.checkUser(userName);
		return userName;
	}

	public Vector<ProfileTO> viewAgencyChiefs() throws FileNotFoundException,
			ConnectionException {
		vpro = rdao.viewAgencyChiefs();
		return vpro;
	}

	public Vector<ProfileTO> viewListOfUsers(String usertype, String path,int userid)
			throws FileNotFoundException, ConnectionException {
		return rdao.viewListOfUsers(usertype, path,userid);

	}

	public boolean deleteUser(int userid) throws ConnectionException {
		return rdao.deleteUser(userid);
	}
	public boolean deleteResume(int userid) throws ConnectionException {
		return rdao.deleteResume(userid);
	}
	public boolean postResume(ProfileTO pro) throws ConnectionException {
		return rdao.postResume(pro);
	}

	public Vector<ProfileTO> viewResumes(String path)
			throws ConnectionException {
		return rdao.viewResumes(path);
	}
}
