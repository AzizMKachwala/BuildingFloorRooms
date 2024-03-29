package com.example.buildingfloorrooms.datamodel;

import java.util.List;

public class Building {

    String name;
    List<Floor> floors;

    public Building(String name, List<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
