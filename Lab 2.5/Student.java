import java.util.Arrays;

public class Student {
    
    public String firstName;
    public String lastName;
    public int ID;
    public String[] coursesTaken;

    public Student (String firstName, String lastName, int ID, String[] coursesTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.coursesTaken = coursesTaken;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (o instanceof Student) {
            Student s = (Student)o;
            return this.firstName.equals(s.firstName) && this.lastName.equals(s.lastName) && Arrays.equals(s.coursesTaken, this.coursesTaken);
        }

        return false;
    }


    public int hashCode() {
        int hCode = 17;
        hCode = 31 * hCode + firstName.hashCode();
        hCode = 31 * hCode + lastName.hashCode();
        hCode = 31 * hCode + Arrays.hashCode(coursesTaken);

        // I'm not hashing the id since that would prevent finding if two students are the same, since students with identical data but different ID's would end up with different hashes
        
        return hCode;
    }

}
