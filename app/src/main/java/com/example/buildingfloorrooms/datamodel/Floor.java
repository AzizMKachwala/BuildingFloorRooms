package com.example.buildingfloorrooms.datamodel;

import java.util.List;

public class Floor {

    String name;
    List<Rooms> rooms;

    public Floor(String name, List<Rooms> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public Floor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public void setName(String name) {
        this.name = name;
    }
}
