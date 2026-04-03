package utils;

public class TestContext {

    private static String email;
    private static String password;

    public static void setEmail(String mail) {
        email = mail;
    }

    public static String getEmail() {
        return email;
    }

    public static void setPassword(String pwd) {
        password = pwd;
    }

    public static String getPassword() {
        return password;
    }
}