package session_11.class_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Builds a reusable employee ID index for frequent department lookups. */
public class P04EmployeeIdLookup {
    /** Each record is {employeeId, department}. Building takes O(n) time and O(n) space. */
    public static Map<String, String> buildLookup(List<String[]> records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) lookup.put(record[0], record[1]);
        return lookup;
    }

    /** Expected O(1) time per lookup; "Unknown" is returned when the ID is absent. */
    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        List<String[]> records = List.of(
            new String[] {"E245", "Finance"},
            new String[] {"E110", "Engineering"},
            new String[] {"E390", "Marketing"},
            new String[] {"E101", "Engineering"}
        );
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
