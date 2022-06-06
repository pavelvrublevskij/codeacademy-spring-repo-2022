package eu.codeacademy.eshop.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DummyUserClassTest {

    @Mock
    private DummyUserClassService dummyUserClassService;

    @InjectMocks
    private DummyUserClass dummyUserClass;

    @Test
    public void testSaveUserThrowsException() {
        User user = new User("Antanas", 1);
        Mockito.doThrow(RuntimeException.class).when(dummyUserClassService).save(user);

        Assertions.assertThrows(RuntimeException.class, () -> dummyUserClass.saveUser());
    }

    @Test
    public void testFindUserAgeByNameWhenUserNameNotExists() {
        // given
        final String userName = "";
        Mockito.when(dummyUserClassService.getUseAgeByName(userName)).thenReturn(0);

        // when
        int age = dummyUserClass.findUserAgeByName(userName);

        // then
        Assertions.assertEquals(0, age, "User does not exist");
    }

    @Test
    public void testFindUserAgeByNameWhenUserNameExists() {
        // given
        Mockito.when(dummyUserClassService.getUseAgeByName("userName")).thenReturn(87);

        // when
        int age = dummyUserClass.findUserAgeByName("userName");

        // then
        Assertions.assertEquals(87, age);
        Mockito.verify(dummyUserClassService, Mockito.times(1)).getUseAgeByName(ArgumentMatchers.anyString());
//        verify(dummyUserClassService, times(2)).getUseAgeByName(anyString());
    }
}
