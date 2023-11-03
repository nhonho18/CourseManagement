/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author chris
 */
public class OnsiteCourse extends Course {

    String Location, Days;
    Time Time;

    public OnsiteCourse() {

    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    public OnsiteCourse(String Location, String Days, Time Time) {
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

}
