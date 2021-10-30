import java.sql.*;
import java.util.Scanner;

class enterData{
        enterData() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb","root","");
            System.out.println("Connection Established!!");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter UserID:");
            String userid = sc.next();
            System.out.println("Enter Password:");
            String password = sc.next();

            String sql = "SELECT userid, password FROM login where userid=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,userid);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Login Successful!!");
            }
            else{
                System.out.println("Wrong ID and Password!!");
            }
            con.close();
            System.out.println("Connection Closed!!");
        }
}

class addUser {
    addUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdb", "root", "");
        System.out.println("Connection Established!!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserID:");
        String userid = sc.nextLine();
        System.out.println("Enter your Name:");
        String name = "";
        name += sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.next();

        String sql1 = "INSERT INTO login VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setString(1,userid);
        ps.setString(2,name);
        ps.setString(3,password);
        int rowInserted = ps.executeUpdate();
        if(rowInserted > 0){
            System.out.print("User Registration Successful!!");
        }
        else{
            System.out.println("User Registration Failed!!");
        }
    }
}
class sqlLogin {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        enterData ob1 = new enterData();
        addUser ob2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add new USER?(Y/S)");
        char ch = sc.next().charAt(0);
        if (ch == 'Y' || ch == 'y'){
            ob2 = new addUser();
        }
        else{
            System.out.println("Something went wrong try again!!");
        }
    }
}
