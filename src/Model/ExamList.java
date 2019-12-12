package Model;

import java.util.ArrayList;

public class ExamList
{
    private ArrayList<Exam> exams;

    public ExamList()
    {
        this.exams = new ArrayList<>();
    }

    public void addExam(Exam exam)
    {
        exams.add(exam);
    }

    public void removeExam(Exam exam)
    {
        exams.remove(exam);
    }

    public void changeExam(Exam exam)
    {

    }

    public ArrayList<Exam> getExamsByDate(MyDate date)
    {
        ArrayList<Exam> examsByDate = new ArrayList<>();
        for (int i = 0; i < exams.size(); i++)
        {
            if (exams.get(i).getCourse().equals("SDJ") || exams.get(i).getCourse().equals("SEP"))
            {
                if (exams.get(i).getFirstDate().equals(date) || exams.get(i).getSecondDate().equals(date) || exams.get(i).getThirdDate().equals(date))
                {
                    examsByDate.add(exams.get(i));
                }
            }
            else if (exams.get(i).getFirstDate().equals(date))
            {
                examsByDate.add(exams.get(i));
            }
        }
        return examsByDate;
    }

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
