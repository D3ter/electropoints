package com.example.electroapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electroapp.R;
import com.example.electroapp.model.Point;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PointAdapter extends FirestoreRecyclerAdapter<Point, PointAdapter.viewHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PointAdapter(@NonNull FirestoreRecyclerOptions<Point> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PointAdapter.viewHolder holder, int position, @NonNull Point point) {
        holder.name.setText(point.getName());
        holder.email.setText(point.getEmail());
        holder.latitud.setText(point.getLatitud());
        holder.longitud.setText(point.getLongitud());
    }

    @NonNull
    @Override
    public PointAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_point_single, parent, false);
        return new viewHolder(v);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, email, latitud, longitud;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            latitud = itemView.findViewById(R.id.latitud);
            longitud = itemView.findViewById(R.id.longitud);
        }
    }
}
