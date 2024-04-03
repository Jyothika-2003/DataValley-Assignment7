/* Write a Java program that accepts a list of employee work hours and returns the number of employees who
worked more than 40 hours, exactly 40 hours, or less than 40 hours in a week, and the average hours worked per day for each group. */

import java.util.*;

class EmployeeWorkHours {
    private String employeeName;
    private int[] dailyHours;

    public EmployeeWorkHours(String employeeName, int[] dailyHours) {
        this.employeeName = employeeName;
        this.dailyHours = dailyHours;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public int[] getDailyHours() {
        return dailyHours;
    }
}

public class Employees  {
    public static void main(String[] args) {
        List<EmployeeWorkHours> workHoursList = new ArrayList<>();
        workHoursList.add(new EmployeeWorkHours("Employee 1", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee 2", new int[]{9, 8, 7, 8, 9}));
        workHoursList.add(new EmployeeWorkHours("Employee 3", new int[]{8, 8, 8, 8, 7}));
        workHoursList.add(new EmployeeWorkHours("Employee 4", new int[]{8, 7, 6, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee 5", new int[]{10, 10, 10, 10, 10}));
        analyzeWorkHours(workHoursList);
    }
    public static void analyzeWorkHours(List<EmployeeWorkHours> workHoursList) {
        int moreThan40Hours = 0;
        int exactly40Hours = 0;
        int lessThan40Hours = 0;
        Map<String, Double> averageHoursPerDayByGroup = new HashMap<>();
        for (EmployeeWorkHours workHours : workHoursList) {
            int totalHours = 0;
            for (int hours : workHours.getDailyHours()) {
                totalHours += hours;
            }
            double averageHoursPerDay = totalHours / (double) workHours.getDailyHours().length;
            if (totalHours > 40) {
                moreThan40Hours++;
            } else if (totalHours == 40) {
                exactly40Hours++;
            } else {
                lessThan40Hours++;
            }
            averageHoursPerDayByGroup.put("More than 40 hours", calculateAverageHours(averageHoursPerDayByGroup.getOrDefault("More than 40 hours", 0.0), moreThan40Hours, averageHoursPerDay));
            averageHoursPerDayByGroup.put("Exactly 40 hours", calculateAverageHours(averageHoursPerDayByGroup.getOrDefault("Exactly 40 hours", 0.0), exactly40Hours, averageHoursPerDay));
            averageHoursPerDayByGroup.put("Less than 40 hours", calculateAverageHours(averageHoursPerDayByGroup.getOrDefault("Less than 40 hours", 0.0), lessThan40Hours, averageHoursPerDay));
        }
        System.out.println("Work Hours Analysis:");
        System.out.println("More than 40 hours: " + moreThan40Hours + " employees");
        System.out.println("Average hours per day: " + averageHoursPerDayByGroup.get("More than 40 hours"));
        System.out.println();
        System.out.println("Exactly 40 hours: " + exactly40Hours + " employees");
        System.out.println("Average hours per day: " + averageHoursPerDayByGroup.get("Exactly 40 hours"));
        System.out.println();
        System.out.println("Less than 40 hours: " + lessThan40Hours + " employees");
        System.out.println("Average hours per day: " + averageHoursPerDayByGroup.get("Less than 40 hours"));
    }
    private static double calculateAverageHours(double previousAverage, int count, double newAverage) {
        return (previousAverage * (count - 1) + newAverage) / count;
    }
}
