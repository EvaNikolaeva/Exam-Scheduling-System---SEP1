package Mediator;

import Model.ExamList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Backup
{
    public void saveExamList(ExamList toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "backup.txt";
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
        String nameOfFile = "backup.txt";
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
        while(in.hasNext())        {
            line += in.nextLine();
        }
        in.close();

        ExamList newExam = gson.fromJson(line,ExamList.class);
        System.out.println(newExam.toString());

        return newExam;
    }
}
