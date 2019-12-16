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
        Course course = new Course("RWD1X", "Written", 35);
        Examiner line = new Examiner("Line Egsgaard", "23569641", "1234",  "RWD");
        Exam rwd = new Exam(date, course, room, line);

        ArrayList<Exam> one = new ArrayList<>();
        one.add(rwd);

        note.saveExamList(one);
    }
}
