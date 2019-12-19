package Model;

import java.util.ArrayList;

/**
 * A class representing a course list.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class CourseList
{
    private ArrayList<Course> courses;

    /**
     * An empty constructor instantiating a new ArrayList of courses.
     */
    public CourseList()
    {
        this.courses = new ArrayList<>();
    }

    /**
     * Getter for courses.
     *
     * @return an ArrayList including all courses
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

    /**
     * Setter for the list.
     *
     * @param newCourses the new list of courses
     */
    public void setAll(ArrayList<Course> newCourses){
        this.courses= newCourses;
    }

    /**
     * Adding a course to the list.
     *
     * @param course the course added
     */
    public void addCourse(Course course)
    {
        courses.add(course);
    }

    /**
     * Removing a course from the list.
     *
     * @param name the course removed
     */
    public void removeCourse(String name)
    {
        for(int i =0; i < courses.size();i++){
            if(courses.get(i).getName().equals(name)){
                courses.remove(i);
            }
        }
    }

    /**
     * Getting the course at a specific index.
     *
     * @param index the index
     * @return the course
     */
    public Course getCourse(int index)
    {
        return courses.get(index);
    }

    /**
     * Getting the size of the list.
     *
     * @return an integer representing how many courses there are
     */
    public int getSize(){
        return courses.size();
    }

    /**
     * Returning all the courses in the list and all the information about them.
     * @return a string including all courses
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < courses.size(); i++)
        {
            s += courses.get(i).toString() + "/n";
        }
        return s;
    }
}
