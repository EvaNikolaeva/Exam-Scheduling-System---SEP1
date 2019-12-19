package Mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.CourseList;
import Model.RoomList;
import Model.ExaminerList;
import Model.ExamList;


import Model.*;

public class ModelManager implements Model {
    private CourseList courseList ;
    private ExaminerList examinerList ;
    private RoomList roomList ;
    private ExamList examList ;

    private ExamSchedulingFile note;

    public ModelManager() throws IOException
    {
        note = new ExamSchedulingFile();

        courseList = new CourseList();
        examinerList = new ExaminerList();
        roomList = new RoomList();
        examList = new ExamList();

        courseList = note.loadCourseList();
        examinerList = note.loadExaminerList();
        roomList = note.loadRoomList();
        examList = note.loadExamList();
    }



    @Override
    public boolean validateLogin(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
    //-------------Room--------------------------------------------------
    @Override
    public void saveRoom(Room room) throws IOException
    {
        roomList.addRoom(room);
        orderRoomList();
        note.saveRoomList(roomList);
    }

    @Override
    public void deleteRoom(Room room) throws IOException
    {
        roomList.removeRoom(room);
        note.saveRoomList(roomList);
    }

    //----------------Course----------------------------------------------
    @Override
    public void saveCourse(Course course) throws IOException
    {
        courseList.addCourse(course);
        orderCourseList();
        note.saveCourseList(courseList);
    }

    @Override
    public void deleteCourse(String course) throws IOException
    {
        courseList.removeCourse(course);
        note.saveCourseList(courseList);
    }

    //----------------Exam-------------------------------------------------

    @Override
    public void deleteExam(Exam exam) throws IOException
    {
        examList.removeExam(exam);
        note.saveExamList(examList);
    }

    @Override
    public void saveExam(Exam exam) throws IOException
    {
        examList.addExam(exam);
        note.saveExamList(examList);
    }

    //---------------Examiner-----------------------------------------------

    @Override
    public void saveExaminer(Examiner examiner) throws IOException
    {
        examinerList.addExaminer(examiner);
        orderExaminerList();
        note.saveExaminerList(examinerList);
    }

    @Override
    public void deleteExaminer(Examiner examiner) throws IOException
    {
        examinerList.removeExaminer(examiner);
        note.saveExaminerList(examinerList);
    }


    //-----------------Get Lists-------------------------------------------
    @Override
    public ArrayList<Course> getDisplayableCourseList() {
        return courseList.getCourses();
    }

    @Override
    public ArrayList<Examiner> getDisplayableExaminerList() {
        return examinerList.getExaminers();
    }

    @Override
    public ArrayList<Room> getDisplayableRoomList() {
        return roomList.getRooms();
    }

    @Override
    public ArrayList<Exam> getDisplayableExamList() {
        return examList.getExams();
    }

    //---------------------Order Lists--------------------------------------

    @Override
    public void orderCourseList() {
        Comparator<Course> compareByName = (Comparator<Course>) (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        };
        ArrayList arrayList = getDisplayableCourseList();
        Collections.sort(arrayList, compareByName);
        courseList.setAll(arrayList);
    }

    @Override
    public void orderExaminerList() {
        Comparator<Examiner> compareByName = new Comparator<Examiner>() {
            @Override
            public int compare(Examiner o1, Examiner o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        ArrayList arrayList = getDisplayableExaminerList();
        arrayList.sort(compareByName);
        examinerList.setAll(arrayList);

    }

    @Override
    public void orderRoomList() {
        Comparator<Room> compareByNumber = new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getRoom().compareTo(o2.getRoom());
            }
        };
        ArrayList arrayList = getDisplayableRoomList();
        arrayList.sort(compareByNumber);
        roomList.setAll(arrayList);

    }

    //------------------Loading all lists------------------------------------
    @Override
    public void loadingExamList() throws IOException
    {
        examList =  note.loadExamList();
    }

    @Override
    public void loadingRoomList() throws IOException
    {
        roomList = note.loadRoomList();
    }

    @Override
    public void loadingExaminerList() throws IOException
    {
        examinerList = note.loadExaminerList();
    }

    @Override
    public void loadingCourseList() throws IOException
    {
        courseList = note.loadCourseList();
    }


}
