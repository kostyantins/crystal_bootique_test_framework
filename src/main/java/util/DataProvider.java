package util;

public class DataProvider {

    private DataProvider() {
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testDataLogIn() {
        return new Object[][]{
                {"xxxxx@ukr.net", "qwerty"},
                {"kostyantins@mail.ru", "123456"},
                {"1234567890@mail.ru", "1q2w3e4r"},
                {"", ""},
                {"@#$!%^&*(){}|", "!@#$%^&*()_{}"},
                {"kostyantins@mail.ru", ""},
                {"", "qwerty"},
        };

    }
}
