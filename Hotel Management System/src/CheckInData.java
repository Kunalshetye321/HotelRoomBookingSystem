
public class CheckInData 
{
	private int CustomarId; 
	private int RoomNumber;
	private String CheckInDate;
	private String CheckOutData;
	private int Amount;
	private int Payed;
	private int Due;
	
	public void setCustomarId(int CustomarId)
	{
		this.CustomarId = CustomarId;
	}
	public int getCustomarId(){return this.CustomarId;}
	
	public void setRoomNumber(int RoomNumber)
	{
		this.RoomNumber = RoomNumber;
	}
	public int getRoomNumber(){return this.RoomNumber;}
	
	public void setAmount(int Amount)
	{
		this.Amount = Amount;
	}
	public int getAmount(){return this.Amount;}
	
	public void setPayed(int Payed)
	{
		this.Payed = Payed;
	}
	public int getPayed(){return this.Payed;}
	
	public void setDue(int Due)
	{
		this.Due = Due;
	}
	public int getDue(){return this.Due;}
	
	public void setCheckInDate(String CheckInDate)
	{
		this.CheckInDate = CheckInDate;
	}
	public String getCheckInDate(){return this.CheckInDate;}
	
	public void setCheckOutData(String CheckOutData)
	{
		this.CheckOutData = CheckOutData;
	}
	public String getCheckOutData(){return this.CheckOutData;}
}
