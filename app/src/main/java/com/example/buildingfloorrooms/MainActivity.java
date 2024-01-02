package com.example.buildingfloorrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.buildingfloorrooms.adapter.BuildingAdapter;
import com.example.buildingfloorrooms.datamodel.Building;
import com.example.buildingfloorrooms.datamodel.Floor;
import com.example.buildingfloorrooms.datamodel.Rooms;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView buildingRecyclerView;
    BuildingAdapter buildingAdapter;
    List<Building> buildingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildingRecyclerView = findViewById(R.id.buildingRecyclerView);

        buildingList = getBuildingData();

        buildingAdapter = new BuildingAdapter(buildingList);

        buildingRecyclerView.setAdapter(buildingAdapter);
        buildingRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

    }

    private List<Building> getBuildingData() {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building("Building A", getFloorData("Building A")));
        buildings.add(new Building("Building B", getFloorData("Building B")));
        buildings.add(new Building("Building C", getFloorData("Building C")));
        return buildings;
    }

    private List<Floor> getFloorData(String buildingName) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            floors.add(new Floor(buildingName + " - Floor " + i, getRoomData(buildingName, i)));
        }
        return floors;
    }

    private List<Rooms> getRoomData(String buildingName, int floorNumber) {
        List<Rooms> rooms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Rooms(buildingName + " - Floor " + floorNumber + " - Room " + i));
        }
        return rooms;
    }
}