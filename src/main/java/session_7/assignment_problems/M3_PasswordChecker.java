package session_7.assignment_problems;

public class M3_PasswordChecker {

    static class PasswordChecker {

        private final String password;

        // Constructor
        PasswordChecker(String password) {
            this.password = password;
        }

        // Return only strength
        String getStrength() {

            int length = password.length();

            if (length < 6) {
                return "Weak";
            }
            else if (length <= 9) {
                return "Medium";
            }
            else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {

        PasswordChecker pc =
            new PasswordChecker("abcd");

        PasswordChecker pc2 =
            new PasswordChecker("abcdefghij");

        System.out.println(
            pc.getStrength()
        );

        System.out.println(
            pc2.getStrength()
        );
    }
}