import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess 
{
	private Connection con;
	private Statement stm;
	private int id;
	
	public int getID(){return this.id;}
	
	public DataAccess()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String conStr = "jdbc:mysql://localhost:3306/nahiyanhotel";
			this.con = DriverManager.getConnection(conStr, "root", "");
			this.stm = this.con.createStatement();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

	
	public String[] getCustomarID()
	{
		String sql ="SELECT id FROM customarinfo";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			String[] idlist =  new String[count];
			
			for(int i = 0; i < count; i++)
			{
				rs.next();
				idlist[i] = rs.getString("id");
			}
			
			return idlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public String[] getCustomarinfo(int id)
	{
		String sql ="SELECT * FROM `customarinfo` WHERE id='"+id+"'";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			String[] list = new String[11];
			int i=0;
			while(rs.next())
			{
				list[0] = rs.getString(2);
				list[1] = rs.getString(3);
				list[2] = rs.getString(4);
				list[3] = rs.getString(5);
				list[4] = rs.getString(6);
				list[5] = rs.getString(7);
				list[6] = rs.getString(8);
				list[7] = rs.getString(9);
				list[8] = rs.getString(10);
				list[9] = rs.getString(11);
				list[10] = rs.getString(12);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isUserValid(String username, String password)
	{
		String sql = "SELECT * FROM adminlogin WHERE username='"+username+"' AND password='"+password+"'";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			return rs.next();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean InsertCustomar(CustomarData customarData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`customarinfo` (`id`, `first_name`, `last_name`, `gender`, `marrage_status`, `address`, `mobile_number`, `email`, `national_id`, `passport_no`, `number_of_adults`, `number_of_children`)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setInt(1, customarData.getCustomarID());
			stmt.setString(2, customarData.getFirstName());
			stmt.setString(3, customarData.getLastName());
			stmt.setString(4, customarData.getGender());
			stmt.setString(5, customarData.getMaritorialStatus());
			stmt.setString(6, customarData.getAddress());
			stmt.setInt(7, customarData.getMobileNumber());
			stmt.setString(8, customarData.getEmail());
			stmt.setString(9, customarData.getNationalID());
			stmt.setString(10, customarData.getPassportNumber());
			stmt.setInt(11, customarData.getNumberOfAdults());
			stmt.setInt(12, customarData.getNumberOfChildrens());
			
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public boolean UpdateCustomar(CustomarData customarData)
	{
		String sql="UPDATE `customarinfo` SET first_name = '"+customarData.getFirstName()+"',"
											+ "last_name = '"+customarData.getLastName()+"',"
											+ "gender = '"+customarData.getGender()+"',"
											+ "marrage_status = '"+customarData.getMaritorialStatus()+"',"
											+ "address = '"+customarData.getAddress()+"',"
											+ "mobile_number = '"+customarData.getMobileNumber()+"',"
											+ "email = '"+customarData.getEmail()+"',"
											+ "national_id = '"+customarData.getNationalID()+"',"
											+ "passport_no = '"+customarData.getPassportNumber()+"',"
											+ "number_of_adults = '"+customarData.getNumberOfAdults()+"',"
											+ "number_of_children = '"+customarData.getNumberOfChildrens()+"'"
											+ "WHERE customarinfo.id ='"+customarData.getCustomarID()+"'";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	//=============================> ROOM <=====================================
	public boolean InsertRoom(RoomData roomData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`roominfo` (`id`, `room_type`, `bed_type`, `room_number`, `room_price`)"
				+ "VALUES (NULL,?,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, roomData.getRoomType());
			stmt.setString(2, roomData.getBedType());
			stmt.setInt(3, roomData.getRoomNumber());
			stmt.setInt(4, roomData.getRoomPrice());
			
			stmt.execute();
		    stmt.close();
		    return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public String[] getRoomNumber()
	{
		String sql ="SELECT room_number FROM roominfo";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			String[] idlist =  new String[count];
			
			for(int i = 0; i < count; i++)
			{
				rs.next();
				idlist[i] = rs.getString("room_number");
			}
			
			return idlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public Vector<Vector<String>> getAllRoomInfo()
	{
		String sql = "SELECT room_type,bed_type,room_number,room_price FROM `roominfo` ";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			Vector<Vector<String>> emplist = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> emp = new Vector<String>();
				emp.add(rs.getString("room_type"));
				emp.add(rs.getString("bed_type"));
				emp.add(rs.getString("room_number"));
				emp.add(rs.getString("room_price"));
				emplist.add(emp);
			}
			return emplist;
		}
		catch(Exception ex){
			ex.printStackTrace(); 
			return null;
			}
	}
	
	public String[] getRoominfo(int number)
	{
		String sql ="SELECT room_type,bed_type,room_price FROM `roominfo` WHERE room_number='"+number+"'";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			String[] list = new String[3];
			int i=0;
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
				list[2] = rs.getString(3);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

//=============================> CHECK IN <<==============================
	public boolean InsertCheckIn(CheckInData checkInData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`checkin` (`customar_id`, `room_number`, `checkin_date`, `checkout_date`, `amount`, `payed`, `due`)"
				+ "VALUES (?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setInt(1, checkInData.getCustomarId());
			stmt.setInt(2, checkInData.getRoomNumber());
			stmt.setString(3, checkInData.getCheckInDate());
			stmt.setString(4, checkInData.getCheckOutData());
			stmt.setInt(5, checkInData.getAmount());
			stmt.setInt(6, checkInData.getPayed());
			stmt.setInt(7, checkInData.getDue());
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public Vector<Vector<String>> getAllMemberInfo()
	{
		String sql = "SELECT customarinfo.first_name,customarinfo.last_name,customarinfo.gender,customarinfo.marrage_status,"+
"customarinfo.address,customarinfo.mobile_number,customarinfo.email,customarinfo.national_id,"+
"customarinfo.passport_no,customarinfo.number_of_adults,customarinfo.number_of_children,checkin.room_number,"+
"checkin.checkin_date,checkin.checkout_date FROM checkin INNER JOIN customarinfo ON customarinfo.id = checkin.customar_id";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			Vector<Vector<String>> emplist = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> emp = new Vector<String>();
				emp.add(rs.getString("first_name"));
				emp.add(rs.getString("last_name"));
				emp.add(rs.getString("gender"));
				emp.add(rs.getString("marrage_status"));
				emp.add(rs.getString("address"));
				emp.add(rs.getString("mobile_number"));
				emp.add(rs.getString("email"));
				emp.add(rs.getString("national_id"));
				emp.add(rs.getString("passport_no"));
				emp.add(rs.getString("number_of_adults"));
				emp.add(rs.getString("number_of_children"));
				emp.add(rs.getString("room_number"));
				emp.add(rs.getString("checkin_date"));
				emp.add(rs.getString("checkout_date"));
				emplist.add(emp);
			}
			return emplist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); 
			return null;
		}
	}
	
	public boolean UpdateCheckIn(CheckInData checkInData)
	{
		String sql="UPDATE `checkin` SET room_number = '"+checkInData.getRoomNumber()+"',"
											+ "checkin_date = '"+checkInData.getCheckInDate()+"',"
											+ "checkout_date = '"+checkInData.getCheckOutData()+"',"
											+ "amount = '"+checkInData.getAmount()+"',"
											+ "payed = '"+checkInData.getPayed()+"',"
											+ "due = '"+checkInData.getDue()+"'"
											+ "WHERE customar_id ='"+checkInData.getCustomarId()+"'";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public String[] getCheckIninfo(int id)
	{
		String sql ="SELECT * FROM `checkin` WHERE customar_id = '"+id+"'" ;
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			String[] list = new String[6];
			while(rs.next())
			{
				list[0] = rs.getString(2);
				list[1] = rs.getString(3);
				list[2] = rs.getString(4);
				list[3] = rs.getString(5);
				list[4] = rs.getString(6);
				list[5] = rs.getString(7);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public boolean DELETECheckInInfo(int id)
	{
		String sql="DELETE FROM checkin WHERE customar_id = '"+id+"'";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
//============================> FOOD <====================================
	
	public boolean InsertFood(FoodData foodData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`foodinfo` (`id`, `name`, `type`, `price`)"
				+ "VALUES (NULL,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, foodData.getFoodName());
			stmt.setString(2, foodData.getFoodType());
			stmt.setInt(3, foodData.getFoodPrice());
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	public String[] getFoodId()
	{
		String sql ="SELECT id FROM foodinfo";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			String[] idlist =  new String[count];
			
			for(int i = 0; i < count; i++)
			{
				rs.next();
				idlist[i] = rs.getString("id");
			}
			
			return idlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public String[] getFoodType()
	{
		String sql ="SELECT type FROM foodinfo";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			String[] idlist =  new String[count];
			
			for(int i = 0; i < count; i++)
			{
				rs.next();
				idlist[i] = rs.getString("type");
			}
			
			return idlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	public String[] getFoodName(String type)
	{
		String sql ="SELECT name,price FROM foodinfo WHERE type = '"+type+"'";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			String[] name = new String[2];
			while(rs.next())
			{
				name[0] = rs.getString(1);
				name[1] = rs.getString(2);
			}
			return name;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	public boolean InsertFoodOrder(FoodOrderData foodOrderData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`foodorderinfo` (`customer_id`, `food_type`, `food_name`,`food_price`,`food_quantity`,`total_amount`)"
				+ "VALUES (?,?,?,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setInt(1, foodOrderData.getCustomarId());
			stmt.setString(2, foodOrderData.getFoodType());
			stmt.setString(3, foodOrderData.getFoodName());
			stmt.setInt(4, foodOrderData.getFoodPrice());
			stmt.setInt(5, foodOrderData.getFoodQuantity());
			stmt.setInt(6, foodOrderData.getTotalAmount());
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

//=============> CheckOut <====================
	
	public String[] getCustomerCheckOutinfo(int id)
	{
		String sql ="SELECT customarinfo.first_name, customarinfo.last_name,checkin.room_number,checkin.checkin_date," +"checkin.checkout_date,checkin.amount,checkin.due,foodorderinfo.total_amount,checkin.payed"+
				" FROM customarinfo INNER JOIN checkin ON customarinfo.id = checkin.customar_id"+
				" INNER JOIN foodorderinfo ON customarinfo.id = foodorderinfo.customer_id"+ 
				" WHERE customarinfo.id = '"+id+"'" ;
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			String[] list = new String[9];
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
				list[2] = rs.getString(3);
				list[3] = rs.getString(4);
				list[4] = rs.getString(5);
				list[5] = rs.getString(6);
				list[6] = rs.getString(7);
				list[7] = rs.getString(8);
				list[8] = rs.getString(9);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean InsertCheckOutInfo(CheckOutData checkOutData)
	{
		String sql="INSERT INTO `nahiyanhotel`.`checkoutinfo` (`customer_id`, `room_number`, `total_room_bill`,`room_bill_due`,`food_bill_due`,`total_bill_payed`,`checkin`,`checkout`)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setInt(1, checkOutData.getCoustomarID());
			stmt.setInt(2, checkOutData.getRoomNumber());
			stmt.setInt(3, checkOutData.getTotalRoomBill());
			stmt.setInt(4, checkOutData.getRoomBillDue());
			stmt.setInt(5, checkOutData.getFoodBillDue());
			stmt.setInt(6, checkOutData.getTotalBillPayed());
			stmt.setString(7, checkOutData.getCheckInDate());
			stmt.setString(8, checkOutData.getCheckOutDate());
			
			stmt.execute();
		    stmt.close();
		    return true;
		}	
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public Vector<Vector<String>> getCheckOutList()
	{
		String sql = "SELECT customarinfo.first_name, customarinfo.last_name,checkoutinfo.room_number,checkoutinfo.checkin,checkoutinfo.checkout,"
					+"checkoutinfo.total_room_bill,checkoutinfo.room_bill_due,checkoutinfo.food_bill_due,checkoutinfo.total_bill_payed"
					+" FROM checkoutinfo INNER JOIN customarinfo WHERE customarinfo.id = checkoutinfo.customer_id";
		try
		{
			ResultSet rs = this.stm.executeQuery(sql);
			Vector<Vector<String>> emplist = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> emp = new Vector<String>();
				emp.add(rs.getString("first_name"));
				emp.add(rs.getString("last_name"));
				emp.add(rs.getString("room_number"));
				emp.add(rs.getString("total_room_bill"));
				emp.add(rs.getString("room_bill_due"));
				emp.add(rs.getString("food_bill_due"));
				emp.add(rs.getString("total_bill_payed"));
				emp.add(rs.getString("checkin"));
				emp.add(rs.getString("checkout"));
				emplist.add(emp);
			}
			return emplist;
		}
		catch(Exception ex){
			ex.printStackTrace(); 
			return null;
			}
	}

}
