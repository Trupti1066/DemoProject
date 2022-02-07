import java.sql.*;

// Developed by Ravi R. Oza
// Jamnagar, Gujarat
// raviroza.wordpress.com
public class clsDB {
	Connection cn;
	Statement st;
	String url = "jdbc:mysql://localhost:3306/test", username = "root", password = "";

	public clsDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, username, password);
		} catch (Exception err) {
			System.out.println("Error : " + err);
		}
	}

	public void myExecuteQry(String s) {
		try {
			st = cn.createStatement();
			st.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet(String s) {
		ResultSet r;
		try {
			st = cn.createStatement();
			r = st.executeQuery(s);
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addStudent(Student stud) {
		String q = "insert into stud (sno,sname) values (" + stud.getSno() + ",'" + stud.getSname() + "''" + stud.getSphone() + "''" + stud.getsAddress() + "')";
		myExecuteQry(q);
	}

	public void updateStudent(Student stud) {
		String q = "update stud set sname = '" + stud.getSname() + "',sphone = '" + stud.getSphone() + "',sAddress = '" + stud.getsAddress() + "' where sno = " + stud.getSno() + "";
		myExecuteQry(q);
	}

	public void deleteStudent(Student stud) {
		String q = "delete from stud where sno = " + stud.getSno() + "";
		myExecuteQry(q);
	}

	public void displayStudent() throws SQLException {
		ResultSet r = getResultSet("Select * from stud");
		System.out.println("No.\t\t\tName\t\tPhone NO\t\tAddress");
		while (r.next()) {
			System.out.print(r.getInt(1)+"\t\t\t"+r.getString(2)+"\t\t\t"+r.getInt(3)+"\t\t\t"+r.getString(4)+"\n");
		}
	}
}