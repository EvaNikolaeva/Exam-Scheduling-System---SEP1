package Mediator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Model.*;

public interface Model {
    //todo: add model instance variables.
    CourseList courseList = new CourseList();
    ExaminerList examinerList = new ExaminerList();
    RoomList roomList = new RoomList();
    ExamList examList = new ExamList();

    public boolean validateLogin(String username, String password);



    public void saveRoom(Room room) throws FileNotFoundException;
    public void deleteRoom(Room room) throws FileNotFoundException;

    public void saveExam(Exam exam) throws FileNotFoundException;
    public void deleteExam(Exam exam) throws FileNotFoundException;

    public void saveCourse(Course course) throws FileNotFoundException;
    public void deleteCourse(Course course) throws FileNotFoundException;
    public void saveExaminer(Examiner examiner) throws FileNotFoundException;
    public void deleteExaminer(Examiner examiner) throws FileNotFoundException;

    public ArrayList<Course> getDisplayableCourseList(); //just name.
    public ArrayList<Examiner> getDisplayableExaminerList();// just name and id.
    public ArrayList<Room> getDisplayableRoomList();//just name.
    public ArrayList<Exam> getDisplayableExamList();

    public void orderCourseList(); //by name
    public void orderExaminerList(); //by Id
    public void orderRoomList(); //by name

}
