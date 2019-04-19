import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of user object
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class User 
{
	private String name;
	private String userName;
	private String role;
	private String email;
	private String gender;
	private String password;
	private ArrayList<String> roleList;

	public User()
	{
		name = "";
		userName = "";
		role = "";
		email = "";
		gender = "";
		password ="";
		roleList = new ArrayList<String>(Arrays.asList("Job Seeker","Job Recruiter"));
	}
	
	public User(String nam, String user, String mail, String gender, String pass)
	{
		this.name = nam;
		this.userName = user;
		this.role = "";
		this.email = mail;
		this.gender = gender;
		this.password = pass;
		
	}

	/**
	 * user name getter
	 * 
	 * @return user name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * user name setter
	 * 
	 * @param name user name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * username getter
	 * 
	 * @return username
	 */
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * username setter
	 * 
	 * @param userName username
	 */
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	/**
	 * user role getter
	 * 
	 * @return user role
	 */
	public String getRole() 
	{
		return role;
	}

	/**
	 * user role setter
	 * 
	 * @param role user role
	 */
	public void setRole(String role) 
	{
		this.role = role;
	}

	/**
	 * user email address getter
	 * 
	 * @return email address
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * user email address setter
	 * 
	 * @param email user email address
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	/**
	 * user gender getter
	 * 
	 * @return user gender
	 */
	public String getGender() 
	{
		return gender;
	}

	/**
	 * user gender setter
	 * 
	 * @param gender user gender
	 */
	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	/**
	 * password getter
	 * 
	 * @return password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * password setter
	 * 
	 * @param password password
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/**
	 * get role list
	 * 
	 * @return list of roles
	 */
	public ArrayList<String> getRoleList() 
	{
		return roleList;
	}

	/**
	 * set role list
	 * 
	 * @param roleList list of roles
	 */
	public void setRoleList(ArrayList<String> roleList) 
	{
		this.roleList = roleList;
	}
	
	/**
	 * Display list of roles
	 */
	public void displayRoleList()
	{
		System.out.println("Available roles in OJSS are : ");
		
		for (String role : roleList)
		{
			System.out.println(role);
		}
		
	}

}
