package eu.codeacademy.eshop.example;

public class DummyUserClassService {

    public void save(User user) {
        // some logic here with db other systems, etc
        // ...
        // if something wrong then exception
        throw new RuntimeException();
    }


    /**
     *
     * @param userName
     * @return 0 if userName not exists, otherwise return user age
     */
    public int getUseAgeByName(String userName) {
        return 0;
    }
}
