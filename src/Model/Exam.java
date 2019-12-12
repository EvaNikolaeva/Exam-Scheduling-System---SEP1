package Model;

public class Exam
{
    private MyDate date;
    private String course;
    private String semester;
    private String type;
    private Examiner examiner1;
    private Examiner examiner2;
    private Examiner examiner3;
    private Room room;
    public static final String LEGAL_SEMESTERS[] = {"1X", "1Y", "1Z", "2X", "2Y", "2Z", "3X", "3Y", "3Z", "4X", "4Y", "4Z"};
    public static final String LEGAL_EXAMS[] = {"SDJ", "RWD", "MSE", "NES", "CAO", "DMP", "SEP"};

    public Exam(MyDate date, String course, String semester, String type, Room room, Examiner examiner1, Examiner examiner2, Examiner examiner3)
    {
        setAll(date, course, semester, type, room, examiner1, examiner2, examiner3);
    }


    public Exam(MyDate date, String course, String semester, String type, Room room, Examiner examiner1)
    {
        this.date = date;
        if (isLegalCourse(course))
        {
            this.course = course;
        }
        if (isLegalSemester(semester))
        {
            this.semester = semester;
        }
        this.type = type;
        this.room = room;
        this.examiner1 = examiner1;
        this.examiner2 = null;
        this.examiner3 = null;
    }

    public MyDate getDate()
    {
        return date;
    }

    public void setDate(MyDate date)
    {
        this.date = date;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        if (isLegalCourse(course))
        {
            this.course = course;
        }
    }

    public String getSemester()
    {
        return semester;
    }

    public void setSemester(String semester)
    {
        if (isLegalSemester(semester))
        {
            this.semester = semester;
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

    public Examiner getFirstExaminer()
    {
        return examiner1;
    }

    public void setFirstExaminer(Examiner examiner)
    {
        this.examiner1 = examiner;
    }

    public Examiner getSecondExaminer()
    {
        return examiner2;
    }

    public void setSecondExaminer(Examiner examiner)
    {
        this.examiner2 = examiner;
    }

    public Examiner getThirdExaminer()
    {
        return examiner3;
    }

    public void setThirdExaminer(Examiner examiner)
    {
        this.examiner3 = examiner;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    public void setAll(MyDate date, String course, String semester, String type, Room room, Examiner examiner1, Examiner examiner2, Examiner examiner3)
    {
        this.date = date;;
        if (isLegalCourse(course))
        {
            this.course = course;
        }
        if (isLegalSemester(semester))
        {
            this.semester = semester;
        }
        this.type = type;
        this.room = room;
        this.examiner1 = examiner1;
        this.examiner2 = examiner2;
        this.examiner3 = null;
    }

    public boolean isLegalSemester(String semester)
    {
        return semester.equals("1X") || semester.equals("1Y") || semester.equals("1Z") || semester.equals("2X") ||
                semester.equals("2Y") || semester.equals("2Z") || semester.equals("3X") || semester.equals("3Y") ||
                semester.equals("3Z") || semester.equals("4X") || semester.equals("4Y") || semester.equals("4Z");
    }

    public boolean isLegalCourse(String course)
    {
        return course.equals("SDJ") || course.equals("RWD") || course.equals("MSE") || course.equals("NES") ||
                course.equals("CAO") || course.equals("DMP") || course.equals("SEP");
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Exam))
        {
            return false;
        }
        Exam other = (Exam)obj;
        return date.equals(other.date) && course.equals(other.course) && type.equals(other.type) &&
                semester.equals(other.semester) && examiner1.equals(other.examiner1) && examiner2.equals(other.examiner2)
                && examiner3.equals(other.examiner3) && room.equals(other.room);
    }

    public String toString()
    {
        String s = "";
        s += "Course: " + course + semester + ", type: " + type + ", date: " + date + ", room: " + room + ", examiners: "
                + examiner1 + ", " + examiner2 + ", " + examiner3;
        return s;
    }
}
