package lt.codeacademy;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

public class ExternalMarksDao implements MarksDao {

    @Override
    public List<Integer> getMarks() {
        return Collections.emptyList();
    }
}
