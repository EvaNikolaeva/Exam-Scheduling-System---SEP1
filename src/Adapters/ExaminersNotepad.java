package Adapters;

import Model.Exam;
import Model.Examiner;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExaminersNotepad
{
    public void saveExaminerList(ArrayList<Examiner> toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\examinerList.txt";
        File file = new File(filename);

        String convert = gson.toJson(toSave);
        System.out.println(convert);

        PrintWriter out = new PrintWriter(file);

        out.println(convert);
        out.flush();
        out.close();

        System.out.println("End writing data to file: " + file.getAbsolutePath());
    }

    public ArrayList<Examiner> loadExaminerList()
    {
        Gson gson = new Gson();
        String nameOfFile = "examinerList.txt";
        File readingFile = new File(nameOfFile);

        Scanner in = null;
        try
        {
            in = new Scanner(readingFile);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String line = "";
        while(in.hasNext())
        {
            line += in.nextLine();
        }
        in.close();

        ArrayList<Examiner> newExam = gson.fromJson(line,ArrayList.class);
        System.out.println(newExam.toString());

        return newExam;
    }
}
