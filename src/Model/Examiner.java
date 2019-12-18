package Model;
public class Examiner {
    private String name;
    private String phoneNumber;
    private String teacherId;
    private boolean availability;
    private Course course;
    private boolean external;

    public Examiner(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        set(name, phoneNumber, teacherId, course, external);
    }

    public void set(String name, String phoneNumber, String teacherId, Course course, boolean external) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
        this.course = course;
        this.external = external;
        this.availability = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String toString()
    {
        return name;
    }

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

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;

    }
}
