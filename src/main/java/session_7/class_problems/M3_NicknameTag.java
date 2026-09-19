package session_7.class_problems;

public class M3_NicknameTag {

    static class NameTag {

        private final String firstName;
        private final String lastNameInitial;

        // Constructor
        NameTag(String fullName) {

            String[] parts = fullName.split(" ");

            firstName = parts[0];
            lastNameInitial = parts[1].substring(0, 1);
        }

        // Return nickname
        String getNickname() {

            return firstName + " " +
                   lastNameInitial + ".";
        }
    }

    public static void main(String[] args) {

        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(
            tag.getNickname()
        );
    }
}