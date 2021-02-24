
public class Firm {

	public static void main(String[] args) {

		Staff staff = new Staff(); 
		staff.payday();
		
	}

}

 // ******************** Staff Class ********************-

class Staff 
{ 
	StaffMember[] staffList; 


	public Staff () {
	 
		staffList = new StaffMember[8]; 
		staffList[0] = new Volunteer ("Johnson Melin", "4 Mango Street", 
				"0266332211"); 
		staffList[1] = new Employee ("Melissa Whit", "18 Coconut Avenue", 
				"027754863", "123-78-2015", 1387.50); 
		staffList[2] = new Executive ("Elvic Froston", "26 Rice Avenue", 
				"0547212121", "841-33-2016", 3542.95); 
		staffList[3] = new Volunteer ("Bruce Gardin", "A1 Yam Close", 
				"0248521369"); 
		staffList[4] = new Hourly ("Softlove Shing", "101 Garbage Road", 
				"0590000777", "044-99-2017", 262) ; 
		staffList[5] = new Hourly ("Lady Prin Soothburg", "BC12 Xylophone Street", 
				"0280010070", "159-87-2018", 100.39); 
		staffList[6] = new Commission ("Marina Golden-Brown", "37 Love Street", 
				"0552101814", "005-20-2019", 6.25, 0.2);
		staffList[7] = new Commission("Poly Caristen", "8 Marvel Close",
				"0201444555", "111-22-2020", 9.75, 0.15);

		((Executive) staffList[2]).awardBonus (350.00); 
		((Hourly) staffList[4]).addHours (15); 
		((Hourly) staffList[5]).addHours (35);

		((Commission) staffList[6]).addHours(35);
		((Commission) staffList[6]).addSales(400);
		((Commission) staffList[7]).addHours(40);
		((Commission) staffList[7]).addSales(950);

	} 

	public void payday () {
	
		double paid; 
		for (int i = 0; i < staffList.length; i ++) {
		
			System.out.println (staffList[i]); 
			paid = staffList[i].pay();  
			System.out.println ("Amount Paid : " + paid); 
			 
		} 
	} 
} 

   // ******************** StaffMember Class ********************

abstract class StaffMember {

	protected String name;
	protected String address;
	protected String phone;

	public StaffMember (String name, String address, String phone) {
	
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String toString() {
		return "Name : " + name + " , Address : " + address + " , Phone Number : " + phone;
	}
	
	public abstract double pay();
}


   // ******************** Volunteer Class ********************


class Volunteer extends StaffMember {

	public Volunteer (String name, String address, String phone) {
		super (name, address, phone);
	}
	
	public double pay() {
		return 0.0;
	}
}

    //******************** Employee Class ********************


class Employee extends StaffMember {

	protected String socialSecurityNumber;
	protected double payRate;


	public Employee (String name, String adddress, String phone, String socialSecurityNumber, double payRate) {
	
		super (name, adddress, phone);
		this.socialSecurityNumber = socialSecurityNumber;
		this.payRate = payRate;
	}
	
	public String toString(){
		return super.toString() + ", Social Security Number : " + socialSecurityNumber + " , Pay Rate : " +payRate;
		}
	
	public double pay() {
		return payRate;
	}
}

    //******************** Executive Class ********************

class Executive extends Employee {

	private double bonus;

	public Executive (String name, String address, String phone, String socialSecurityNumber, double payRate) {
	
		super (name, address, phone, socialSecurityNumber, payRate);
		bonus = 0;  
	}
	
	public void awardBonus (double bonus) {
		this.bonus = bonus;
	}
	
	public double pay() {
		return super.pay() + bonus;
	}
}

     //******************** Hourly Class ********************


class Hourly extends Employee {

	private int hoursWorked;

	public Hourly (String name, String address, String phone, String socialSecurityNumber, double payRate) {

		super (name, address, phone, socialSecurityNumber, payRate);
		hoursWorked = 0;
	}
	
	public void addHours (int moreHours) {
		hoursWorked = hoursWorked + moreHours;
	}
	
	public double pay() {
		return super.pay() * hoursWorked;	
	}
	
	public String toString(){
		return super.toString() + " , Hours Worked : " + hoursWorked;
		}
}

	//******************** Commission Class ********************


class Commission extends Hourly {
	double totalSales;
	double commissionRate;

	public Commission(String name, String address, String phone,String socialSecurityNumber, double payRate, double commissionRate) {

		super(name, address, phone, socialSecurityNumber, payRate);
		this.commissionRate = commissionRate;
		totalSales = 0;
	}
	
	public void addSales(double totalSales) {
		this.totalSales += totalSales;
	}
	
	public double pay() {
		return super.pay() + (commissionRate * totalSales );
	}

	public String toString(){
		return super.toString() + " , Total Sales : " + totalSales;
		}
}














