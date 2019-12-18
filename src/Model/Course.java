package Model;

/**
 * The type Course.
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
     * Instantiates a new Course.
     *
     * @param name             the name
     * @param type             the type
     * @param numberOfStudents the number of students
     * @param semester         the semester
     */
    public Course(String name, String type, int numberOfStudents, int semester)
    {
        this.semester = semester;
        setCourse(name, type, numberOfStudents);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
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
     * Gets type.
     *
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets number of students.
     *
     * @return the number of students
     */
    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    /**
     * Sets number of students.
     *
     * @param numberOfStudents the number of students
     */
    public void setNumberOfStudents(int numberOfStudents)
    {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Gets semester.
     *
     * @return the semester
     */
    public int getSemester()
    {
        return semester;
    }

    /**
     * Sets semester.
     *
     * @param semester the semester
     */
    public void setSemester(int semester)
    {
        this.semester = semester;
    }

    /**
     * Sets course.
     *
     * @param name             the name
     * @param type             the type
     * @param numberOfStudents the number of students
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

    public String toString()
    {
        return name;
    }

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
