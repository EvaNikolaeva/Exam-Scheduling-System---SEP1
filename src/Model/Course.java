package Model;

public class Course
{
    private String name;
    private String type;
    private int numberOfStudents;
    public static final String LEGAL_COURSES[] = {"SDJ1X", "SDJ1Y", "SDJ1Z", "RWD1X", "RWD1Y", "RWD1Z", "MSE1X", "MSE1Y",
            "MSE1Z", "SEP1X", "SEP1Y", "SEP1Z", "SDJ2", "SDJ3X", "SDJ3Y", "SEP2", "NES1X", "NES1Y", "DNP1X", "DNP1Y", "DBS1"};

    public Course(String name, String type, int numberOfStudents)
    {
        setCourse(name, type, numberOfStudents);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        try
        {
            for (int i = 0; i < LEGAL_COURSES.length; i++)
            {
                if (name.equals(LEGAL_COURSES[i]))
                {
                    this.name = name;
                }
            }
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents)
    {
        this.numberOfStudents = numberOfStudents;
    }

    public void setCourse(String name, String type, int numberOfStudents)
    {
        try
        {
            for (int i = 0; i < LEGAL_COURSES.length; i++)
            {
                if (name.equals(LEGAL_COURSES[i]))
                {
                    this.name = name;
                }
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        this.type = type;
        this.numberOfStudents = numberOfStudents;
    }

    public String toString()
    {
        String s = "";
        s += "Course: " + name + ", type: " + type + ", students attending: " + numberOfStudents;
        return s;
    }
}
