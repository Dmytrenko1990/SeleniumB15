package Utils;

import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APIPayloadConstants {
    //we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload(){
        String createEmployeePayload= "{\n" +
                "    \"emp_firstname\": \"Artem333\",\n" +
                "    \"emp_lastname\": \"Dmytrenko\",\n" +
                "    \"emp_middle_name\": \"Tim\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"2000-01-01\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Automation Engineer\"\n" +
                "}";
        return createEmployeePayload;

    }

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Gene");
        obj.put("emp_lastname","Claseman");
        obj.put("emp_middle_name","Rick");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1985-05-20");
        obj.put("emp_status","probation");
        obj.put("emp_job_title","CAM");
        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(String emp_firstname,String emp_lastname,
                                                      String emp_middle_name, String emp_gender, String emp_birthday,
                                                      String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57586A");
        obj.put("emp_firstname","Bob");
        obj.put("emp_lastname","Turner");
        obj.put("emp_middle_name","Sam");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1994-03-06");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }

}
