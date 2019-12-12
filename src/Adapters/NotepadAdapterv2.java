package Adapters;

import Model.Examiner;
import Model.ExaminerList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadAdapterv2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "examinerList.txt";
        File file = new File(filename);

        Examiner one = new Examiner("Steffen", "Andersen",
                "981234", "1234", true, "SDJ");
        Examiner two = new Examiner("Line", "Egsgaard",
                "123957", "2345", true, "RWD");
        Examiner three = new Examiner("Lars", "Bjornen",
                "018234", "3456", true, "MSE");
        ExaminerList firstSem = new ExaminerList();
        firstSem.addExaminer(one);
        firstSem.addExaminer(two);
        firstSem.addExaminer(three);

        String convert = gson.toJson(firstSem);
        System.out.println(convert);

        PrintWriter out = new PrintWriter(file);

        out.println(convert);
        out.flush();
        out.close();

        System.out.println("End writing data to file: " + file.getAbsolutePath());

        ////////////Reading

        String nameOfFile = "examinerList.txt";
        File readingFile = new File(nameOfFile);
        Scanner in = new Scanner(readingFile);

        String line = new String();
        while(in.hasNext())
        {
            line += in.nextLine();
        }
        in.close();

        ExaminerList newExam = gson.fromJson(line,ExaminerList.class);
        System.out.println(newExam.toString());
    }
}
