package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyNDI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI4NTk4MiwidXNlcklkIjoiNTM3MCJ9.IpilwTG5qiFUG_khVMQdpOdDWhL1MglgwPbDQtns4T8";
    static  String employee_id;
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest =given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        //hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);
    }

    @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "    \"emp_firstname\": \"Artem333\",\n" +
                        "    \"emp_lastname\": \"Dmytrenko\",\n" +
                        "    \"emp_middle_name\": \"Tim\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"2000-01-01\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Automation Engineer\"\n" +
                        "}");

        //hitting the endpoint/send request
        Response response = preparedRequest.when().post("/createEmployee.php");

        //verifying the assertions/get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

       //it will print the output in the console
        response.prettyPrint();

        //verifying the firstname in the response body
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("Artem333"));
        response.then().assertThat().
                body("Employee.emp_lastname",equalTo("Dmytrenko"));

        //verify the response headers
        response.then().assertThat().header("Content-Type","application/json");

        System.out.println("My test case is passed");
    }

    //in homework, create a method to get all employee status and job title
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                 header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "    \"employee_id\": \""+employee_id+"\",\n" +
                        "    \"emp_firstname\": \"Gene\",\n" +
                        "    \"emp_lastname\": \"Claseman\",\n" +
                        "    \"emp_middle_name\": \"Rick\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1985-05-20\",\n" +
                        "    \"emp_status\": \"probation\",\n" +
                        "    \"emp_job_title\": \"CAM\"\n" +
                        "}");

        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        //for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
@Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
        header("Content-Type","application/json").
        header("Authorization",token).queryParam("employee_id",employee_id);
         Response response = preparedRequest.when().get("/getOneEmployee.php");
         response.prettyPrint();
         response.then().assertThat().statusCode(200);
    //if you want to verify the body of the response.
    //you can do that using hamcrest matchers


}
}
