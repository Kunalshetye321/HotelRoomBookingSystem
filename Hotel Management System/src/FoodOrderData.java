
public class FoodOrderData
{
	private int CustomarID;
	private String FoodType;
	private String FoodName;
	private int FoodPrice;
	private int FoodQuantity;
	private int TotalAmount;
	
	public void setCustomarId(int CustomarID)
	{
		this.CustomarID = CustomarID;
	}
	public int getCustomarId(){return this.CustomarID;}
	
	public void setFoodPrice(int FoodPrice)
	{
		this.FoodPrice = FoodPrice;
	}
	public int getFoodPrice(){return this.FoodPrice;}
	
	public void setFoodQuantity(int FoodQuantity)
	{
		this.FoodQuantity = FoodQuantity;
	}
	public int getFoodQuantity(){return this.FoodQuantity;}
	
	public void setTotalAmount(int TotalAmount)
	{
		this.TotalAmount = TotalAmount;
	}
	public int getTotalAmount(){return this.TotalAmount;}
	
	public void setFoodType(String FoodType)
	{
		this.FoodType = FoodType;
	}
	public String getFoodType(){return this.FoodType;}
	
	public void setFoodName(String FoodName)
	{
		this.FoodName = FoodName;
	}
	public String getFoodName(){return this.FoodName;}
	
	
}
