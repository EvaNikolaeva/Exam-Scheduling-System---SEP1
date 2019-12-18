package Model;

/**
 * A class representing an Examiner.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class Examiner {
    private String name;
    private String phoneNumber;
    private String teacherId;
    private boolean[] availability;
    private Course course;
    private boolean external;

    /**
     * Five-argument constructor instantiating a new Examiner.
     *
     * @param name        the name of the examiner
     * @param phoneNumber the phone number of the examiner
     * @param teacherId   the teacher id
     * @param course      the course the teacher will examine
     * @param external    the examiner is (not) a VIA employee
     */
    public Examiner(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        set(name, phoneNumber, teacherId, course, external);
    }

    /**
     * Five-argument constructor instantiating a new Room.
     *
     * @param name        the name of the examiner
     * @param phoneNumber the phone number of the examiner
     * @param teacherId   the teacher id
     * @param course      the course the teacher will examine
     * @param external    the examiner is (not) a VIA employee
     */
    public void set(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
        for (int i = 0; i < 31; i++) {
            this.availability[i] = true;
        }
        this.course = course;
        this.external = external;

    }

    /**
     * Getter for name.
     *
     * @return the name of the examiner
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name the name of the examiner
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for phone number.
     *
     * @return the phone number of the examiner
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phone number.
     *
     * @param phoneNumber the phone number of the examiner
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for teacher id.
     *
     * @return the teacher id
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * Setter for teacher id.
     *
     * @param teacherId the teacher id
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * Returning if an examiner is available or not on a specific day.
     *
     * @param index the day
     * @return true if the examiner is available. Otherwise return false.
     */
    public boolean isAvailable(int index) {
        return availability[index];
    }

    /**
     * Setter for availability.
     *
     * @param availability the availability
     * @param index        the day
     */
    public void setAvailability(boolean availability, int index) {
        this.availability[index] = availability;
    }

    /**
     * Getter for course
     *
     * @return the course the teacher will examine
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Setter for course.
     *
     * @param course the course the teacher will examine
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Returning the information about an examiner.
     * @return a string including information about an examiner
     */
    public String toString()
    {
        String s = "";
        s += name +" "+course;
        return s;
    }

    /**
     * Returning if two examiners are the same.
     * @param obj the examiner compared to
     * @return true if the examiners are identical. Otherwise return false.
     */
    public boolean equals(Object obj)
    {
         if (!(obj instanceof Examiner))
         {
             return false;
         }
         Examiner other = (Examiner)obj;
         return name.equals(other.name) && phoneNumber.equals(other.phoneNumber)
                 && teacherId.equals(other.teacherId) && availability == other.availability && course.equals(other.course)
                 && external == other.external;
    }

    /**
     * Checks if an examiner is external or not.
     *
     * @return true if the examiner is not a VIA employee. Otherwise return false.
     */
    public boolean isExternal() {
        return external;
    }

    /**
     * Setter for external.
     *
     * @param external the examiner is (not) a VIA employee
     */
    public void setExternal(boolean external) {
        this.external = external;

    }
}
