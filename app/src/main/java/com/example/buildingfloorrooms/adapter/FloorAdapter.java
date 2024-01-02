package com.example.buildingfloorrooms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildingfloorrooms.R;
import com.example.buildingfloorrooms.datamodel.Floor;

import java.util.List;

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.FloorViewHolder> {

    List<Floor> floorList;
    Context context;

    public FloorAdapter(List<Floor> floorList, Context context) {
        this.floorList = floorList;
        this.context = context;
    }

    public FloorAdapter(List<Floor> floors) {
        this.floorList = floors;
    }

    @NonNull
    @Override
    public FloorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.floor_item, parent, false);
        return new FloorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FloorViewHolder holder, int position) {
        Floor floor = floorList.get(position);
        holder.bind(floor);
    }

    @Override
    public int getItemCount() {
        return floorList.size();
    }

    public class FloorViewHolder extends RecyclerView.ViewHolder{

        TextView floorNameTextView;
        RecyclerView roomRecyclerView;

        public FloorViewHolder(@NonNull View itemView) {
            super(itemView);
            floorNameTextView = itemView.findViewById(R.id.txtFloorName);
            roomRecyclerView = itemView.findViewById(R.id.roomsRecyclerView);
        }
        void bind(Floor floor) {
            floorNameTextView.setText(floor.getName());
            // Create and set up RoomAdapter for roomRecyclerView here
            RoomAdapter roomAdapter = new RoomAdapter(floor.getRooms());
            roomRecyclerView.setAdapter(roomAdapter);
            roomRecyclerView.setLayoutManager(new GridLayoutManager(context,3));
        }
    }
}
