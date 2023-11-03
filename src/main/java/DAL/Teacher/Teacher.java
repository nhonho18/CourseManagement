package DAL.Teacher;

import java.util.Date;

public class Teacher {
    String firstName, lastName;
    int personID;
    Date hireDate;
    
    public Teacher(){
         
    }
    
    public Teacher(String firstName, String lastName, Date hireDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
