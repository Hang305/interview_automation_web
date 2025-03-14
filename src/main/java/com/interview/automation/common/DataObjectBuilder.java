package com.interview.automation.common;

import com.interview.automation.model.User;
import io.cucumber.messages.internal.com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildDataObjectFrom(String jsonDataFileLocation, Class<T> dataType) {
        T data = null;
        String currentPath = System.getProperty("user.dir");
        try (Reader jsonContentReader = Files.newBufferedReader(Paths.get(currentPath + jsonDataFileLocation));) {
            Gson gson = new Gson();
            data = gson.fromJson(jsonContentReader, dataType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
