public class Passenger extends User 
{
	private String email;
	private String cnic;
	
	public Passenger(String username, String email, String cnic, String password)
	{
		super (username,password);
		this.email=email;
		this.cnic=cnic;
	}
	public String getEmail()
	{
		return email;
	}
	public String getCnic()
	{
		return cnic;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
}
