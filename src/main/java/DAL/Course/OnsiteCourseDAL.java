/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author chris
 */
public class OnsiteCourseDAL extends MyDatabaseManager {

    public OnsiteCourseDAL() {

        OnsiteCourseDAL.connectDB();
    }

    public ArrayList readOnsiteCourse() throws SQLException {
        ArrayList list = new ArrayList();
        try {
            String query = "SELECT c.CourseID, c.Title , c.Credits, c.DepartmentID, os.Location, os.Days, os.Time "
                    + "FROM `onsitecourse` os, `course` c WHERE c.CourseID=os.CourseID";
            ResultSet rs = OnsiteCourseDAL.doReadQuery(query);
            if (rs != null) {
                int i = 1;
                while (rs.next()) {
                    OnsiteCourse s = new OnsiteCourse();
                    s.setCourseID(rs.getInt("c.CourseID"));
                    s.setTitle(rs.getString("c.Title"));
                    s.setCredits(rs.getInt("c.Credits"));
                    s.setDepartmentID(rs.getInt("c.DepartmentID"));
                    s.setLocation(rs.getString("os.Location"));
                    s.setDays(rs.getString("os.Days"));
                    s.setTime(rs.getTime("os.Time"));
                    list.add(s);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng bàn");
        } finally {
        }

        return list;
    }

    public OnsiteCourse getOs(int CourseID) throws SQLException {

        String query = "SELECT * FROM `onsitecourse` os,`course` c WHERE os.CourseID=c.CourseID "
                + "AND c.CourseID = ? ";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();

        OnsiteCourse os = new OnsiteCourse();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                os.setLocation(rs.getString("os.Location"));
                os.setDays(rs.getString("os.Days"));
                os.setTime(rs.getTime("os.Time"));
                os.setCourseID(rs.getInt("c.CourseID"));
                os.setCredits(rs.getInt("c.Credits"));
                os.setDepartmentID(rs.getInt("c.DepartmentID"));
                os.setTitle(rs.getString("c.Title"));

            }
        }
        return os;
    }

    public int deleteOnsiteCourse(int CourseID) throws SQLException {
        String query = "DELETE FROM onsitecourse WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        int result=p.executeUpdate();
        return result;
    }

    public int updateOnsiteCourse(OnsiteCourse s) throws SQLException {
        String query = "Update onsitecourse SET Location = ? , Days = ? , Time = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getLocation());
        p.setString(2, s.getDays());
        p.setTime(3, s.getTime());
        p.setInt(4, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertOnsiteCourse(OnsiteCourse s) throws SQLException {
        String query = "Insert onsitecourse (CourseID, Location, Days, Time) VALUES (?, ?, ?, ?)";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setString(2, s.getLocation());
        p.setString(3, s.getDays());
        p.setString(4, s.getTime().toString());
        p.setInt(1, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public List findOnsiteCourse(String value) throws SQLException {
        String query = "SELECT * FROM `onsitecourse` os, `course` c, `department` dp "
                + "WHERE os.CourseID=c.CourseID AND c.DepartmentID=dp.DepartmentID "
                + "AND c.Title LIKE ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + value + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnsiteCourse os = new OnsiteCourse();
                os.setLocation(rs.getString("os.Location"));
                os.setDays(rs.getString("os.Days"));
                os.setTime(rs.getTime("os.Time"));
                os.setCourseID(rs.getInt("c.CourseID"));
                os.setCredits(rs.getInt("c.Credits"));
                os.setDepartmentID(rs.getInt("c.DepartmentID"));
                os.setTitle(rs.getString("c.Title"));
                list.add(os);
            }
        }
        return list;
    }

}
