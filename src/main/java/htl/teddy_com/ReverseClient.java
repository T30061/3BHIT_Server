package htl.teddy_com;

import static htl.teddy_com.server.gamemodes.api.Gamemode.readDataFromFile;

public class ReverseClient {
    public static void main(String[] args) {
        System.out.println(readDataFromFile("data.txt"));
    }
}