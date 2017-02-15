
public class RoomData 
{
	private String RoomType; 
	private String BedType;
	private int RoomNumber;
	private int RoomPrice;
	
	public void setRoomType(String RoomType)
	{
		this.RoomType = RoomType;
	}
	public String getRoomType(){return this.RoomType;}
	
	public void setBedType(String BedType)
	{
		this.BedType = BedType;
	}
	public String getBedType(){return this.BedType;}
	
	public void setRoomNumber(int RoomNumber)
	{
		this.RoomNumber = RoomNumber;
	}
	public int getRoomNumber(){return this.RoomNumber;}
	
	public void setRoomPrice(int RoomPrice)
	{
		this.RoomPrice = RoomPrice;
	}
	public int getRoomPrice(){return this.RoomPrice;}
}
