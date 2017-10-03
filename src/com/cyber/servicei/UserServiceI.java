package com.cyber.servicei;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;

public interface UserServiceI {

	public boolean insertNewUser(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException;

	public String checkUser(String userName) throws ConnectionException;

	public Vector<ProfileTO> viewUser(String user, String path)
			throws FileNotFoundException, ConnectionException;

	public boolean updateUser(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException, SQLException;

	public boolean postSuggesstion(ProfileTO profileTO)
			throws ConnectionException;

	public Vector<ProfileTO> viewAgencyChiefs() throws FileNotFoundException,
			ConnectionException;
	public Vector<ProfileTO> viewListOfUsers(String usertype,String path,int userid) throws FileNotFoundException,
	ConnectionException;
	public boolean deleteUser(int userid) throws ConnectionException ;
	public boolean deleteResume(int userid) throws ConnectionException ;
	public boolean postResume(ProfileTO pro) throws ConnectionException;
	public Vector<ProfileTO> viewResumes(String path) throws ConnectionException ;
}
