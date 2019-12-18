package Mediator;

import Model.ExamList;
import Model.ExaminerList;
import Model.RoomList;
import Model.CourseList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NotepadAdapterClass
{

    public void saveExamList(ExamList toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\examList.txt";
        File file = new File(filename);

        String convert = gson.toJson(toSave);
        System.out.println(convert);

        PrintWriter out = new PrintWriter(file);

        out.println(convert);
        out.flush();
        out.close();

        System.out.println("End writing data to file: " + file.getAbsolutePath());
    }

    public void saveRoomList(RoomList toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\roomList.txt";
        File file = new File(filename);

        String convert = gson.toJson(toSave);
        System.out.println(convert);

        PrintWriter out = new PrintWriter(file);

        out.println(convert);
        out.flush();
        out.close();

        System.out.println("End writing data to file: " + file.getAbsolutePath());
    }

    public void saveExaminerList(ExaminerList toSave) throws FileNotFoundException
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

    public void saveCourseList(CourseList toSave) throws FileNotFoundException
    {
        Gson gson = new Gson();
        String filename = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\courseList.txt";
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
        String nameOfFile = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\examList.txt";
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

    public RoomList loadRoomList()
    {
        Gson gson = new Gson();
        String nameOfFile = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\roomList.txt";
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

        RoomList newRoom = gson.fromJson(line,RoomList.class);
        System.out.println(newRoom.toString());

        return newRoom;
    }

    public ExaminerList loadExaminerList()
    {
        Gson gson = new Gson();
        String nameOfFile = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\examinerList.txt";
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

        ExaminerList newExaminer = gson.fromJson(line,ExaminerList.class);
        System.out.println(newExaminer.toString());

        return newExaminer;
    }

    public CourseList loadCourseList()
    {
        Gson gson = new Gson();
        String nameOfFile = "E:\\SEP1\\Exam-Scheduling-System-SEP1\\Notepad\\courseList.txt";
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

        CourseList newCourse = gson.fromJson(line,CourseList.class);
        System.out.println(newCourse.toString());

        return newCourse;
    }
}
