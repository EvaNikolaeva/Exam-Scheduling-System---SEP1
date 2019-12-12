package Adapters;

import Model.ExamList;
import Model.ExaminerList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadAdapterClass
{

    public void saveExamList(ExamList toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "adapter.txt";
        File file = new File(filename);

        String convert = gson.toJson(toSave);
        System.out.println(convert);

        PrintWriter out = new PrintWriter(file);

        out.println(convert);
        out.flush();
        out.close();

        System.out.println("End writing data to file: " + file.getAbsolutePath());
    }

    public ExamList loadExamList()
    {
        Gson gson = new Gson();
        String nameOfFile = "adapter.txt";
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

        ExamList newExam = gson.fromJson(line,ExamList.class);
        System.out.println(newExam.toString());

        return newExam;
    }
}
