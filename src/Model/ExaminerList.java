package Model;

import java.util.ArrayList;

public class ExaminerList
{
    private ArrayList<Examiner> examiners;

    public ExaminerList()
    {
        this.examiners = new ArrayList<>();
    }

    public void addExaminer(Examiner examiner)
    {
        examiners.add(examiner);
    }

    public void removeExaminer(Examiner examiner)
    {
        examiners.remove(examiner);
    }

    public ArrayList<Examiner> getExaminersByCourse(String course)
    {
        ArrayList<Examiner> examinersByCourse = new ArrayList<>();
        for (int i = 0; i < examiners.size(); i++)
        {
            if (examiners.get(i).getCourse().equals(course))
            {
                examinersByCourse.add(examiners.get(i));
            }
        }
        return examinersByCourse;
    }

    public ArrayList<Examiner> seeAvailableExaminers(boolean availability)
    {
        ArrayList<Examiner> availableExaminers = new ArrayList<>();
        for (int i = 0; i < examiners.size(); i++)
        {
            if (examiners.get(i).isAvailable(i) == true)
            {
                availableExaminers.add(examiners.get(i));
            }
        }
        return availableExaminers;
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < examiners.size(); i++)
        {
            s += examiners.get(i).toString() + ", ";
        }
        return s;
    }

    public int getSize() {
        return examiners.size();
    }

    public Examiner getExaminer(int i) {
        return examiners.get(i);
    }

    public void setAll(ArrayList arrayList) {
        this.examiners= arrayList;
    }
}
