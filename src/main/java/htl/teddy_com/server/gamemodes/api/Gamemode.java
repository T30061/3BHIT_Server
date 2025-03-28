package htl.teddy_com.server.gamemodes.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Gamemode {
    public String name;
    public int money;
    public String date;

    public static Map<String, Integer> readDataFromFile(String fileName) {
        Map<String, Integer> dataMap = new HashMap<>();

        try (InputStream inputStream = Gamemode.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int money = Integer.parseInt(parts[1].trim());
                    dataMap.put(name, money);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return dataMap;
    }
}
