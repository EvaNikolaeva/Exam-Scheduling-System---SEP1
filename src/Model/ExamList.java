package Model;

import java.util.ArrayList;

/**
 * A class representing an exam list.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class ExamList
{
    private ArrayList<Exam> exams;

    /**
     * An empty constructor instantiating a new ArrayList of exams.
     */
    public ExamList()
    {
        this.exams = new ArrayList<>();
    }

    /**
     * Adding an exam to the list.
     *
     * @param exam the exam added
     */
    public void addExam(Exam exam)
    {
        exams.add(exam);
    }

    /**
     * Removing an exam from the list.
     *
     * @param exam the exam removed
     */
    public void removeExam(Exam exam)
    {
        exams.remove(exam);
    }

    /**
     * Getting the exam at a specific index.
     *
     * @param index the index
     * @return the exam
     */
    public Exam getExam(int index)
    {
        return exams.get(index);
    }

    /**
     * Getting the exams which take place on the same date.
     *
     * @param date the date
     * @return an ArrayList including the exams which take place on the same date
     */
    public ArrayList<Exam> getExamsByDate(MyDate date)
    {
        ArrayList<Exam> examsByDate = new ArrayList<>();
        for (int i = 0; i < exams.size(); i++)
        {
            if (exams.get(i).getDate().equals(date))
            {
                examsByDate.add(exams.get(i));
            }
        }
        return examsByDate;
    }

    /**
     * Returning all the exams in the list and all the information about them.
     * @return a string including all exams
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < exams.size(); i++)
        {
            s += exams.get(i).toString() + "/n";
        }
        return s;
    }
}
