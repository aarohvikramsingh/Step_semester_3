package practiceproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }
}

public class PlacementEngine {

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            sb.append(i + 1).append(". ")
              .append(shortlistedArray[i].getName())
              .append(" (").append(shortlistedArray[i].getCompositeScore()).append(")");

            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}