package Model;

import Adapters.NotepadAdapterClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ModelManager implements Model {

    private NotepadAdapterClass note = new NotepadAdapterClass();


    @Override
    public boolean validateLogin(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    @Override
    public void saveRoom(Room room) {
        roomList.addRoom(room);
        System.out.println(roomList.getRoomByIndex(0));
        //orderRoomList();

    }

    //----------------Course----------------------------------------------
    @Override
    public void saveCourse(Course course) {
        courseList.addCourse(course);
        orderCourseList();

    }

    @Override
    public void deleteCourse(Course course) {
        courseList.removeCourse(course);

    }

    //----------------Exam-------------------------------------------------

    @Override
    public void deleteExam(Exam exam) throws FileNotFoundException
    {
        examList.removeExam(exam);
        note.saveExamList(examList);
    }

    @Override
    public void saveExam(Exam exam) throws FileNotFoundException
    {
        examList.addExam(exam);
        note.saveExamList(examList);
    }

    //---------------Examiner-----------------------------------------------

    @Override
    public void saveExaminer(Examiner examiner) {
        examinerList.addExaminer(examiner);
        orderExaminerList();
    }

    @Override
    public void deleteExaminer(Examiner examiner) {
        examinerList.removeExaminer(examiner);
    }


    //-----------------Get Lists-------------------------------------------
    @Override
    public ArrayList<Course> getDisplayableCourseList() {
        if(courseList!=null) {
            ArrayList<Course> a = new ArrayList();
            for (int i = 0; courseList.getSize() < i; i++) {
                a.add(courseList.getCourse(i));
            }
            return a;
        }else {
            return new ArrayList<Course>();
        }
    }

    @Override
    public ArrayList<Examiner> getDisplayableExaminerList() {
        if (examList!=null) {
            ArrayList<Examiner> a = new ArrayList();
            for (int i = 0; examinerList.getSize() < i; i++) {
                a.add(examinerList.getExaminer(i));
            }
            return a;
        }else {
            return new ArrayList<Examiner>();
        }
    }

    @Override
    public ArrayList<Room> getDisplayableRoomList() {
        if (roomList.getSize()!=0) {
            ArrayList<Room> a = new ArrayList();
            for (int i = 0; roomList.getSize() < i; i++) {
                a.add(roomList.getRoomByIndex(i));
            }
            return a;
        }else  {
            return new ArrayList<Room>();
        }
    }

    @Override
    public ArrayList<Exam> getDisplayableExamList() {
        return null;
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
        Collections.sort(arrayList, compareByName);
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
        ArrayList arrayList = getDisplayableExaminerList();
        Collections.sort(arrayList, compareByNumber);
        roomList.setAll(arrayList);

    }

}
