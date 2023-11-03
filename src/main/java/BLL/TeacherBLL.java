package BLL;

import DAL.Teacher.Teacher;
import DAL.Teacher.TeacherDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherBLL {

    TeacherDAL tchDal;
    CourseIntructorBLL cib;

    public TeacherBLL() {
        tchDal = new TeacherDAL();
    }

    public List LoadTeachers() throws SQLException {
        ArrayList list = tchDal.readTeacher();
        return list;
    }

    public List findTeacher(String fullname) throws SQLException {
        List list = new ArrayList();

        list = tchDal.findTeachers(fullname);

        return list;
    }

    public Teacher getTeacher(int personID) throws SQLException {
        Teacher t = tchDal.getTeacher(personID);
        return t;
    }

    public int addTeacher(Teacher t) throws SQLException {
        int result = tchDal.insertTeacher(t);
        return result;
    }

    public int editTeacher(Teacher t) throws SQLException {
        int edit = tchDal.updateTeacher(t);
        return edit;
    }

    public int deleteTeacher(int personID) throws SQLException {
                cib = new CourseIntructorBLL();
        if (cib.getPersonIDFromCourseInstructor(personID).isEmpty() == false) {
            return 0;
        }

        int del = tchDal.deleteTeacher(personID);
        return del;
    }

    public static void main(String[] args) {
    }
}
