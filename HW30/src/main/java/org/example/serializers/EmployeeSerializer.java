package org.example.serializers;

import com.google.gson.*;
import org.example.Employee;

import java.lang.reflect.Type;

public class EmployeeSerializer implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject employeeObject = new JsonObject();
        employeeObject.addProperty("name", employee.getEmployeeName());
        employeeObject.addProperty("position", employee.getPosition());
        employeeObject.add("cases", jsonSerializationContext.serialize(employee.getCases()));
        return employeeObject;
    }
}
