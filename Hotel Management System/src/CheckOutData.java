
public class CheckOutData 
{
	
	private int CoustomarID;
	private int RoomNumber;
	private String CheckInDate;
	private String CheckOutDate;
	private int TotalRoomBill;
	private int RoomBillDue;
	private int FoodBillDue;
	private int TotalBillPayed;
	
	public void setCoustomarID(int CoustomarID)
	{
		this.CoustomarID = CoustomarID;
	}
	public int getCoustomarID(){return this.CoustomarID;}
	
	public void setRoomNumber(int RoomNumber)
	{
		this.RoomNumber = RoomNumber;
	}
	public int getRoomNumber(){return this.RoomNumber;}
	
	public void setTotalRoomBill(int TotalRoomBill)
	{
		this.TotalRoomBill = TotalRoomBill;
	}
	public int getTotalRoomBill(){return this.TotalRoomBill;}
	
	public void setRoomBillDue(int RoomBillDue)
	{
		this.RoomBillDue = RoomBillDue;
	}
	public int getRoomBillDue(){return this.RoomBillDue;}
	
	public void setFoodBillDue(int FoodBillDue)
	{
		this.FoodBillDue = FoodBillDue;
	}
	public int getFoodBillDue(){return this.FoodBillDue;}
	
	public void setTotalBillPayed(int TotalBillPayed)
	{
		this.TotalBillPayed = TotalBillPayed;
	}
	public int getTotalBillPayed(){return this.TotalBillPayed;}
	
	public void setCheckInDate(String CheckInDate)
	{
		this.CheckInDate = CheckInDate;
	}
	public String getCheckInDate(){return this.CheckInDate;}
	
	public void setCheckOutDate(String CheckOutDate)
	{
		this.CheckOutDate = CheckOutDate;
	}
	public String getCheckOutDate(){return this.CheckOutDate;}
	
}
