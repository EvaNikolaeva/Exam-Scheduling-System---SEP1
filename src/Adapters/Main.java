package Adapters;

import Model.*;

import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        NotepadAdapterClass note = new NotepadAdapterClass();

        MyDate sdjDate = new MyDate(13, 1, 2020);
        Equipment roomEq = new Equipment(true, true, 30, 10);
        Examiner steffen = new Examiner("Steffen", "Andersen", "09876",
                "1234", true, "SDJ");
        Room sdjRoom = new Room(roomEq, "E301", true);
        Exam sdj = new Exam(sdjDate, "SDJ", "1", "Oral", sdjRoom, steffen);
        
        ExamList thisDate = new ExamList();
        thisDate.addExam(sdj);

        try
        {
            note.saveExamList(thisDate);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
