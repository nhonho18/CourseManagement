package DAL.Teacher;

import DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TeacherDAL extends MyDatabaseManager {

    public TeacherDAL() {
        TeacherDAL.connectDB();
    }

    public ArrayList readTeacher() throws SQLException {
        String query = "SELECT * FROM Person WHERE HireDate > 0";
        ResultSet rs = TeacherDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Teacher s = new Teacher();
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setHireDate(Date.valueOf(rs.getString("HireDate").split(" ")[0]));
                list.add(s);
            }
        }
        return list;
    }

    public Teacher getTeacher(int personID) throws SQLException {

        String query = "SELECT * FROM Person WHERE HireDate IS NOT NULL AND PersonID = ? ";

        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();

        Teacher s = new Teacher();
        if (rs != null) {
            while (rs.next()) {
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setHireDate(Date.valueOf(rs.getString("HireDate").split(" ")[0]));
            }
        }
        return s;
    }

    public int updateTeacher(Teacher s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertTeacher(Teacher s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, HireDate) VALUES (?, ?, ?)";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getHireDate().toString());
        int result = p.executeUpdate();
        return result;
    }

    //3 layer
    public List findTeachers(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ? AND HireDate IS NOT NULL";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Teacher s = new Teacher();
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setHireDate(Date.valueOf(rs.getString("HireDate").split(" ")[0]));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteTeacher(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        return result;
    }

    public static void main(String[] args) {
    }
}
