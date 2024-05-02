package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static services.Services.readJsonFromUrl;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        try {
            JSONObject json = readJsonFromUrl("https://dummyjson.com/products");
//            JSONArray family = json.getJSONArray("products");
//            JSONObject sonObject = family.getJSONObject(1);
//            JSONObject sonData = sonObject.getJSONObject("title");
//            String sonName = sonData.getString("title");
//            System.out.println(sonName);
//			System.out.println(json.toString());
            JSONArray jsonArray = json.getJSONArray("products");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jso = jsonArray.getJSONObject(i);
                System.out.println(jso.getString("title"));
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}

