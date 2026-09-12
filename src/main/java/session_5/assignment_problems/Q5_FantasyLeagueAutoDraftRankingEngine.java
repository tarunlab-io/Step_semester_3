package session_5.assignment_problems;

import java.util.Arrays;

public class Q5_FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(
                String name,
                int matchesPlayed,
                double battingAverage,
                boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        // Overloaded method 1
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Overloaded method 2
        static boolean isDraftable(
                int matchesPlayed,
                boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Ranking: batting average descending
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            boolean eligible;

            if (Player.isDraftable(
                    player.getMatchesPlayed())) {

                eligible = true;

            } else {

                eligible = Player.isDraftable(
                        player.getMatchesPlayed(),
                        player.isInjured());
            }

            if (eligible) {
                draftable[count] = player;
                count++;
            }
        }

        // Sort only the draftable players
        Arrays.sort(draftable, 0, count);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());

            if (i < count - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player(
                    "Virat",
                    15,
                    48.0,
                    false
            ),

            new Player(
                    "Rahul",
                    7,
                    55.0,
                    false
            ),

            new Player(
                    "Sameer",
                    3,
                    60.0,
                    false
            ),

            new Player(
                    "Dev",
                    12,
                    20.0,
                    true
            )
        };

        System.out.println(
                draftAndRank(players)
        );
    }
}