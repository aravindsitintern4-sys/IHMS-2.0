package locators;

import org.openqa.selenium.By;

public class roomstatusLocator {
 
	 public static By ROOM_STATUS = By.xpath("//button[.//span[normalize-space()='Current Room Status']]");
	 
//patient type
	 public static By patientTypeDropdown = By.xpath("//select[@formcontrolname='PatientClass']");

//room no
	 public static By roomNoInput = By.xpath("//input[@formcontrolname='RoomNo']");
	 
//room type
	 public static By roomTypeDropdown = By.xpath("//select[@formcontrolname='RoomTypeDetailMasterId']");
	    
//OCCUPANCY FLAG	 
	 public static By occupancyFlagDropdown = By.xpath("//select[@formcontrolname='OccupyFlagCode']");

//floor
	 public static By floorDropdown = By.xpath("//select[@formcontrolname='FloorMasterId']");
		 
//toilet type
	 public static By toiletTypeDropdown = By.xpath("//select[@formcontrolname='ToiletTypeMasterId']");

//LOCATION
	 public static By locationDropdown = By.xpath("//select[@formcontrolname='DepartmentId']");
	 
//Save
//	 public static By saveButton = By.xpath("//button[normalize-space()='Save']");

//clear
//	 public static By clearButton = By.xpath("//button[normalize-space()='Clear']");
	 
// SEARCH ROOM NUMBER	 
	 public static By searchRoomInput = By.xpath("//input[@placeholder='Search by Room No']"); 
	 
//Table
	 public static By Tablerow = By.xpath("//table//tr");
	 

}
