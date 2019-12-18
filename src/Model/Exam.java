package Model;

public class Exam
{
    private MyDate date;
    private Course course;
    private Examiner examiner1;
    private Examiner examiner2;
    private Room room;

    public Exam(MyDate date, Course course, Room room, Examiner examiner1, Examiner examiner2)
    {
        setAll(date, course, room, examiner1, examiner2);
    }


    public Exam(MyDate date, Course course, Room room, Examiner examiner1)
    {
        this.date = date;
        this.course = course;
        this.room = room;
        this.examiner1 = examiner1;
        this.examiner2 = null;
    }

    public MyDate getDate()
    {
        return date;
    }

    public void setDate(MyDate date)
    {
        this.date = date;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
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

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    public void setAll(MyDate date, Course course, Room room, Examiner examiner1, Examiner examiner2)
    {
        this.date = date;;
        this.course = course;
        this.room = room;
        this.examiner1 = examiner1;
        this.examiner2 = examiner2;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Exam))
        {
            return false;
        }
        Exam other = (Exam)obj;
        return date.equals(other.date) && course.equals(other.course) && examiner1.equals(other.examiner1) &&
                examiner2.equals(other.examiner2) && room.equals(other.room);
    }

    public String toString()
    {
        String s = "";
        s +=  course + ", date: " + date + ", room: " + room + ", examiners: " + examiner1 + ", " + examiner2;
        return s;
    }
}
