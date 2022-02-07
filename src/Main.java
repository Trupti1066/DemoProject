import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
	
	public static void main(String[] args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		clsDB db = new clsDB();
		
		int ch=0;
		Student stud = new Student();
		
		while(ch!=5)
		{		
			System.out.println("\n");
			System.out.println("****Student Management System ******");
			System.out.println("1. Add student details");
			System.out.println("2. Update student details");
			System.out.println("3. Delete student details");
			System.out.println("4. Display all the student details");
			
			System.out.println("5. Exit");

			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
			System.out.println("\n");
			
			if(ch == 1)
			{
				System.out.println("Adding student details");
				System.out.print("Enter student roll no : ");  
					stud.setSno(sc.nextInt());
				System.out.print("Enter student name : ");
					stud.setSname(sc.next());
				System.out.print("Enter student phone no : ");  
					stud.setSphone(sc.nextInt());
				System.out.print("Enter student address : ");
					stud.setsAddress(sc.next());
					
				db.myExecuteQry("insert into stud (sno,sname,sphone,sAddress) values ("+stud.getSno()+",'"+stud.getSname()+"','"+stud.getSphone()+"','"+stud.getsAddress()+"')");
				System.out.println("Record added successfully...");				
			}
			else if(ch == 2)
			{
				System.out.println("Updating student details");
				System.out.print("Enter student roll no to be updated : ");
				stud.setSno(sc.nextInt());
				System.out.print("Enter new name for student : ");
				stud.setSname(sc.next());
				System.out.print("Enter new phone no of Student : ");
				stud.setSphone(sc.nextInt());
				System.out.print("Enter new address for student : ");
				stud.setsAddress(sc.next());
				db.myExecuteQry("update stud set sname = '"+stud.getSname()+"',sphone = '"+stud.getSphone()+"',sAddress = '"+stud.getsAddress()+"' where sno = "+stud.getSno()+"");
				System.out.println("Record updated successfully...");				
			}
			else if(ch == 3)
			{
				System.out.println("Deleting student details");
				System.out.print("Enter stud no to be deleted : ");
				stud.setSno(sc.nextInt());				
				db.myExecuteQry("delete from stud where sno = "+stud.getSno()+"");
				System.out.println("Record deleted successfully...");				
			}
			else if(ch == 4)
			{
				System.out.println("Displaying student details");
				ResultSet r = db.getResultSet("Select * from stud");
				System.out.println("No.\t\t\tName\t\tPhone NO\t\tAddress");
				while(r.next())
				{
					System.out.print(r.getInt(1)+"\t\t\t"+r.getString(2)+"\t\t"+r.getInt(3)+"\t\t\t"+r.getString(4)+"\n");
				}
			}
			else if(ch==5)
			{
				System.exit(0);
			}			
		}		
	}
}
