import java.sql.*;
import java.util.Scanner;


//Insert Data of Employee
class insert{
    void insertData() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your name:");
            String empname = "";
            empname += sc.nextLine();
            System.out.println("Enter your Address:");
            String empadd = sc.next();
            System.out.println("Enter your Age:");
            int empage = sc.nextInt();
            System.out.println("Enter Your DepartmentID:");
            int deptid = sc.nextInt();

            String sql1 = "INSERT INTO Employee(empname,empadd,empage,deptID) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1,empname);
            ps.setString(2,empadd);
            ps.setInt(3,empage);
            ps.setInt(4,deptid);
            int rowInserted = ps.executeUpdate();
            if(rowInserted > 0){
                System.out.println("Employee added to Database Successfully!!");
                System.out.println("------------------------------------------");

            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            System.out.println("Department not Present!!");
        }
    }
}


//Update Data of Employee
class update{
    void updateData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        String sql = "SELECT * FROM Employee WHERE empID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println("Employee Name: "+rs.getString(2)+"\n"+
                    "Employee Address: "+rs.getString(3)+"\n"+
                    "Employee Age: "+rs.getInt(4)+"\n"+
                    "Employee DeptID: "+rs.getInt(5));
        }
        System.out.println("Do you want to Update(Y/N)?");
        System.out.println("-----------------------------------");

        char ch = sc.next().charAt(0);
        if (ch == 'Y' || ch == 'y'){
            int c = 0;
            while(c != 5 ){
                System.out.println("Enter your choice to Update:\n1.Emp Name \n2.Emp Add\n3.Emp Age\n4.Emp Dept\n5.Exit");
                c = sc.nextInt();
                switch (c){
                    case 1:
                        System.out.println("Enter your name to change:");
                        String name1 = sc.nextLine();
                        name1 = sc.nextLine();
                        String sql1 = "UPDATE Employee SET empname=? WHERE empID=?";
                        PreparedStatement ps1 = con.prepareStatement(sql1);
                        ps1.setString(1,name1);
                        ps1.setInt(2,id);
                        int update1 = ps1.executeUpdate();
                        if(update1 > 0){System.out.println("Name Updated in Database.");
                            System.out.println("-----------------------------------");

                        }
                        break;
                    case 2:
                        System.out.println("Enter your Address to change::");
                        String add1 =  sc.next();
                        String sql2 = "UPDATE Employee SET empadd=? WHERE empID=?";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        ps2.setString(1,add1);
                        ps2.setInt(2,id);
                        int update2 = ps2.executeUpdate();
                        if(update2 > 0){
                            System.out.println("Address Updated in Database.");
                            System.out.println("-----------------------------------");

                        }
                        break;
                    case 3:
                        System.out.println("Enter your Age to change::");
                        String age1 =  sc.next();
                        String sql3 = "UPDATE Employee SET empage=? WHERE empID=?";
                        PreparedStatement ps3 = con.prepareStatement(sql3);
                        ps3.setString(1,age1);
                        ps3.setInt(2,id);
                        int update3 = ps3.executeUpdate();
                        if(update3 > 0){
                            System.out.println("Age Updated in Database.");
                            System.out.println("-----------------------------------");

                        }
                        break;
                    case 4:
                        System.out.println("Enter your Department ID to change::");
                        String dept1 =  sc.next();
                        String sql4 = "UPDATE Employee SET deptID=? WHERE empID=?";
                        PreparedStatement ps4 = con.prepareStatement(sql4);
                        ps4.setString(1,dept1);
                        ps4.setInt(2,id);
                        int update4 = ps4.executeUpdate();
                        if(update4 > 0){
                            System.out.println("Department ID Updated in Database.");
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Input!!");
                        System.out.println("-----------------------------------");

                        break;
                }
            }
        }
        con.close();
    }
}



//Delete data from Database
class delete{
    void deleteData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        String sql = "SELECT * FROM Employee WHERE empID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println("Employee Name: "+rs.getString(2)+"\n"+
                    "Employee Address: "+rs.getString(3)+"\n"+
                    "Employee Age: "+rs.getInt(4)+"\n"+
                    "Employee DeptID: "+rs.getInt(5));
        }

        System.out.println("Do you want to Delete?(Y/N)");
        System.out.println("-----------------------------------");

        char ch = sc.next().charAt(0);
        if (ch == 'Y' || ch == 'y'){
            int c = 0;
            while (c != 6){
                System.out.println("Enter your choice to Delete:\n1.Emp Name \n2.Emp Add\n3.Emp Age\n4.Emp Dept\n5.Entire Row\n6.Exit");
                c = sc.nextInt();
                switch (c){
                    case 1:
                        String sql1 = "UPDATE Employee SET empname = NULL WHERE empID=?";
                        PreparedStatement ps1 = con.prepareStatement(sql1);
                        ps1.setInt(1,id);
                        int update1 = ps1.executeUpdate();
                        if(update1 > 0){
                            System.out.println("Name Deleted from Database.");
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 2:
                        String sql2 = "UPDATE Employee SET empadd = NULL WHERE empID=?";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        ps2.setInt(1,id);
                        int update2 = ps2.executeUpdate();
                        if(update2 > 0){
                            System.out.println("Address Deleted from Database.");
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 3:
                        String sql3 = "UPDATE Employee SET empage = NULL WHERE empID=?";
                        PreparedStatement ps3 = con.prepareStatement(sql3);
                        ps3.setInt(1,id);
                        int update3 = ps3.executeUpdate();
                        if(update3 > 0){
                            System.out.println("Age Deleted from Database.");
                        }
                        break;
                    case 4:
                        String sql4 = "UPDATE Employee SET deptID = NULL WHERE empID=?";
                        PreparedStatement ps4 = con.prepareStatement(sql4);
                        ps4.setInt(1,id);
                        int update4 = ps4.executeUpdate();
                        if(update4 > 0){
                            System.out.println("DepartmentID Deleted from Database.");
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 5:
                        String sql5 = "DELETE FROM Employee WHERE empID=?";
                        PreparedStatement ps5 = con.prepareStatement(sql5);
                        ps5.setInt(1,id);
                        int update5 = ps5.executeUpdate();
                        if(update5 > 0){
                            System.out.println("Entire data Deleted of empID: "+id);
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid Input!!");
                        break;
                }
            }
        }
        con.close();
    }
}


class display{
    void displayData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
        Scanner sc = new Scanner(System.in);
        int c = 0;
        while (c != 3){
            System.out.println("Enter your choice to Display:\n1.Display by EmpID \n2.Display All Data\n3.Exit");
            c = sc.nextInt();
            switch (c){
                case 1:
                    System.out.println("Enter Employee ID:");
                    int id = sc.nextInt();
                    String sql = "SELECT * FROM Employee WHERE empID=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1,id);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        System.out.println("Employee Name: "+rs.getString(2)+"\n"+
                                "Employee Address: "+rs.getString(3)+"\n"+
                                "Employee Age: "+rs.getInt(4)+"\n"+
                                "Employee DeptID: "+rs.getInt(5));
                    }
                    break;
                case 2:
                    Statement st1 = con.createStatement();
                    String sql3 = "SELECT * FROM Employee";
                    ResultSet rs1 = st1.executeQuery(sql3);
                    System.out.println("ID    NAME       ADD  AGE  DEPT");
                    System.out.println("-----------------------------------");
                    while (rs1.next()){
                        System.out.println(rs1.getString(1)+" | "+
                                rs1.getString(2)+" | "+
                                rs1.getString(3)+" | "+
                                rs1.getInt(4)+" | "+
                                rs1.getInt(5));
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        con.close();
    }
}

class department{
    Scanner sc = new Scanner(System.in);
    void insertDepartment() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
        System.out.println("Enter Departent ID:");
        int dID = sc.nextInt();
        System.out.println("Enter Departent Name:");
        String dNAME = sc.next();

        String sql1 = "INSERT INTO Department(deptID, deptname) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setInt(1,dID);
        ps.setString(2,dNAME);
        int rowInserted = ps.executeUpdate();
        if(rowInserted > 0){
            System.out.println("Department Inseted!!");
            System.out.println("------------------------------------------");
        }
    }

//    void deleteDepartment() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
//    }
}



public class assignment{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        insert i = new insert();
        update u = new update();
        delete d = new delete();
        display di = new display();

        int c = 0;
        while (c != 5){
            System.out.println("|+++++++++++++++++++++++++++++|");
            System.out.println("|++++  EMPLOYEE DATABASE  ++++|");
            System.out.println("|+++++++++++++++++++++++++++++|");
            System.out.println("ENTER YOUR CHOICE:\n1.INSERT \n2.UPDATE\n3.DELETE\n4.DISPLAY\n5.Exit");
            c = sc.nextInt();
            switch (c){
                case 1:
                    i.insertData();
                    break;
                case  2:
                    u.updateData();
                    break;
                case 3:
                    d.deleteData();
                    break;
                case  4:
                    di.displayData();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input!!");
                    break;
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Do you want to insert into DEPARTMENT(Y/S)?");
        char ch = sc.next().charAt(0);
        if (ch == 'Y' || ch == 'y'){
            department dpt = new department();
            dpt.insertDepartment();
        }
//        else {
//            System.exit(0);
//        }
    }
}