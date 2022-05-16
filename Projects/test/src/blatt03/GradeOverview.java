package blatt03;

import blatt02.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class GradeOverview {

    private final HashMap<String, Pair<Double, Integer>>  GRADEOVERVIEW = new HashMap<>();

    public GradeOverview(){}

    public double totalGradeAverage(){
        double avrg = 0;

        List<Double> list = new ArrayList<>();

        GRADEOVERVIEW.forEach((v1, v2) -> list.add(v2.getFirst()));

        for(double d : list){
            avrg += d;
        }


        return avrg / list.size();

    }

    public Optional<Pair<Double, Integer>> getExamResults(String lectureName){
        if(!GRADEOVERVIEW.containsKey(lectureName)){
            throw new IndexOutOfBoundsException("lecture does not exist");
        }
        return Optional.of(GRADEOVERVIEW.get(lectureName));
    }

    public int currentECTS(){
        List<Integer> allLps = new ArrayList<>();
        GRADEOVERVIEW.forEach((str, pair) -> allLps.add(pair.getSecond()));
        int sum = 0;
        for(int i : allLps){
            sum += i;
        }

        return sum;
    }

    public Pair<Double, Integer> addTestResult(String lectureName, Pair<Double, Integer> gradeAndECTS){
        GRADEOVERVIEW.put(lectureName, gradeAndECTS);
        return GRADEOVERVIEW.get(lectureName);
    }
}
