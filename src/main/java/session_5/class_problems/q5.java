package session_5.class_problems;

import java.util.Arrays;

public class q5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }

        private double getCompositeScore() {
            return cgpa * 10 + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }

        @Override
        public String toString() {
            return name + " " + cgpa + " " + codingScore
                    + " " + getCompositeScore();
        }
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
                new Candidate("Alice", 8.5, 85),
                new Candidate("Bob", 7.2, 90),
                new Candidate("Charlie", 9.0, 80)
        };

        Arrays.sort(candidates);

        for (Candidate c : candidates) {
            System.out.println(c);
        }
    }
}