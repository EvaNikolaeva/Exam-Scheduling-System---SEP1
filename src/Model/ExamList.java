package Model;

import Adapters.Backup;
import Adapters.NotepadAdapterClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamList
{
    private ArrayList<Exam> exams;
    private NotepadAdapterClass saver;
    private Backup backup;

    public ExamList()
    {
        this.exams = new ArrayList<>();
        this.saver = new NotepadAdapterClass();
        this.backup = new Backup();
        exams = saver.loadExamList();
        exams = backup.loadExamList();
    }

    public void addExam(Exam exam) //the adapter saves the newly-added exam to the arraylist after the new exam has been
            //added, meaning it updates automatically - Eva
    {
        exams.add(exam);
        try
        {
            saver.saveExamList(exams);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            backup.saveExamList(exams);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void removeExam(Exam exam) //same thing for here and getExam
    {
        exams.remove(exam);
        try
        {
            saver.saveExamList(exams);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            backup.saveExamList(exams);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
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
