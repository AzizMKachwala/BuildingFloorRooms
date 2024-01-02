package com.example.buildingfloorrooms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildingfloorrooms.R;
import com.example.buildingfloorrooms.datamodel.Building;

import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {

    List<Building> buildingList;
    Context context;

    public BuildingAdapter(List<Building> buildingList, Context context) {
        this.buildingList = buildingList;
        this.context = context;
    }

    public BuildingAdapter(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    @NonNull
    @Override
    public BuildingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_item, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingViewHolder holder, int position) {
        Building building = buildingList.get(position);
        holder.bind(building);
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder{

        TextView buildingNameTextView ;
        RecyclerView floorRecyclerView;

        public BuildingViewHolder(@NonNull View itemView) {
            super(itemView);

            buildingNameTextView = itemView.findViewById(R.id.txtBuildingName);
            floorRecyclerView = itemView.findViewById(R.id.floorRecyclerView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Building building = buildingList.get(position);
                    }
                }
            });
        }
        void bind(Building building) {
            buildingNameTextView.setText(building.getName());
            // Create and set up FloorAdapter for floorRecyclerView here
            FloorAdapter floorAdapter = new FloorAdapter(building.getFloors());
            floorRecyclerView.setAdapter(floorAdapter);
            floorRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
    }
}
