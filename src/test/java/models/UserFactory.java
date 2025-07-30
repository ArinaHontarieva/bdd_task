package models;

public class UserFactory {

    public static User getValidUser() {
        return User.builder()
            .name("Test")
            .lastName("Testovich")
            .email("test@example.com")
            .password("StrongPass123")
            .confirmPassword("StrongPass123")
            .birthDate("01011990")
            .build();
    }

    public static User getInvalidUser() {
        return User.builder()
            .name("")
            .lastName("")
            .email("invalidemail")
            .password("pass")
            .confirmPassword("differentpass")
            .birthDate("01012025")
            .build();
    }
}
