package Model;
public class Examiner
{
    private String name;
    private String phoneNumber;
    private String teacherId;
    private boolean[] availability;
    private String course;
    private boolean external;

    public Examiner(String name, String phoneNumber, String teacherId, String course, boolean external)
    {
        set(name, phoneNumber, teacherId, course, external);
    }

    public void set(String name, String phoneNumber, String teacherId, String course, boolean external)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
        for (int i=0; i<31;i++) {
            this.availability[i] = true;
        }
        this.course = course;
        this.external = external;

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public boolean isAvailable(int index)
    {
        return availability[index];
    }

    public void setAvailability(boolean availability,int index)
    {
        this.availability[index] = availability;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public boolean isExternal()
    {
        return external;
    }

    public void setExternal(boolean external)
    {
        this.external = external;
    }

    public String toString()
    {
        String s = "";
        s += "Examiner name: " + name + ", phone number: " + phoneNumber + ", id: " + teacherId +
                ", course: " + course + ", is available: " + availability + ", is external: " + external;
        return s;
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
}
