package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Model {
    //todo: add model instance variables.
    CourseList courseList = new CourseList();
    ExaminerList examinerList = new ExaminerList();
    RoomList roomList = new RoomList();
    ExamList examList = new ExamList();

    public boolean validateLogin(String username, String password);



    public void saveRoom(Room room);
    public void saveExam(Exam exam) throws FileNotFoundException;
    public void deleteExam(Exam exam) throws FileNotFoundException;
    public void saveCourse(Course course);
    public void deleteCourse(Course course);
    public void saveExaminer(Examiner examiner);
    public void deleteExaminer(Examiner examiner);

    public ArrayList<Course> getDisplayableCourseList(); //just name.
    public ArrayList<Examiner> getDisplayableExaminerList();// just name and id.
    public ArrayList<Room> getDisplayableRoomList();//just name.
    public ArrayList<Exam> getDisplayableExamList();

    public void orderCourseList(); //by name
    public void orderExaminerList(); //by Id
    public void orderRoomList(); //by name

}
