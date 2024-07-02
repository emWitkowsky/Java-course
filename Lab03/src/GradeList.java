//package org.example.lab03;
import java.util.ArrayList;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<>();

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getMeanGrade() {
        double sum = 0.0;
        if (grades.isEmpty()) {
            return 0.0;
        } else {
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }

    public double getMaxGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        } else {
            double max = grades.get(0);
            for (double grade : grades) {
                if (grade > max) {
                    max = grade;
                }
            }
            return max;
        }
    }

    public double getMinGrade() {
        if (grades.size() == 0) {
            return 0.0;
        } else {
            double min = grades.get(0);
            for (double grade : grades) {
                if (grade < min) {
                    min = grade;
                }
            }
            return min;
        }
    }
}
