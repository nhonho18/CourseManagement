/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import java.sql.Date;

/**
 *
 * @author chris
 */
public class Department {

    int DepartmentID, Adminstrator;
    double Budget;
    Date Startdate;

    public Department() {
    }

    public Department(int DepartmentID, int Adminstrator, double Budget, Date Startdate, String Name) {
        this.DepartmentID = DepartmentID;
        this.Adminstrator = Adminstrator;
        this.Budget = Budget;
        this.Startdate = Startdate;
        this.Name = Name;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public int getAdminstrator() {
        return Adminstrator;
    }

    public void setAdminstrator(int Adminstrator) {
        this.Adminstrator = Adminstrator;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }

    public Date getStartdate() {
        return Startdate;
    }

    public void setStartdate(Date Startdate) {
        this.Startdate = Startdate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    String Name;
}
