package Model;
public class Examiner
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String teacherId;
    private boolean availability;
    private String course;

    public Examiner(String firstName, String lastName, String phoneNumber, String teacherId, boolean availability, String course)
    {
        set(firstName, lastName, phoneNumber, teacherId, availability, course);
    }

    public void set(String firstName, String lastName, String phoneNumber, String teacherId, boolean availability, String course)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
        this.availability = true;
        this.course = course;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public boolean isAvailable()
    {
        return availability;
    }

    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public String toString()
    {
        String s = "";
        s += "Examiner name: " + firstName + " " + lastName + ", phone number: " + phoneNumber + ", id: " + teacherId +
                ", course: " + course + ", is available: " + availability;
        return s;
    }

    public boolean equals(Object obj)
    {
         if (!(obj instanceof Examiner))
         {
             return false;
         }
         Examiner other = (Examiner)obj;
         return firstName.equals(other.firstName) && lastName.equals(other.lastName) && phoneNumber.equals(other.phoneNumber)
                 && teacherId.equals(other.teacherId) && availability == other.availability && course.equals(other.course);
    }
}
