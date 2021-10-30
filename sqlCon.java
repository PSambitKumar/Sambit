import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class sqlCon {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
        System.out.println("Connection Established!!");

        //Create Table
//        Statement st = con.createStatement();
//        String sql = "CREATE TABLE REGISTRATION (id INTEGER(10) ,first VARCHAR(255), last VARCHAR(255),age INTEGER(2))";
//        st.executeUpdate(sql);
//        System.out.println("Table Created!!");

        //Drop Table
//        String sql2= "DROP TABLE REGISTRATION";
//        st.executeUpdate(sql2);
//        System.out.println("Table Dropped!!");

        //Print all data from table
//        Statement st1 = con.createStatement();
//        String sql3 = "SELECT * FROM Employee";
//        ResultSet rs = st1.executeQuery(sql3);
//        while (rs.next()){
//            System.out.println(rs.getString(1)+" "+
//                    rs.getString(2)+" "+
//                    rs.getString(3)+" "+
//                    rs.getInt(4));
//        }
//        System.out.println("--------------------------------------"+"\n"+"Data Printed!!");

//        Insert data into table
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Employee ID:");
//        String empid = sc.next();
//        System.out.println("Enter Employee NAME:");
//        String empname = "";
//        empname += sc.nextLine();
//        System.out.println("Enter Employee ADDRESS:");
//        String empadd = sc.nextLine();
//        System.out.println("Enter Employee SALARY:");
//        int empsal = sc.nextInt();
//        String sql4 = "INSERT INTO Employee VALUES(?,?,?,?)";
//        PreparedStatement ps = con.prepareStatement(sql4);
//        ps.setString(1,empid);
//        ps.setString(2,empname);
//        ps.setString(3,empadd);
//        ps.setInt(4,empsal);
//        int rowInserted = ps.executeUpdate();
//        if(rowInserted > 0){
//            System.out.println("Row Inserted Successfully!!");
//        }

//        Delete Specific data from table
//        Scanner sc1 = new Scanner(System.in);
//        System.out.println("Enter EmpID:");
//        String empid1 = sc1.next();
//        String sql5 = "DELETE FROM Employee WHERE EmpID=?";
//        PreparedStatement ps1 = con.prepareStatement(sql5);
//        ps1.setString(1,empid1);
//        int rowDeleted = ps1.executeUpdate();
//        if(rowDeleted > 0){
//            System.out.println("Row Deleted!!");
//        }
    con.close();
        System.out.println("Connection Closed!!");
    }
}