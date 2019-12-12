package Model;

public class Exam
{
    private MyDate date1;
    private MyDate date2;
    private MyDate date3;
    private String course;
    private String semester;
    private String type;
    private Examiner examiner1;
    private Examiner examiner2;
    private Examiner examiner3;
    private Room room;
    public static final String LEGAL_SEMESTERS[] = {"1X", "1Y", "1Z", "2X", "2Y", "2Z", "3X", "3Y", "3Z", "4X", "4Y", "4Z"};
    public static final String LEGAL_EXAMS[] = {"SDJ", "RWD", "MSE", "NES", "CAO", "DMP", "SEP"};

    public Exam(MyDate date1, MyDate date2, MyDate date3, String course, String semester, String type, Room room, Examiner examiner1, Examiner examiner2, Examiner examiner3)
    {
        setAll(date1, date2, date3, course, semester, type, room, examiner1, examiner2, examiner3);
    }

    public Exam(MyDate date1, String course, String semester, String type, Room room, Examiner examiner1, Examiner examiner2, Examiner examiner3)
    {
        this.date1 = date1;
        this.date2 = null;
        this.date3 = null;
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

    public Exam(MyDate date1, String course, String semester, String type, Room room, Examiner examiner1)
    {
        this.date1 = date1;
        this.date2 = null;
        this.date3 = null;
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

    public MyDate getFirstDate()
    {
        return date1;
    }

    public void setFirstDate(MyDate date1)
    {
        this.date1 = date1;
    }

    public MyDate getSecondDate()
    {
        return date2;
    }

    public void setSecondDate(MyDate date2)
    {
        this.date2 = date2;
    }

    public MyDate getThirdDate()
    {
        return date3;
    }

    public void setThirdDate(MyDate date3)
    {
        this.date3 = date3;
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

    public void setFirstExaminer(Examiner examiner1)
    {
        this.examiner1 = examiner1;
    }

    public Examiner getSecondExaminer()
    {
        return examiner2;
    }

    public void setSecondExaminer(Examiner examiner2)
    {
        this.examiner2 = examiner2;
    }

    public Examiner getThirdExaminer()
    {
        return examiner3;
    }

    public void setThirdExaminer(Examiner examiner3)
    {
        this.examiner3 = examiner3;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    public void setAll(MyDate date1, MyDate date2, MyDate date3, String course, String semester, String type, Room room, Examiner examiner1, Examiner examiner2, Examiner examiner3)
    {
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
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
        return date1.equals(other.date1) && date2.equals(other.date2) && date3.equals(other.date3) &&
                course.equals(other.course) && type.equals(other.type) && semester.equals(other.semester) &&
                examiner1.equals(other.examiner1) && examiner2.equals(other.examiner2) && examiner3.equals(other.examiner3)
                && room.equals(other.room);
    }

    public String toString()
    {
        String s = "";
        s += "Course: " + course + semester + ", type: " + type + ", date: " + date1;
        if (course.equals("SDJ") || course.equals("SEP"))
        {
            s += ", " + date2 + ", " + date3;
        }
        s += ", room: " + room + ", examiners: " + examiner1 + ", " + examiner2 + ", " + examiner3;
        return s;
    }
}
