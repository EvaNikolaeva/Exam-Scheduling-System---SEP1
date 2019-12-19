package Mediator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import Model.*;

public interface Model {



    public boolean validateLogin(String username, String password);



    public void saveRoom(Room room) throws IOException;
    public void deleteRoom(Room room) throws IOException;

    public void saveExam(Exam exam) throws IOException;
    public void deleteExam(Exam exam) throws IOException;

    public void saveCourse(Course course) throws IOException;
    public void deleteCourse(String course) throws IOException;
    public void saveExaminer(Examiner examiner) throws IOException;
    public void deleteExaminer(Examiner examiner) throws IOException;

    public ArrayList<Course> getDisplayableCourseList(); //just name.
    public ArrayList<Examiner> getDisplayableExaminerList();// just name and id.
    public ArrayList<Room> getDisplayableRoomList();//just name.
    public ArrayList<Exam> getDisplayableExamList();

    public void orderCourseList(); //by name
    public void orderExaminerList(); //by Id
    public void orderRoomList(); //by name

    public void loadingExamList() throws IOException;
    public void loadingRoomList() throws IOException;
    public void loadingExaminerList() throws IOException;
    public void loadingCourseList() throws IOException;

}
