package common;
import java.util.HashMap;
import java.util.Map;

public class AttendanceRecord {
    private Map<Student, Boolean> attendance = new HashMap<>();

    public void record(Student student, boolean present) {
        attendance.put(student, present);
    }

    public boolean wasPresent(Student student) {
        return attendance.getOrDefault(student, false);
    }
}
