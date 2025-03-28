package htl.teddy_com.server.gamemodes.impl;

import htl.teddy_com.server.gamemodes.api.Gamemode;

public class MultiSpielerGame extends Gamemode {
    public MultiSpielerGame(String name, String date){
        this.name = name;
        this.date = date;
        //this.money = readDataFromFile("data.txt");
    }
}
