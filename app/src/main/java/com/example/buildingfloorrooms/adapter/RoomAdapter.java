package com.example.buildingfloorrooms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildingfloorrooms.R;
import com.example.buildingfloorrooms.datamodel.Rooms;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter {
    List<Rooms> roomList;
    Context context;

    RecyclerView roomsRecyclerView;

    public RoomAdapter(List<Rooms> roomList, Context context) {
        this.roomList = roomList;
        this.context = context;
    }

    public RoomAdapter(List<Rooms> rooms) {
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Rooms room = roomList.get(position);
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {

        TextView roomNameTextView;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.txtRoomName);
        }


        void bind(Rooms room) {
            roomNameTextView.setText(room.getName());
        }
    }
}
