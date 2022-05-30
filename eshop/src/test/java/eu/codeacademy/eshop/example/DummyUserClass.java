package eu.codeacademy.eshop.example;

public class DummyUserClass {

    private final DummyUserClassService service;

    public DummyUserClass(DummyUserClassService service) {
        this.service = service;
    }

    public void saveUser() {
        service.save(new User("Petras", 21));
    }

    public int findUserAgeByName(String userName) {
        int age = service.getUseAgeByName(userName);
        // age = service.getUseAgeByName(userName);  // jei norime kad verify butu success
        // age++; // iskraipome logika, testas failed
        return age;
    }
}
