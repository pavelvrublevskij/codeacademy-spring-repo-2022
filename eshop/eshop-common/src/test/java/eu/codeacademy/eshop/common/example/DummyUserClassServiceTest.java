package eu.codeacademy.eshop.common.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DummyUserClassServiceTest {

    @Test
    void save() {
        DummyUserClassService dummyUserClassService = new DummyUserClassService();
        User user = new User("Antanas", 20);

        Assertions.assertThrows(RuntimeException.class, () -> dummyUserClassService.save(user));
    }
}
