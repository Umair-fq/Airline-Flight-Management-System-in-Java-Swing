import java.util.ArrayList;
public class Flights
{
	private String flightId,departureAirport,departureTime;
	private String landingTime,landingAirport;
	private int seatsEconomy,seatsBusiness;
	
	//Constructor
	
	public Flights(String flightId, String departureAirport, String landingAirport, 
			String departureTime, String landingTime, int seatsEconomy, int seatsBusiness)
	{
		this.flightId=flightId;
		this.departureAirport=departureAirport;
		this.landingAirport=landingAirport;
		this.departureTime=departureTime;
		this.landingTime=landingTime;
		this.seatsEconomy=seatsEconomy;
		this.seatsBusiness=seatsBusiness;
	}
	
	//Getters
	
	public String getFlightId()
	{
		return flightId;
	}
	public String getDepartureAirport()
	{
		return departureAirport;
	}
	public String getLandingAirport()
	{
		return landingAirport;
	}
	public String getDepartureTime()
	{
		return departureTime;
	}
	public String getLandingTime()
	{
		return landingTime;
	}
	public int getSeatsEconomy()
	{
		return seatsEconomy;
	}
	public int getSeatsBusiness()
	{
		return seatsBusiness;
	}
	
	//Setters
	public void setFlightId(String flightId)
	{
		 this.flightId=flightId;
	}
	public void setDepartureAirport(String departureAirport)
	{
		 this.departureAirport=departureAirport;
	}
	public void setLandingAirport(String landingAirport)
	{
		 this.landingAirport=landingAirport;
	}
	public void setDepartureTime(String departureTime)
	{
		 this.departureTime=departureTime;
	}
	public void setLandingTime(String landingTime)
	{
		 this.landingTime=landingTime;
	}
	public void setSeatsEconomy(int seatsEconomy)
	{
		 this.seatsEconomy=seatsEconomy;
	}
	public void setSeatsBusiness(int seatsBusiness)
	{
		 this.seatsBusiness=seatsBusiness;
	}	
}










