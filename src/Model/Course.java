package Model;

/**
 * A class representing a course.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class Course
{
    private int semester;
    private String name;
    private String type;
    private int numberOfStudents;
    /**
     * The constant LEGAL_COURSES.
     */
    public static final String LEGAL_COURSES[] = {"SDJ1X", "SDJ1Y", "SDJ1Z", "RWD1X", "RWD1Y", "RWD1Z", "MSE1X", "MSE1Y",
            "MSE1Z", "SEP1X", "SEP1Y", "SEP1Z", "SDJ2", "SDJ3X", "SDJ3Y", "SEP2", "NES1X", "NES1Y", "DNP1X", "DNP1Y", "DBS1"};

    /**
     * Four-argument constructor instantiating a new Course.
     *
     * @param name             the name of the course
     * @param type             the type of the exam
     * @param numberOfStudents the number of students taking the course
     * @param semester         the semester
     */
    public Course(String name, String type, int numberOfStudents, int semester)
    {
        this.semester = semester;
        setCourse(name, type, numberOfStudents);
    }

    /**
     * Getter for name.
     *
     * @return the name of the course
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the course if it is a legal one.
     *
     * @param name the name of the course
     */
    public void setName(String name)
    {
        boolean illegal = true;

        for (int i = 0; i < LEGAL_COURSES.length; i++)
        {
            if (name.equals(LEGAL_COURSES[i])) {
                this.name = name;
                illegal = false;
                break;
            }
        }
        if (illegal) {
            throw new IllegalArgumentException("Illegal argument for course!!!!");

        } else {
            System.out.println("success");
        }
    }

    /**
     * Getter for type.
     *
     * @return the type of the exam
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the type of the exam
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Getter for number of students.
     *
     * @return the number of students taking the course
     */
    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    /**
     * Setter for number of students.
     *
     * @param numberOfStudents the number of students taking the course
     */
    public void setNumberOfStudents(int numberOfStudents)
    {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Getter for semester.
     *
     * @return the semester
     */
    public int getSemester()
    {
        return semester;
    }

    /**
     * Setter for semester.
     *
     * @param semester the semester
     */
    public void setSemester(int semester)
    {
        this.semester = semester;
    }

    /**
     * Sets the course and checks if the name is legal.
     *
     * @param name             the name of the course
     * @param type             the type of the exam
     * @param numberOfStudents the number of students taking the course
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setCourse(String name, String type, int numberOfStudents) throws IllegalArgumentException
    {
        boolean illegal = true;

        for (int i = 0; i < LEGAL_COURSES.length; i++)
        {
            if (name.equals(LEGAL_COURSES[i])) {
                this.name = name;
                illegal = false;
                break;
            }

        }
        if (illegal) {
            throw new IllegalArgumentException("Illegal argument for course!!!!");

        } else {
            System.out.println("Valid course details added!!");
        }

        this.type = type;
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Returning information about a course.
     * @return a string with information about a course
     */
    public String toString()
    {
        return name;
    }

    /**
     * Returning if two courses are the same.
     * @param obj the course compared to
     * @return true if the courses are identical. Otherwise return false.
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Course))
        {
            return false;
        }
        Course other = (Course)obj;
        return name.equals(other.name) && type.equals(other.type) && numberOfStudents == other.numberOfStudents
                && semester == other.semester;
    }
}
