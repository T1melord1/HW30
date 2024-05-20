package org.example.deserializers;

import com.google.gson.*;
import org.example.Case;
import org.example.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject employeeJson = jsonElement.getAsJsonObject();
        Employee employee1 = new Employee();

        employee1.setEmployeeName(employeeJson.get("name").getAsString());
        employee1.setPosition(employeeJson.get("position").getAsString());

        List<Case> cases = new ArrayList<>();
        JsonArray jsonArray = employeeJson.get("cases").getAsJsonArray();
        for (JsonElement element : jsonArray) {
            cases.add(jsonDeserializationContext.deserialize(element, Case.class));
        }
            employee1.setCases(cases);

        return employee1;
    }
}
