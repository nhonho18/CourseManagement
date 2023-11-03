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
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class OnlineCourseDAL extends MyDatabaseManager {

    public OnlineCourseDAL() {

        OnlineCourseDAL.connectDB();
    }

    public ArrayList readOnlineCourse() throws SQLException {
        ArrayList list = new ArrayList();
        try {
            String query = "SELECT c.CourseID, c.Title , c.Credits, c.DepartmentID, ol.url "
                    + "FROM `onlinecourse` ol, `course` c WHERE c.CourseID=ol.CourseID";
            ResultSet rs = OnlineCourseDAL.doReadQuery(query);
            if (rs != null) {
                int i = 1;
                while (rs.next()) {
                    OnlineCourse s = new OnlineCourse();
                    s.setCourseID(rs.getInt("CourseID"));
                    s.setTitle(rs.getString("Title"));
                    s.setCredits(rs.getInt("Credits"));
                    s.setDepartmentID(rs.getInt("DepartmentID"));
                    s.setURL(rs.getString("url"));
                    list.add(s);
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng bàn");
            ex.printStackTrace();
        } finally {
        }

        return list;
    }

    public OnlineCourse getOs(int CourseID) throws SQLException {

        String query = "SELECT * FROM `onlinecourse` ol,`course` c,`department` d WHERE ol.CourseID=c.CourseID  AND d.DepartmentID = c.DepartmentID "
                + "AND c.CourseID = ? ";

        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();

        OnlineCourse ol = new OnlineCourse();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                ol.setURL(rs.getString("url"));
                ol.setCourseID(rs.getInt("CourseID"));
                ol.setCredits(rs.getInt("Credits"));
                ol.setDepartmentID(rs.getInt("DepartmentID"));
                ol.setDepartmentName(rs.getString("Name"));
                ol.setTitle(rs.getString("Title"));

            }
        }
        return ol;
    }

    public int deleteOnlineCourse(int CourseID) throws SQLException {
        String query = "DELETE FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        int result = p.executeUpdate();
        return result;
    }

    public int updateOnlineCourse(OnlineCourse s) throws SQLException {
        String query = "Update onlinecourse SET url = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getURL());
        p.setInt(2, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertOnlineCourse(OnlineCourse s) throws SQLException {
        String query = "Insert onlinecourse (CourseID, url) VALUES (?, ?)";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(query);
        p.setString(2, s.getURL().toString());
        p.setInt(1, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public List findOnlineCourse(String value) throws SQLException {
        String query = "SELECT * FROM `onlinecourse` os, `course` c, `department` dp "
                + "WHERE os.CourseID=c.CourseID AND c.DepartmentID=dp.DepartmentID "
                + "AND c.Title LIKE ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + value + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                OnlineCourse os = new OnlineCourse();
                os.setURL(rs.getString("os.url"));
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
