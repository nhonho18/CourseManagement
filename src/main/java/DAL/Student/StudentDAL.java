package DAL.Student;

import DAL.MyDatabaseManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL extends MyDatabaseManager {

    public StudentDAL() {
        StudentDAL.connectDB();
    }

    public ArrayList readStudent() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        ResultSet rs = StudentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate").split(" ")[0]));
                list.add(s);
            }
        }
        return list;
    }

    public Student getStudent(int personID) throws SQLException {

        String query = "SELECT * FROM Person WHERE EnrollmentDate IS NOT NULL AND PersonID = ? ";

        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();

        Student s = new Student();
        if (rs != null) {
            while (rs.next()) {
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate").split(" ")[0]));
            }
        }
        return s;
    }

    public int updateStudent(Student s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result;
    }

    public int insertStudent(Student s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getEnrollmentDate().toString());
        int result = p.executeUpdate();
        return result;
    }

    //3 layer
    public List findStudents(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ? AND EnrollmentDate IS NOT NULL";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate").split(" ")[0]));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteStudent(int personID) throws SQLException {
            String query = "DELETE FROM Person WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, personID);
            int result = p.executeUpdate();
            return result;
    }
    public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID FROM person WHERE EnrollmentDate>0";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("PersonID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<String[]> readStudentByCourseID(int courseID){
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID , LastName , Firstname , Grade FROM `person`, `studentgrade` "
                    + "WHERE PersonID = StudentID and CourseID = '"+courseID+"'";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String PersonID = rs.getString("PersonID");
                    String FullName = rs.getString("Lastname")+" "+rs.getString("Firstname");
                    String grade = rs.getString("Grade");
                    System.out.println(FullName);
                    String[] s = {PersonID,FullName,grade}; 
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<String[]> readStudentByCourseTitle(String courseTitle){
         ArrayList<String[]> list = new ArrayList<>();
        try {
            //fix
            String query = "SELECT PersonID , LastName , Firstname , Grade FROM `person`, `studentgrade` "
                    + "WHERE PersonID = StudentID and CourseID = '"+courseTitle+"'";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String PersonID = rs.getString("PersonID");
                    String FullName = rs.getString("Lastname")+" "+rs.getString("Firstname");
                    String grade = rs.getString("Grade");
                    System.out.println(FullName);
                    String[] s = {PersonID,FullName,grade}; 
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    public String readStudentNameByID(int stuid){
        System.out.println(stuid);
        String name = "";
        try {
            String query = "SELECT Lastname , FirstName FROM Person WHERE EnrollmentDate > 0 AND PersonID ='"+stuid+"'";
            ResultSet rs = StudentDAL.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                   name = rs.getString("Lastname") + " " + rs.getString("Firstname");
                }

                System.out.println("Name : "+name);
            }
        } catch (Exception e) {
        }
        return name;
    }
        public ArrayList<String> readStudentsName(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT Lastname , Firstname FROM person WHERE EnrollmentDate>0";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String fullname = rs.getString("Lastname")+ " " + rs.getString("Firstname");
                    list.add(fullname);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
