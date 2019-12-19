package Model;

/**
 * A class representing a room.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class Examiner {
    private String name;
    private String phoneNumber;
    private String teacherId;
    private boolean availability;
    private Course course;
    private boolean external;

    /**
     * Five-argument constructor instantiating a new Examiner.
     *
     * @param name        the name of the examiner
     * @param phoneNumber the phone number of the examiner
     * @param teacherId   the teacher id
     * @param course      the course the examiner is attending
     * @param external    the examiner is (not) a VIA employee
     */
    public Examiner(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        set(name, phoneNumber, teacherId, course, external);
    }

    /**
     * Setter for the examiner.
     *
     * @param name        the name of the examiner
     * @param phoneNumber the phone number of the examiner
     * @param teacherId   the teacher id
     * @param course      the course the examiner is attending
     * @param external    the examiner is (not) a VIA employee
     */
    public void set(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
        this.course = course;
        this.external = external;
        this.availability = true;
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
     * Checks if an examiner is available.
     *
     * @return true if the examiner is available. Otherwise return false.
     */
    public boolean isAvailable() {
        return availability;
    }

    /**
     * Setter for availability.
     *
     * @param availability the availability of the examiner
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Getter for course.
     *
     * @return the course the examiner is attending
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Setter for course.
     *
     * @param course the course the examiner is attending
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
        return name;
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
     * Checks if an examiner is a VIA employee
     *
     * @return true if the examiner is external. Otherwise return false.
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
