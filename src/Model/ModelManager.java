package Model;

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
    public void editExam(int index) {

    }

    @Override
    public void deleteExam(int index) {

    }

    @Override
    public void saveCourse() {

    }

    @Override
    public void editCourse() {

    }

    @Override
    public void deleteCourse(int index) {

    }

    @Override
    public void saveExaminer() {

    }

    @Override
    public void editExaminer() {

    }

    @Override
    public void deleteExaminer(int index) {

    }

}
