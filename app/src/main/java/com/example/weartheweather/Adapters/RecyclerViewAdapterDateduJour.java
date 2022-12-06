package com.example.weartheweather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weartheweather.Models.Forecast;

import com.example.weartheweather.R;

import java.util.List;

public class RecyclerViewAdapterDateduJour extends RecyclerView.Adapter<RecyclerViewAdapterDateduJour.RecyclerViewHolder> {

    private List<Forecast> dataModelList;
    public RecyclerViewAdapterDateduJour(List<Forecast> dataModelList){ this.dataModelList = dataModelList;}
    @NonNull
    @Override
    public RecyclerViewAdapterDateduJour.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_listdatedujour, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterDateduJour.RecyclerViewHolder holder, int position) {
        holder.text_temp.setText(String.valueOf(dataModelList.get(position).getMain().getTemp()));
        holder.text_heure.setText(String.valueOf(dataModelList.get(position).getDatetime()));
    }
    public long getItemId(int position){return super.getItemId(position);}

    @Override
    public int getItemCount() {return dataModelList.size();}

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView text_temp;
        TextView text_heure;
//        ImageView img_temps;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);

            text_temp = itemView.findViewById(R.id.text_temp);
            text_heure = itemView.findViewById(R.id.text_temp);
//            img_temps = itemView.findViewById(R.id.text_temp);
        }

    }


}
