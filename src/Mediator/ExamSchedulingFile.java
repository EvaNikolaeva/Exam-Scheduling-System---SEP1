package Mediator;

import Model.ExamList;
import Model.ExaminerList;
import Model.RoomList;
import Model.CourseList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadAdapterClass
{

    public void saveExamList(ExamList toSave) throws IOException
    {
        String filename = "Notepad\\examList.txt";
        File file = new File(filename);
        try{
            Gson gson = new Gson();

            String convert = gson.toJson(toSave);
            System.out.println(convert);

            PrintWriter out = new PrintWriter(file);

            out.println(convert);
            out.flush();
            out.close();

            System.out.println("End writing data to file: " + file.getAbsolutePath());
        }
        catch(FileNotFoundException e){
            file.createNewFile();
        }
    }

    public void saveRoomList(RoomList toSave) throws IOException
    {
        String filename = "Notepad\\roomList.txt";
        File file = new File(filename);
        try{
            Gson gson = new Gson();


            String convert = gson.toJson(toSave);
            System.out.println(convert);

            PrintWriter out = new PrintWriter(file);

            out.println(convert);
            out.flush();
            out.close();

            System.out.println("End writing data to file: " + file.getAbsolutePath());
        }
        catch(FileNotFoundException e){
            file.createNewFile();
        }
    }

    public void saveExaminerList(ExaminerList toSave) throws IOException
    {
        String filename = "Notepad\\examinerList.txt";
        File file = new File(filename);
        try{
            Gson gson = new Gson();

            String convert = gson.toJson(toSave);
            System.out.println(convert);

            PrintWriter out = new PrintWriter(file);

            out.println(convert);
            out.flush();
            out.close();

            System.out.println("End writing data to file: " + file.getAbsolutePath());
        }
        catch(FileNotFoundException e){
            file.createNewFile();
        }
    }

    public void saveCourseList(CourseList toSave) throws IOException
    {
        String filename = "Notepad\\courseList.txt";
        File file = new File(filename);
        try
        {
            Gson gson = new Gson();

            String convert = gson.toJson(toSave);
            System.out.println(convert);

            PrintWriter out = new PrintWriter(file);

            out.println(convert);
            out.flush();
            out.close();

            System.out.println("End writing data to file: " + file.getAbsolutePath());
        }
        catch (FileNotFoundException e)
        {
            file.createNewFile();
        }
    }

    public ExamList loadExamList() throws IOException
    {
        Gson gson = new Gson();
        String nameOfFile = "Notepad\\examList.txt";
        File readingFile = new File(nameOfFile);
        readingFile.createNewFile();
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

        if(newExam == null){
            newExam = new ExamList();
        }

        return newExam;
    }

    public RoomList loadRoomList() throws IOException
    {
        Gson gson = new Gson();
        String nameOfFile = "Notepad\\roomList.txt";
        File readingFile = new File(nameOfFile);
        readingFile.createNewFile();
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

        if(newRoom == null){
            newRoom = new RoomList();
        }

        return newRoom;
    }

    public ExaminerList loadExaminerList() throws IOException
    {
        Gson gson = new Gson();
        String nameOfFile = "Notepad\\examinerList.txt";
        File readingFile = new File(nameOfFile);
        readingFile.createNewFile();
        Scanner in = null;
        try
        {
            in = new Scanner(readingFile);
        } catch (FileNotFoundException e)
        {

        }

        String line = "";
        while(in.hasNext())
        {
            line += in.nextLine();
        }
        in.close();

        ExaminerList newExaminer = gson.fromJson(line,ExaminerList.class);

        if(newExaminer == null){
            newExaminer = new ExaminerList();
        }

        return newExaminer;
    }

    public CourseList loadCourseList() throws IOException
    {
        Gson gson = new Gson();
        String nameOfFile = "Notepad\\courseList.txt";
        File readingFile = new File(nameOfFile);
        readingFile.createNewFile();
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

        if(newCourse == null){
            newCourse = new CourseList();
        }

        return newCourse;
    }
}
