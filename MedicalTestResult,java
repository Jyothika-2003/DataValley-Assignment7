/* Write a Java program that accepts a list of medical test results and returns the number of patients with results
falling within specific ranges (e.g., normal, borderline, high), and the average value for each range. */

import java.util.*;
class MedicalTestResult {
    private String patientName;
    private double resultValue;

    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }
    public String getPatientName() {
        return patientName;
    }
    public double getResultValue() {
        return resultValue;
    }
}
public class  MedicalTest {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        testResults.add(new MedicalTestResult("Patient 1", 80));
        testResults.add(new MedicalTestResult("Patient 2", 120));
        testResults.add(new MedicalTestResult("Patient 3", 90));
        testResults.add(new MedicalTestResult("Patient 4", 140));
        testResults.add(new MedicalTestResult("Patient 5", 110));
        analyzeTestResults(testResults);
    }

    public static void analyzeTestResults(List<MedicalTestResult> testResults) {
        Map<String, Integer> patientsByResultRange = new HashMap<>();
        Map<String, Double> totalResultValueByRange = new HashMap<>();
        Map<String, Integer> countByResultRange = new HashMap<>();
        double[] resultRanges = {0, 100, 150, Double.MAX_VALUE}; // Define your own ranges as needed
        for (int i = 0; i < resultRanges.length - 1; i++) {
            String rangeKey = getResultRangeLabel(resultRanges[i], resultRanges[i + 1]);
            patientsByResultRange.put(rangeKey, 0);
            totalResultValueByRange.put(rangeKey, 0.0);
            countByResultRange.put(rangeKey, 0);
        }
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();

            for (int i = 0; i < resultRanges.length - 1; i++) {
                if (value >= resultRanges[i] && value < resultRanges[i + 1]) {
                    String rangeKey = getResultRangeLabel(resultRanges[i], resultRanges[i + 1]);
                    patientsByResultRange.put(rangeKey, patientsByResultRange.get(rangeKey) + 1);
                    totalResultValueByRange.put(rangeKey, totalResultValueByRange.get(rangeKey) + value);
                    countByResultRange.put(rangeKey, countByResultRange.get(rangeKey) + 1);
                }
            }
        }
        Map<String, Double> averageValueByRange = new HashMap<>();
        for (String rangeKey : patientsByResultRange.keySet()) {
            int patients = patientsByResultRange.get(rangeKey);
            double totalValue = totalResultValueByRange.get(rangeKey);
            double averageValue = totalValue / countByResultRange.get(rangeKey);
            averageValueByRange.put(rangeKey, averageValue);
        }
        System.out.println("Medical Test Results Analysis:");
        for (String range : patientsByResultRange.keySet()) {
            System.out.println(range + ":");
            System.out.println("  Number of Patients: " + patientsByResultRange.get(range));
            System.out.println("  Average Value: " + averageValueByRange.get(range));
        }
    }
    private static String getResultRangeLabel(double lowerBound, double upperBound) {
        if (upperBound == Double.MAX_VALUE) {
            return lowerBound + " and above";
        } else {
            return lowerBound + "-" + upperBound;
        }
    }
}
