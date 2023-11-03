/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import BLL.CourseIntructorBLL;
import BLL.StudentGradeBLL;
import DAL.Course.OnlineCourse;
import DAL.Course.OnlineCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class OnlineCourseBLL extends CourseBLL {

    OnlineCourseDAL oldal;
    CourseBLL cobll;
    DepartmentBLL dpmbll;
    CourseIntructorBLL cib;
    StudentGradeBLL sgb;

    public OnlineCourseBLL() {
        oldal = new OnlineCourseDAL();
        cobll = new CourseBLL();
        dpmbll = new DepartmentBLL();
    }

    public List LoadOnlineCourse() throws SQLException {
        ArrayList list = oldal.readOnlineCourse();
        return list;
    }

    public int addOnlineCourse(OnlineCourse s) throws SQLException {
        this.addCourse(s);
        int id = this.NewCourseBLL();
        s.setCourseID(id);
        int result = oldal.insertOnlineCourse(s);
        return result;
    }

    public int editOnlineCourse(OnlineCourse s) throws SQLException {
        this.editCourse(s);
        int result = oldal.updateOnlineCourse(s);
        return result;
    }

    public OnlineCourse getOs(int CourseID) throws SQLException {
        OnlineCourse os = oldal.getOs(CourseID);
        return os;
    }

    public int deleteOnlineCourse(int CourseID) throws SQLException {
        int result;
        cib = new CourseIntructorBLL();
        sgb = new StudentGradeBLL();
        cobll = new CourseBLL();
        if ((cib.getCourseIDFromCourseInstructor(CourseID).isEmpty() == false && cobll.getCourseIDFromCourse(CourseID).isEmpty() == false)
                || (sgb.getCourseIDFromStudentGrade(CourseID).isEmpty() == false && cobll.getCourseIDFromCourse(CourseID).isEmpty() == false)) {
            result = 0;
        } else {
            oldal.deleteOnlineCourse(CourseID);
            cobll.deleteCourse(CourseID);
            result = 1;
        }
        return result;
    }

    public List findOnlineCourse(String condititon) throws SQLException {

        ArrayList<OnlineCourse> onlclist = oldal.readOnlineCourse();
        ArrayList<OnlineCourse> onlcsearch = new ArrayList<OnlineCourse>();
        condititon = condititon.trim().replaceAll("  +", " ").toLowerCase();
        String oldCondition = condititon;
        String[] conditions = condititon.split(" ");
//
        for (int i = 0; i < onlclist.size(); i++) {
            String regex = onlclist.get(i).getTitle() + " " + dpmbll.DepartmentName(onlclist.get(i).getDepartmentID());
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
}
