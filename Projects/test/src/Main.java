
import blatt02.Pair;
import blatt03.GradeOverview;
import sokoban.Directions;
import sokoban.Sokoban;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/** Main class. */
public class Main {

    /** Run tests. */
    public static void main(String[] args) {
        /* Aufgabe02
       List<Pair<Integer, String>> list = new ArrayList<>();

       list.add(new Pair(0, "Hello"));
       list.add(new Pair(0, "Hello"));
       list.add(new Pair(4, "おはいよ"));
       list.add(new Pair(2, "私わ　Felix です"));
       list.add(new Pair(69, "Hello"));
       list.add(new Pair(89, "なに"));
       list.add(new Pair(56, "おはいよ"));
       list.add(new Pair(2, "水"));

        Collections.sort(list);

        HashSet<Pair<Integer, String>> hashSet = new HashSet<>();
        list.forEach((p) -> {
            if(!hashSet.contains(p)){
                hashSet.add(p);
            }else System.out.println(p.toString());
        });


        char [][] sokoban = new char [7][];
        sokoban [0] = "#######" . toCharArray ();
        sokoban [1] = "#.....#" . toCharArray ();
        sokoban [2] = "#..$..#" . toCharArray ();
        sokoban [3] = "#.$@$.#" . toCharArray ();
        sokoban [4] = "#..$..#" . toCharArray ();
        sokoban [5] = "#.....#" . toCharArray ();
        sokoban [6] = "#######" . toCharArray ();
        */

        //aufgabe 03

        GradeOverview go = new GradeOverview();
        go.addTestResult("Japanese", new Pair(2.3, 6));
        go.addTestResult("PvS", new Pair(1.9, 8));
        go.addTestResult("Labor", new Pair(2.0, 6));
        go.addTestResult("PdP", new Pair(2.5, 8));

        System.out.println(go.currentECTS());
        System.out.println(go.getExamResults("Japanese"));
        System.out.println(go.totalGradeAverage());




    }
}

