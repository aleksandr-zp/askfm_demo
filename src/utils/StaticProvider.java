package utils;

//aleksandr_aleksandrov_ff -  123456abcdef;
// another_another - 123456abcdef;
// qa3905test - password! ;
// qa3906test - password! ;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "login")
    public static Object[][] createData() {
        return new Object[][]{
                {"qa3905test", "password!"},
                {"aleksandr_aleksandrov", "password!"},
                {"aleksandr_aleksandrov_ff", "123456"}
        };
    }

    @DataProvider(name = "loginQuestion1")
    public static Object[][] createData1() {
        return new Object[][]{
                {"qa3905test", "password!"}
        };
    }

    @DataProvider(name = "loginQuestion2")
    public static Object[][] createData2() {
        return new Object[][]{
                {"qa3906test", "password!"}
        };
    }


}
