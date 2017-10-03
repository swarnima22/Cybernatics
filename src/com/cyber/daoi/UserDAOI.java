package com.cyber.daoi;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;
import com.cyber.bean.ProfileTO;
import com.cyber.exception.ConnectionException;

public interface UserDAOI {

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException;

	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException, SQLException;

	public String checkUser(String userid) throws ConnectionException;

	public Vector<ProfileTO> viewUser(String user, String path) throws ConnectionException;

	public boolean postSuggesstion(ProfileTO pf) throws ConnectionException;

	public Vector<ProfileTO> viewAgencyChiefs() throws FileNotFoundException,
			ConnectionException;

	public Vector<ProfileTO> viewListOfUsers(String usertype,String path,int userid) throws FileNotFoundException,
			ConnectionException;
	public boolean deleteUser(int userid) throws ConnectionException;
	public boolean deleteResume(int userid) throws ConnectionException;
	public boolean postResume(ProfileTO pro) throws ConnectionException;
	public Vector<ProfileTO> viewResumes(String path) throws ConnectionException;
}
