package DAL.CourseInstructor;

public class CourseInstructor {
    private int CourseID;
    private int PersonID;

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public CourseInstructor() {
    }

    public CourseInstructor(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }
    
    public String getALL() {
        return (PersonID+" "+ CourseID+" ");
    }
    
}
