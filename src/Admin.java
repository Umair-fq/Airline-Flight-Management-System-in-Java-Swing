public class Admin extends User
{
	private String gender;
	
	public Admin(String username, String password, String gender)
	{
		super(username,password);
		this.gender=gender;
	}
	
	public String getGender()
	{
		return gender;
	}
}
