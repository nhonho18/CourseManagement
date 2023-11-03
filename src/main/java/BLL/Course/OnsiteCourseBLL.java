/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import BLL.CourseIntructorBLL;
import BLL.StudentGradeBLL;
import DAL.Course.OnsiteCourse;
import DAL.Course.OnsiteCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class OnsiteCourseBLL extends CourseBLL {

    OnsiteCourseDAL osdal;
    CourseBLL cobll;
    DepartmentBLL dbll = new DepartmentBLL();
    CourseIntructorBLL cib;
    StudentGradeBLL sgb;

    public OnsiteCourseBLL() {
        osdal = new OnsiteCourseDAL();
        cobll = new CourseBLL();
        dbll = new DepartmentBLL();
    }

    public List LoadOnsiteCourse() throws SQLException {
        ArrayList list = osdal.readOnsiteCourse();
        return list;
    }

    public int addOnsiteCourse(OnsiteCourse s) throws SQLException {
        this.addCourse(s);
        int id = this.NewCourseBLL();
        s.setCourseID(id);
        int result = osdal.insertOnsiteCourse(s);
        return result;
    }

    public int editOnsiteCourse(OnsiteCourse s) throws SQLException {
        this.editCourse(s);
        int result = osdal.updateOnsiteCourse(s);
        return result;
    }

    public OnsiteCourse getOs(int CourseID) throws SQLException {
        OnsiteCourse os = osdal.getOs(CourseID);
        return os;
    }

    public List findOnsiteCourse(String condititon) throws SQLException {

        ArrayList<OnsiteCourse> onlclist = osdal.readOnsiteCourse();
        ArrayList<OnsiteCourse> onlcsearch = new ArrayList<OnsiteCourse>();
        condititon = condititon.trim().replaceAll("  +", " ").toLowerCase();
        String oldCondition = condititon;
        String[] conditions = condititon.split(" ");
//
        for (int i = 0; i < onlclist.size(); i++) {
            String regex = onlclist.get(i).getTitle() + " " + dbll.DepartmentName(onlclist.get(i).getDepartmentID());
            for (int j = 0; j < conditions.length; j++) {
                String oldChirlCondition = conditions[j];
                conditions[j] = "(.*)" + conditions[j] + "(.*)";
                if (regex.toLowerCase().matches(conditions[j])) {
                    onlcsearch.add(onlclist.get(i));
                    break;
                }
                conditions[j] = oldChirlCondition;
            }

        }
        if (onlcsearch.size() == 0) {
            return onlclist;
        }
        return onlcsearch;

    }

    public int deleteOnsiteCourse(int CourseID) throws SQLException {
        int result;
        cib = new CourseIntructorBLL();
        sgb = new StudentGradeBLL();
        cobll = new CourseBLL();
        if ((cib.getCourseIDFromCourseInstructor(CourseID).isEmpty() == false && cobll.getCourseIDFromCourse(CourseID).isEmpty() == false)
                || (sgb.getCourseIDFromStudentGrade(CourseID).isEmpty() == false && cobll.getCourseIDFromCourse(CourseID).isEmpty() == false)) {
            result = 0;
        } else {
            osdal.deleteOnsiteCourse(CourseID);
            cobll.deleteCourse(CourseID);
            result = 1;
        }
        return result;
    }
}
