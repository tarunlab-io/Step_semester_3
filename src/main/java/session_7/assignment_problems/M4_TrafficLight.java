package session_7.assignment_problems;

public class M4_TrafficLight {

    static class TrafficLight {

        private String color;
        private final String id;

        // Constructor
        TrafficLight(String id) {
            this.id = id;
            this.color = "RED";
        }

        // Move to next color
        void next() {

            if (color.equals("RED")) {
                color = "GREEN";
            }
            else if (color.equals("GREEN")) {
                color = "YELLOW";
            }
            else {
                color = "RED";
            }
        }

        // Read-only color
        String getColor() {
            return color;
        }

        // Read-only ID
        String getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        TrafficLight t =
            new TrafficLight("TL-9");

        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}