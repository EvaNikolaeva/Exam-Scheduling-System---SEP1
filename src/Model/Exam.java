package Model;

/**
 *  A class representing an Examiner.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class Exam
{
    private MyDate date;
    private Course course;
    private Examiner examiner1;
    private Examiner examiner2;
    private Room room;

    /**
     * Five-argument constructor instantiating a new Examiner.
     *
     * @param date      the date of the exam
     * @param course    the course
     * @param room      the room
     * @param examiner1 the first examiner
     * @param examiner2 the second examiner
     */
    public Exam(MyDate date, Course course, Room room, Examiner examiner1, Examiner examiner2)
    {
        setAll(date, course, room, examiner1, examiner2);
    }

    /**
     * Getter for date.
     *
     * @return the date of the exam
     */
    public MyDate getDate()
    {
        return date;
    }

    /**
     * Setter for date.
     *
     * @param date the date of the exam
     */
    public void setDate(MyDate date)
    {
        this.date = date;
    }

    /**
     * Getter for course.
     *
     * @return the course
     */
    public Course getCourse()
    {
        return course;
    }

    /**
     * Setter for course.
     *
     * @param course the course
     */
    public void setCourse(Course course)
    {
        this.course = course;
    }

    /**
     * Getter for first examiner.
     *
     * @return the first examiner
     */
    public Examiner getFirstExaminer()
    {
        return examiner1;
    }

    /**
     * Setter for first examiner.
     *
     * @param examiner the first examiner
     */
    public void setFirstExaminer(Examiner examiner)
    {
        this.examiner1 = examiner;
    }

    /**
     * Getter for second examiner.
     *
     * @return the second examiner
     */
    public Examiner getSecondExaminer()
    {
        return examiner2;
    }

    /**
     * Setter for second examiner.
     *
     * @param examiner the second examiner
     */
    public void setSecondExaminer(Examiner examiner)
    {
        this.examiner2 = examiner;
    }

    /**
     * Getter for room.
     *
     * @return the room
     */
    public Room getRoom()
    {
        return room;
    }

    /**
     * Setter for room.
     *
     * @param room the room
     */
    public void setRoom(Room room)
    {
        this.room = room;
    }

    /**
     * Setter for all arguments
     *
     * @param date      the date of the exam
     * @param course    the course
     * @param room      the room
     * @param examiner1 the first examiner
     * @param examiner2 the second examiner
     */
    public void setAll(MyDate date, Course course, Room room, Examiner examiner1, Examiner examiner2)
    {
        this.date = date;;
        this.course = course;
        this.room = room;
        this.examiner1 = examiner1;
        this.examiner2 = examiner2;
    }

    /**
     * Returning if two exams are the same.
     * @param obj the exam compared to
     * @return true if the exams are identical. Otherwise return false.
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Exam))
        {
            return false;
        }
        Exam other = (Exam)obj;
        return date.equals(other.date) && course.equals(other.course);
    }

    /**
     * Returning the information about an exam.
     * @return a string including information about an exam
     */
    public String toString()
    {
        String s = "";
        s +=  course + ", date: " + date + ", room: " + room + ", examiners: " + examiner1 + ", " + examiner2;
        return s;
    }
}
