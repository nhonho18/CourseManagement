package BLL;

import DAL.Student.Student;
import DAL.Student.StudentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBLL {

    StudentDAL stdDal;
    StudentGradeBLL sgb;

    public StudentBLL() {
        stdDal = new StudentDAL();
    }

    public List LoadStudents() throws SQLException {
        ArrayList list = stdDal.readStudent();
        return list;
    }

    public List findStudent(String fullname) throws SQLException {
        List list = new ArrayList();

        list = stdDal.findStudents(fullname);

        return list;
    }

    public Student getStudent(int personID) throws SQLException {
        Student s = stdDal.getStudent(personID);
        return s;
    }

    public int addStudent(Student s) throws SQLException {
        int result = stdDal.insertStudent(s);
        return result;
    }

    public int updateStudent(Student s) throws SQLException {
        int result = stdDal.updateStudent(s);
        return result;
    }

    public int deleteStudent(int studentID) throws SQLException {
        sgb = new StudentGradeBLL();
        if (sgb.getStudentIDFromStudentGrade(studentID).isEmpty() == false) {
            return 0;
        }
        int result = stdDal.deleteStudent(studentID);
        return result;
    }

    public ArrayList<String> readDSID(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
    public ArrayList<String> readStudentsName(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.readStudentsName();
        return list;
    }
    public ArrayList<String[]> readStudentByCourseIdBll(String courseID){
        int courseid = Integer.parseInt(courseID);
        StudentDAL std = new StudentDAL();
        ArrayList<String[]> list = std.readStudentByCourseID(courseid);
        return list;
    }
    
     public ArrayList<String[]> readStudentByCourseTitleBll(String courseTitle){
        StudentDAL std = new StudentDAL();
        ArrayList<String[]> list = std.readStudentByCourseTitle(courseTitle);
        return list;
    }
}
