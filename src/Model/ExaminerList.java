package Model;

import java.util.ArrayList;

/**
 * A class representing an examiner list.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class ExaminerList
{
    private ArrayList<Examiner> examiners;

    /**
     * An empty constructor instantiating a new ArrayList of examiners.
     */
    public ExaminerList()
    {
        this.examiners = new ArrayList<>();
    }

    /**
     * Adding an examiner to the list.
     *
     * @param examiner the examiner added
     */
    public void addExaminer(Examiner examiner)
    {
        examiners.add(examiner);
    }

    /**
     * Removing an examiner from the list.
     *
     * @param examiner the examiner removed
     */
    public void removeExaminer(Examiner examiner)
    {
        examiners.remove(examiner);
    }

    /**
     * Getting the examiners by the course.
     *
     * @param course the course
     * @return an ArrayList including every examiner suitable to attend an exam for a specific course
     */
    public ArrayList<Examiner> getExaminersByCourse(String course)
    {
        ArrayList<Examiner> examinersByCourse = new ArrayList<>();
        for (int i = 0; i < examiners.size(); i++)
        {
            if (examiners.get(i).getCourse().equals(course))
            {
                examinersByCourse.add(examiners.get(i));
            }
        }
        return examinersByCourse;
    }

    /**
     * Getting the available examiners.
     *
     * @param availability the availability
     * @return an ArrayList including every examiner who is available
     */
    public ArrayList<Examiner> seeAvailableExaminers(boolean availability)
    {
        ArrayList<Examiner> availableExaminers = new ArrayList<>();
        for (int i = 0; i < examiners.size(); i++)
        {
            if (examiners.get(i).isAvailable(i) == true)
            {
                availableExaminers.add(examiners.get(i));
            }
        }
        return availableExaminers;
    }

    /**
     * Returning all the examiners in the list and all the information about them.
     * @return a string including all examiners
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < examiners.size(); i++)
        {
            s += examiners.get(i).toString() + ", ";
        }
        return s;
    }

    /**
     * Getting the size of the list.
     *
     * @return an integer representing how many examiners there are
     */
    public int getSize() {
        return examiners.size();
    }

    /**
     * Getting the examiner at a specific index.
     *
     * @param i the index
     * @return the examiner
     */
    public Examiner getExaminer(int i) {
        return examiners.get(i);
    }

    /**
     * Setter for the list.
     *
     * @param arrayList the new list of examiners
     */
    public void setAll(ArrayList arrayList) {
        this.examiners= arrayList;
    }
}
