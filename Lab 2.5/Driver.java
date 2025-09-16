import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        // make students
        System.out.println("Let's start by entering student data.");

        int ID = 0;
        Student[] classroom = new Student[1];

        while (true) { 
            
            String firstName = KeyboardReader.readLine("Student First Name: ");
            String lastName = KeyboardReader.readLine("Student Last Name: ");

            int numCourses = Math.max(KeyboardReader.readInt("\nHow many courses has the student taken?"), 0);
            String[] courses = new String[numCourses];

            for (int i = 0; i < numCourses; i ++) {
                
                courses[i] = KeyboardReader.readLine("Course " + (i+1) + " name: ");
                
            }

            classroom[ID] = new Student(firstName, lastName, ID, courses);

            char addAnother = KeyboardReader.readChar("\nAdd another student? (Y/N)");
            if (Character.toLowerCase(addAnother) != 'y') {
                break;
            }
            else {
                // make room for another student and update the ID
                // System.arraycopy(classroom, 0, classroom, 0, ++ID);
                classroom = Arrays.copyOf(classroom, ++ ID + 1);
            }

            
        }
        

        // compare students
        Student student;
        String matchWord;
        String equalsWord;
        for (int i = 0; i < ID + 1; i ++) {

            student = classroom[i];
            int studentHash = student.hashCode();

            for (int j = 0; j < ID; j ++) {

                // don't compare the student against itself, that's mean
                if (j != i) {
                    
                    int comparisonHash = classroom[j].hashCode();
                    matchWord = studentHash == comparisonHash ? "matches" : "does not matches";
                    System.out.println("Student " + student.ID + ", (" + student.firstName + " " + student.lastName + ") has a hash that " + matchWord + " Student " + classroom[j].ID + ", (" + classroom[j].firstName + " " + classroom[j].lastName + ".");
                    equalsWord = student.equals(classroom[j]) ? "equivalent." : "not equivalent.";
                    System.out.println(".equals says that the two are " + equalsWord);

                }
            }

        }

    }
    
}
