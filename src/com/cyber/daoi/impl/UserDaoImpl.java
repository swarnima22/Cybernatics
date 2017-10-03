package com.cyber.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import com.cyber.bean.ProfileTO;
import com.cyber.dao.AbstractDataAccessObject;
import com.cyber.dao.SqlConstants;
import com.cyber.daoi.UserDAOI;
import com.cyber.exception.ConnectionException;
import com.cyber.util.DateWrapper;

public class UserDaoImpl implements UserDAOI {
	Connection con;
	PreparedStatement pstmt, pstmt1;
	Statement stmt;
	ResultSet rs, rs1;

	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (pstmt1 != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	public String checkUser(String userName) throws ConnectionException {
		String user = null;
		System.out.println("username" + userName);
		try {
			con = AbstractDataAccessObject.getConnection();
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall("{ call loginidavailablity(?,?) }");
			cstmt.setString(1, userName);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			user = cstmt.getString(2);
		} catch (SQLException e) {
			throw new ConnectionException("Available");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return user;
	}

	public Vector<ProfileTO> viewUser(String userid, String realpath)
			throws ConnectionException {
		Vector<ProfileTO> v = new Vector<ProfileTO>();
		ProfileTO pro = null;
		v.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_USER_PROFILE);
			pstmt.setString(1, userid);
			System.out.println(userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new ProfileTO();
				pro.setUserid(rs.getInt(1));
				pro.setFirstName(rs.getString(2));
				pro.setLastName(rs.getString(3));
				pro.setBirthdate(DateWrapper.parseDate(rs.getDate(4)));
				pro.setEmail(rs.getString(5));
				Blob b = rs.getBlob(6);
				byte b1[] = b.getBytes(1, (int) b.length());
				String path = realpath + "/" + rs.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				pro.setPhoto(path);
				pro.setGender(rs.getString(7));
				pro.setAddressid(rs.getInt(8));
				pro.setAddressType(rs.getString(9));
				pro.setHouseNo(rs.getString(10));
				pro.setStreet(rs.getString(11));
				pro.setCity(rs.getString(12));
				pro.setDistrict(rs.getString(13));
				pro.setState(rs.getString(14));
				pro.setCountry(rs.getString(15));
				pro.setPin(rs.getString(16));
				pro.setPhoneType(rs.getString(17));
				pro.setPhoneNo(rs.getString(18));
				v.add(pro);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return v;
	}

	public boolean insertNewUser(ProfileTO pro) throws FileNotFoundException,
			ConnectionException {
		boolean flag = false;
		int i = 0;
		String firstname = pro.getFirstName();
		System.out.println("firstname  :" + firstname);
		String lastname = pro.getLastName();
		System.out.println("lastname- " + lastname);
		String birthdate = DateWrapper.parseDate(pro.getBirthdate());
		System.out.println("birthdate-" + birthdate);
		String squest = pro.getSquest();
		// System.out.println("squest-"+squest);
		if (squest == null) {
			squest = pro.getOwnquest();
			System.out.println("squest" + squest);
		}
		String sqansw = pro.getSecrete();
		System.out.println("sqansw :" + sqansw);
		String email = pro.getEmail();
		System.out.println("email-" + email);
		String gender = pro.getGender();
		System.out.println("gender-" + gender);
		String addresstype = pro.getAddressType();
		System.out.println("addresstype-" + addresstype);
		String houseno = pro.getHouseNo();
		System.out.println("houseno:" + houseno);
		String street = pro.getStreet();
		System.out.println("street-" + street);
		String city = pro.getCity();
		System.out.println("city-" + city);
		String district = pro.getDistrict();
		System.out.println("district-" + district);
		String state = pro.getState();
		System.out.println("state-" + state);
		String country = pro.getCountry();
		System.out.println("country" + country);
		String pin = pro.getPin();

		System.out.println("pin" + pin);
		String phonetype = pro.getPhoneType();
		System.out.println("phonetype-" + phonetype);
		String phoneno = pro.getPhoneNo();
		System.out.println("phoneno-" + phoneno);
		String logintype = pro.getLogintype();
		System.out.println("logintype-" + logintype);
		String username = pro.getUserName();
		System.out.println("username-" + username);
		String password = pro.getPassword();
		System.out.println("password-" + password);
		String photo = pro.getPhoto();
		String role = pro.getLoginid();
		int userid = pro.getUserid();
		try {
			con = AbstractDataAccessObject.getConnection();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			if (role.equalsIgnoreCase("AgentChief")) {
				CallableStatement cstmt = con
						.prepareCall("{ call insertprocedure1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setBinaryStream(1, fis, (int) f.length());
				cstmt.setString(2, firstname);
				cstmt.setString(3, lastname);
				cstmt.setString(4, birthdate);
				cstmt.setString(5, squest);
				cstmt.setString(6, sqansw);
				cstmt.setString(7, email);
				cstmt.setString(8, gender);
				cstmt.setString(9, username);
				cstmt.setString(10, password);
				cstmt.setString(11, logintype);
				cstmt.setString(12, addresstype);
				cstmt.setString(13, houseno);
				cstmt.setString(14, street);
				cstmt.setString(15, city);
				cstmt.setString(16, district);
				cstmt.setString(17, state);
				cstmt.setString(18, country);
				cstmt.setString(19, pin);
				cstmt.setString(20, phoneno);
				cstmt.setString(21, phonetype);
				cstmt.setInt(22, userid);
				i = cstmt.executeUpdate();
			} else {
				CallableStatement cstmt = con
						.prepareCall("{ call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				cstmt.setBinaryStream(1, fis, (int) f.length());
				cstmt.setString(2, firstname);
				cstmt.setString(3, lastname);
				cstmt.setString(4, birthdate);
				cstmt.setString(5, squest);
				cstmt.setString(6, sqansw);
				cstmt.setString(7, email);
				cstmt.setString(8, gender);
				cstmt.setString(9, username);
				cstmt.setString(10, password);
				cstmt.setString(11, logintype);
				cstmt.setString(12, addresstype);
				cstmt.setString(13, houseno);
				cstmt.setString(14, street);
				cstmt.setString(15, city);
				cstmt.setString(16, district);
				cstmt.setString(17, state);
				cstmt.setString(18, country);
				cstmt.setString(19, pin);
				cstmt.setString(20, phoneno);
				cstmt.setString(21, phonetype);
				i = cstmt.executeUpdate();
			}
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
			}
			con.close();
		} catch (SQLException e) {
			throw new ConnectionException(

			"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean updateUser(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException, SQLException {
		boolean flag = false;
		try {
			System.out.println("hsi");
			con = AbstractDataAccessObject.getConnection();
			int userid = profileTO.getUserid();
			String firstname = profileTO.getFirstName();
			String lastname = profileTO.getLastName();
			System.out.println(profileTO.getPhoto1());
			String birthdate = DateWrapper.parseDate(profileTO.getBirthdate());
			String photo = profileTO.getPhoto1();
			System.out.println("hsi" + photo);
			System.out.println("hao");
			if (photo.equals("")) {
				photo = profileTO.getPhoto();
			}
			String email = profileTO.getEmail();
			String gender = profileTO.getGender();
			String addresstype = profileTO.getAddressType();
			String houseno = profileTO.getHouseNo();
			String street = profileTO.getStreet();
			String city = profileTO.getCity();
			String district = profileTO.getDistrict();
			String state = profileTO.getState();
			String country = profileTO.getCountry();
			String pin = profileTO.getPin();
			String phoneno = profileTO.getPhoneNo();
			con = AbstractDataAccessObject.getConnection();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			CallableStatement cstmt = con
					.prepareCall("{call updateprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(2, userid);
			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(3, firstname);
			System.out.println("firstname :" + firstname);
			cstmt.setString(4, lastname);
			System.out.println("lastname :" + lastname);
			cstmt.setString(5, birthdate);
			System.out.println("birthdate :" + birthdate);
			cstmt.setString(6, email);
			System.out.println("email :" + email);
			cstmt.setString(7, gender);
			System.out.println("gender :" + gender);
			cstmt.setString(8, addresstype);
			System.out.println("addresstype :" + addresstype);
			cstmt.setString(9, houseno);
			System.out.println("houseno :" + houseno);
			cstmt.setString(10, street);
			System.out.println("street :" + street);
			cstmt.setString(11, city);
			System.out.println("city :" + city);
			cstmt.setString(12, district);
			System.out.println("district :" + district);
			cstmt.setString(13, state);
			System.out.println("state :" + state);
			cstmt.setString(14, country);
			System.out.println("country :" + country);
			cstmt.setString(15, pin);
			System.out.println("pin :" + pin);
			cstmt.setString(16, phoneno);
			System.out.println("phoneno :" + phoneno);

			int i = cstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			System.out.println(flag);
		} catch (SQLException e) {
			con.close();
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean postSuggesstion(ProfileTO pf) throws ConnectionException {
		boolean flag = false;
		String citizenname = pf.getCitizenname();
		String email = pf.getEmail();
		String suggesstion = pf.getSuggesstions();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._POST_SUGGESSITION);
			pstmt.setString(1, citizenname);
			pstmt.setString(2, email);
			pstmt.setString(3, suggesstion);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;

		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean postResume(ProfileTO pf) throws ConnectionException {
		boolean flag = false;

		String email = pf.getEmail();
		String resumepath = pf.getResumepath();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._POST_RESUME);
			pstmt.setString(1, email);
			File f = new File(resumepath);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			pstmt.setBinaryStream(2, fis, (int) f.length());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;

		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<ProfileTO> viewAgencyChief() throws ConnectionException {
		Vector<ProfileTO> vprofile = new Vector<ProfileTO>();
		ProfileTO profile = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENCY_CHIEF);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				profile = new ProfileTO();
				profile.setUserid(rs.getInt(1));
				profile.setLoginid(rs.getString(2));
				vprofile.add(profile);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return vprofile;
	}

	public Vector<ProfileTO> viewAgencyChiefs() throws FileNotFoundException,
			ConnectionException {
		Vector<ProfileTO> vprofile = new Vector<ProfileTO>();
		ProfileTO profile = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_AGENCY_CHIEF);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				profile = new ProfileTO();
				profile.setUserid(rs.getInt(1));
				profile.setLoginid(rs.getString(2));
				vprofile.add(profile);
			}
		} catch (SQLException e) {
			throw new ConnectionException("please change Agent Name");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return vprofile;
	}

	public Vector<ProfileTO> viewListOfUsers(String usertype, String realpath,
			int userid) throws FileNotFoundException, ConnectionException {

		Vector<ProfileTO> vprofile = new Vector<ProfileTO>();
		ProfileTO profile = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			System.out.println(usertype);if(!usertype.equalsIgnoreCase("AgentChief")){
			 pstmt=con.prepareStatement("select agentid from agent where agencychiefid=?");
			pstmt.setInt(1, userid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				pstmt1=con.prepareStatement(" select u.userid,u.firstname,u.lastname,u.dor,a.houseno,a.street,a.city,a.district,a.state,a.country,a.pincode,a.phoneno,u.photograph from userdetails u,logindetails l,addresses a where l.useridref=a.useridref and a.useridref=u.userid and u.userid=l.useridref and l.logintype=? and u.status='Active' and u.userid=?");
				pstmt1.setString(1, usertype);
				pstmt1.setInt(2, rs.getInt(1));
				ResultSet rs1=pstmt1.executeQuery();
				while (rs1.next()) {
					String path = "";
					profile = new ProfileTO();
					profile.setUserid(rs1.getInt(1));
					profile.setFirstName(rs1.getString(2));
					profile.setLastName(rs1.getString(3));
					profile.setDate(DateWrapper.parseDate(rs1.getDate(4)));
					profile.setHouseNo(rs1.getString(5));
					profile.setStreet(rs1.getString(6));
					profile.setCity(rs1.getString(7));
					profile.setDistrict(rs1.getString(8));
					profile.setState(rs1.getString(9));
					profile.setCountry(rs1.getString(10));
					profile.setPin(rs1.getString(11));
					profile.setPhoneNo(rs1.getString(12));
					Blob b = rs1.getBlob(13);
					byte b1[] = b.getBytes(1, (int) b.length());
					path = realpath + "/" + rs1.getInt(1) + ".jpg";
					System.out.println("path  :" + path);
					OutputStream fout = new FileOutputStream(path);
					fout.write(b1);
					profile.setPhoto(path);
					vprofile.add(profile);
				}
			}
			
			}else{pstmt = con.prepareStatement(SqlConstants._VIEW_LIST_USERS);
			pstmt.setString(1, usertype);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String path = "";
				profile = new ProfileTO();
				profile.setUserid(rs.getInt(1));
				profile.setFirstName(rs.getString(2));
				profile.setLastName(rs.getString(3));
				profile.setDate(DateWrapper.parseDate(rs.getDate(4)));
				profile.setHouseNo(rs.getString(5));
				profile.setStreet(rs.getString(6));
				profile.setCity(rs.getString(7));
				profile.setDistrict(rs.getString(8));
				profile.setState(rs.getString(9));
				profile.setCountry(rs.getString(10));
				profile.setPin(rs.getString(11));
				profile.setPhoneNo(rs.getString(12));
				Blob b = rs.getBlob(13);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = realpath + "/" + rs.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				profile.setPhoto(path);
				vprofile.add(profile);
			}}
					
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return vprofile;
	}

	public boolean deleteUser(int userid) throws ConnectionException {

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DELETE_USER);
			pstmt.setInt(1, userid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean deleteResume(int userid) throws ConnectionException {

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DELETE_RESUME);
			pstmt.setInt(1, userid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occurred please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<ProfileTO> viewResumes(String realpath)
			throws ConnectionException {
		Vector<ProfileTO> vcmp = new Vector<ProfileTO>();
		ProfileTO cmp = null;
		String path = "";
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_RESUME);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cmp = new ProfileTO();
				path = realpath;
				Blob b = rs.getBlob(3);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = path + "/" + rs.getInt(1) + ".doc";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				cmp.setResumepid(rs.getInt(1));
				cmp.setEmail(rs.getString(2));
				cmp.setResumepath(path);
				vcmp.add(cmp);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
		} finally {
			try {
				con.close();
			} catch (SQLException se) {
			}
		}
		return vcmp;

	}
}
