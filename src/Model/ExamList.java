package Model;

import Adapters.Backup;
import Adapters.NotepadAdapterClass;

import java.io.FileNotFoundException;
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

    public Exam getExam(int index)
    {
        return exams.get(index);
    }

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
