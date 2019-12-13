package Adapters;

import Model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        NotepadAdapterClass note = new NotepadAdapterClass();

        MyDate date = new MyDate(10, 1, 2020);
        Equipment eq = new Equipment(true ,true, 10, 10);
        Room room = new Room(eq, "A201", true);
        Examiner line = new Examiner("Line", "Egsgaard", "0987", "1234", true, "RWD");
        Exam rwd = new Exam(date, "RWD", "1", "Written", room, line);

        ArrayList<Exam> one = new ArrayList<>();
        one.add(rwd);

        note.saveExamList(one);
    }
}
