/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.CourseInstructor;

import DAL.MyDatabaseManager;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class CourseInstructorDAL extends MyDatabaseManager {

    public CourseInstructorDAL() {
        super();
        this.connectDB();
    }

    public List readCourseInstructor() throws SQLException {
        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.personID = p.personID and c.courseid = ce.courseid";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                CourseInstructor c = new CourseInstructor();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                list.add(c);
            }
        }
        return list;
    }

    public List findCourseInstructor(String sql) throws SQLException {
        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.personID = p.personID and c.courseid = ce.courseid";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                CourseInstructor c = new CourseInstructor();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                list.add(c);
            }
        }
        return list;
    }

    public int insertCourseInstructor(CourseInstructor c) throws SQLException {
        String query = "Insert courseinstructor (courseID, personID) VALUES (?, ?)";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getCourseID() + "");
        p.setString(2, c.getPersonID() + "");

        int result = p.executeUpdate();
        return result;
    }

    public int updateCourseInstructor(CourseInstructor c, CourseInstructor old) throws SQLException {
        String query = "Update  CourseInstructor SET CourseID = ? , PersonID = ? where CourseID = ? and PersonID = ? ";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setInt(1, c.getCourseID());
        p.setInt(2, c.getPersonID());
        p.setInt(3, old.getCourseID());
        p.setInt(4, old.getPersonID());
        int result = p.executeUpdate();
        return result;
    }

    public int deleteCourseInstructor(CourseInstructor c) throws SQLException {
        int result = -1;
        String query = "DELETE FROM CourseInstructor WHERE PersonID = ? and CourseID = ?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setInt(1, c.getPersonID());
        p.setInt(2, c.getCourseID());
        result = p.executeUpdate();

        return result;
    }

    public List getCourseIDFromCourseInstructor(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM courseinstructor WHERE CourseID = ?";

        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
          CourseInstructor s = new CourseInstructor();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        return list;
    }

    
     public List getPersonIDFromCourseInstructor(int personID) throws SQLException {

        String query = "SELECT PersonID FROM courseinstructor WHERE PersonID = ? ";

        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);

        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
              CourseInstructor s = new CourseInstructor(); 
                s.setPersonID(rs.getInt("PersonID"));

                list.add(s);
            }
        }
        return list;

     }

}
