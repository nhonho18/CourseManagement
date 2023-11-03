/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import DAL.Course.DepartmentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class DepartmentBLL {

    DepartmentDAL dpdal;

    public DepartmentBLL() {
        dpdal = new DepartmentDAL();
    }

    public List LoadDepartment(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = dpdal.readDepartment();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public int DepartmentID(String name) throws SQLException {
        int id = dpdal.NameconvertID(name);
        return id;
    }

    public String getDepartmentName(int DepartmentID) throws SQLException {
        String result = dpdal.getDepartmentName(DepartmentID);
        return result;
    }

    public String DepartmentName(int id) throws SQLException {
        String name = dpdal.IDconvertName(id);
        return name;
    }
}
