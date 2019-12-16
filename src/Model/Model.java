package Model;

import java.util.ArrayList;

public interface Model {
    //todo: add model instance variables.
    CourseList courseList = null;
    ExaminerList examinerList = null;
    RoomList roomList = null;

    public boolean validateLogin(String username, String password);
    public void saveExam();
    public void deleteExam(int index);
    public void saveCourse();
    public void deleteCourse(int index);
    public void saveExaminer(String Name, String phoneNumber, String Id,Course Course);
    public void deleteExaminer(int index);

    public ArrayList<Course> getDisplayableCourseList(); //just name.
    public ArrayList<Examiner> getDisplayableExaminerList();// just name and id.
    public ArrayList<Room> getDisplayableRoomList();//just name.

    public void orderCourseList(); //by name
    public void orderExaminerList(); //by Id
    public void orderRoomList(); //by name

}
