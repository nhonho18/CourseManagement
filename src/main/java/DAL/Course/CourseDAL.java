/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAL extends MyDatabaseManager {

    public CourseDAL() {
        CourseDAL.connectDB();
    }

    public ArrayList<Course> readCourse() throws SQLException {

        String query = "SELECT * FROM course ";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                Course c = new Course();
                c.setCourseID(rs.getInt("CourseID"));
                c.setCredits(rs.getInt("Credits"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                c.setTitle(rs.getString("Title"));
                list.add(c);
            }
        }
        return list;
    }

    public int insertCourse(Course s) throws SQLException {
        String query = "Insert course (Credits, DepartmentID, Title) VALUES (?, ?, ?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, s.getCredits());
        p.setInt(2, s.getDepartmentID());
        p.setString(3, s.getTitle());
        int result = p.executeUpdate();
        return result;
    }

    public int NewCourseID() {
        int id = 0;
        String query = "SELECT CourseID FROM course  ORDER BY CourseID DESC  LIMIT 1;";
        ResultSet rs = CourseDAL.doReadQuery(query);
        try {
            while (rs.next()) {
                id = rs.getInt("CourseID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public int updateCourse(Course s) throws SQLException {
        String query = "Update course SET Credits = ? , DepartmentID = ? , Title = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, s.getCredits());
        p.setInt(2, s.getDepartmentID());
        p.setString(3, s.getTitle());
        p.setInt(4, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int deleteCourse(int CourseID) throws SQLException {
        String query = "DELETE FROM course WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        int result = p.executeUpdate();
        return result;
    }

    public List getCourseIDFromCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM course WHERE CourseID = ?";

        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                Course s = new Course();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        return list;
    }
    public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT CourseID FROM course";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("CourseID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
     
    public ArrayList<String[]> readCourseByStudentId(int StudentID){
        ArrayList<String[]> list = new ArrayList<>();
        try {
           String queryOnline = "SELECT onlinecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onlinecourse` "
                    + "WHERE course.CourseID = onlinecourse.CourseID and studentgrade.CourseID = onlinecourse.CourseID and StudentID = '"+StudentID+"'";
            String queryOnsite = "SELECT onsitecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onsitecourse` "
                    + "WHERE course.CourseID = onsitecourse.CourseID and studentgrade.CourseID = onsitecourse.CourseID and StudentID = '"+StudentID+"'"; 
           ResultSet rs = this.doReadQuery(queryOnline);
           
           if(rs !=null){
                while(rs.next()){
                    String CourseID = rs.getString("CourseID");
                    String Title = rs.getString("Title");
                    String Type = "On";
                    String Grade = rs.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
           ResultSet rs2 = this.doReadQuery(queryOnsite);
           if(rs2 !=null){
                while(rs2.next()){
                    String CourseID = rs2.getString("CourseID");
                    String Title = rs2.getString("Title");
                    String Type = "Off";
                    String Grade = rs2.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
        
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<String> readCourseTitle(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT Title FROM course";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("Title");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<String[]> readCourseByStudentName(String Lastname , String Firstname){
        ArrayList<String[]> list = new ArrayList<>();
        try {
           String queryOnline = "SELECT onlinecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onlinecourse` ,`person`"
                    + "WHERE PersonID = studentgrade.StudentID and course.CourseID = onlinecourse.CourseID and studentgrade.CourseID = onlinecourse.CourseID "
                   + "and Lastname = '"+Lastname+"' and Firstname = '"+ Firstname + "'";
           
            String queryOnsite = "SELECT onsitecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onsitecourse` , `person` "
                    + "WHERE PersonID = studentgrade.StudentID and course.CourseID = onsitecourse.CourseID and studentgrade.CourseID = onsitecourse.CourseID "
                    + "and Lastname = '"+Lastname+"' and Firstname = '"+ Firstname + "'";
           ResultSet rs = this.doReadQuery(queryOnline);
           
           if(rs !=null){
                while(rs.next()){
                    String CourseID = rs.getString("CourseID");
                    String Title = rs.getString("Title");
                    String Type = "On";
                    String Grade = rs.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
           ResultSet rs2 = this.doReadQuery(queryOnsite);
           if(rs2 !=null){
                while(rs2.next()){
                    String CourseID = rs2.getString("CourseID");
                    String Title = rs2.getString("Title");
                    String Type = "Off";
                    String Grade = rs2.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
        
        } catch (Exception e) {
        }
        return list;
    }
    
    public String readCourseTitleByID(int courseID){
        String name = "";
        try {
            String query = "SELECT Title FROM course WHERE CourseID ='"+courseID+"'";
            ResultSet rs = CourseDAL.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                   name = rs.getString("Title");
                }
            }
        } catch (Exception e) {
        }
        return name;
    }

}
