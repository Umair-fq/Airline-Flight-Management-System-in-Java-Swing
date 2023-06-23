public class BookingObject 
{
	private String departureAirport,departureTime;
	private String landingAirport,landingTime;
	private String flightId,date;
	private int seatsEconomy,seatsBusiness;
	
	public BookingObject(String flightId,String departureAirport,String departureTime, String landingAirport,
			String landingTime,int seatsEconomy, int seatsBusiness)
	   {
		this.departureAirport=departureAirport;
		this.departureTime=departureTime;
		this.flightId=flightId;
		this.landingAirport=landingAirport;
		this.landingTime=landingTime;
		date="28-12-21";
		this.seatsEconomy=seatsEconomy;
		this.seatsBusiness=seatsBusiness;
	   }
	
	
	public String getDepartureAirport()
	{
		return departureAirport;
	}
	public String getDepartureTime()
	{
		return departureTime;
	}
	public String getFlightId()
	{
		return flightId;
	}
	public String getLandingAirport()
	{
		return landingAirport;
	}
	public String getLandingTime()
	{
		return landingTime;
	}
	public String getDate()
	{
		return date;
	}
	
	public int getSeatsEconomy()
	{
		return seatsEconomy;
	}
	public int getSeatsBusiness()
	{
		return seatsBusiness;
	}
	
	
}
