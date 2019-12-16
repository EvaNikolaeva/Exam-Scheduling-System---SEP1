package Model;

import java.util.ArrayList;

public class ModelManager implements Model {
    @Override
    public boolean validateLogin(String username, String password) {
        if(username.equals("admin")&&password.equals("admin")){
            return true;
        }
        return false;
    }

    @Override
    public void saveExam() {

    }


    @Override
    public void deleteExam(int index) {

    }

    @Override
    public void saveCourse() {

    }



    @Override
    public void deleteCourse(int index) {

    }

    @Override
    public void saveExaminer(String Name, String phoneNumber, String Id,Course Course) {

    }

    @Override
    public void deleteExaminer(int index) {

    }

    @Override
    public ArrayList<Course> getDisplayableCourseList() {
        ArrayList<Course> a = new ArrayList();
        for (int i=0; courseList.)
        courseList.
        return null;
    }

    @Override
    public ArrayList<Examiner> getDisplayableExaminerList() {
        return null;
    }

    @Override
    public ArrayList<Room> getDisplayableRoomList() {
        return null;
    }

    @Override
    public void orderCourseList() {

    }

    @Override
    public void orderExaminerList() {

    }

    @Override
    public void orderRoomList() {

    }

}
