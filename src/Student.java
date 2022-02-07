import java.util.Scanner;

public class Student 
{
	private int sno;
	private String sname;	
	private int sphone;
	private String sAddress;
	Scanner sc = new Scanner(System.in);
	
	public void readSno()
	{
		System.out.print("Enter student roll no : ");  
		sno = sc.nextInt();
	}
	public void readSname()
	{
		System.out.print("Enter student name : ");  
		sname = sc.next();
	}
	public void readSphone()
	{
		System.out.print("Enter student Phone no : ");  
		sphone = sc.nextInt();
	}
	public void readSAddress()
	{
		System.out.print("Enter student Address : ");  
		sAddress = sc.next();
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSphone() {
		return sphone;
	}
	public void setSphone(int sphone) {
		this.sphone = sphone;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	
	
	
}