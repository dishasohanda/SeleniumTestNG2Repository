package PK1OrangeHRM;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "dp")
  public void LoginPage(String US, String PW) {
	  Reporter.log("LoginPage");
	  Reporter.log("Username is " + US);
	  Reporter.log("Password is " + PW);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Disha", "Dishaaa" },
      new Object[] { "Renu", "Renuuu" },
    };
  }
}
