package Model;

public interface Model {
    //todo: add model instance variables.
    public boolean validateLogin(String username, String password);
    public void saveExam();
    public void editExam(int index);
    public void deleteExam(int index);
    public void saveCourse();
    public void editCourse();
    public void deleteCourse(int index);
    public void saveExaminer();
    public void editExaminer();
    public void deleteExaminer(int index);

}
