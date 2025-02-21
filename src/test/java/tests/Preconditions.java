package tests;

import entity.User;

public class Preconditions extends BaseTest {

    public static User userWithEmptyUserName = User.builder()
            .username("")
            .passowrd(PASSWORD)
            .build();

    public static User userWithPassordAndUserName = User.builder()
            .username(USERNAME)
            .passowrd(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .passowrd("")
            .build();
}
