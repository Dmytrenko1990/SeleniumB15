package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public  static AddEmployeePage addEmployeePage;
    public static void initializePageObjects()
    {
        login = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }
}

//This class will manage the object creation of different page in our Framework.
//Instead of calling the age objects again ana again, this class will take good care of the step