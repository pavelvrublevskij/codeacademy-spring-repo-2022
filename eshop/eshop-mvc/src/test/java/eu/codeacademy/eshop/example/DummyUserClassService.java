package eu.codeacademy.eshop.example;

public class DummyUserClassService {

    public void save(User user) {
        // do validations
        if (user.getName() == null) {
            throw new RuntimeException();
        }

        if (user.getAge() < 21) {
            throw new RuntimeException("Age is to low!");
        }

        // otherwise save into db
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
