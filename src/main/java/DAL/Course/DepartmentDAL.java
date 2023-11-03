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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class DepartmentDAL extends MyDatabaseManager {

    public DepartmentDAL() {
        DepartmentDAL.connectDB();
    }

    public ArrayList readDepartment() throws SQLException {
        String query = "SELECT * FROM department ";
        ResultSet rs = DepartmentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Department s = new Department();
                s.setDepartmentID(rs.getInt("DepartmentID"));
                s.setName(rs.getString("Name"));
                list.add(s);
            }
        }

        return list;
    }

    public String getDepartmentName(int DepartmentID) {
        ArrayList<String> dsdp = new ArrayList<>();
        try {
            String query = "SELECT `DepartmentID`, `Name`, `Budget`, `StartDate`, `Administrator` FROM `department` WHERE DepartmentID = " + DepartmentID;

            PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(query);
            ResultSet rs = this.doReadQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    return rs.getString("Name");
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public int NameconvertID(String Name) throws SQLException {
        int id = 0;
        String query = "SELECT DepartmentID FROM department Where Name = ? ";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(query);
        p.setString(1, Name);
        ResultSet rs = p.executeQuery();

        try {
            while (rs.next()) {
                id = rs.getInt("DepartmentID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public String IDconvertName(int ID) throws SQLException{
        String name="";
        String query = "SELECT Name FROM department Where DepartmentID = ? ";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(query);
        p.setInt(1, ID);
        ResultSet rs = p.executeQuery();

           try {
            while(rs.next()){
                name=rs.getString("Name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

}
