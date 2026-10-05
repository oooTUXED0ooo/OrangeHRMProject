package tests;

import org.testng.annotations.Test;

public class DemoLoginTest {
	
	private String username;
    private String password;

    public DemoLoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Test
    public void login() {
        System.out.println(username + " : " + password);
    }
}
