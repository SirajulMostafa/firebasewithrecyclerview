package com.mostafa.firebasewithrecyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mostafa.firebasewithrecyclerview.MainActivity;
import com.mostafa.firebasewithrecyclerview.Models.Student;
import com.mostafa.firebasewithrecyclerview.R;

import java.util.ArrayList;

public class MainAdapter extends FirebaseRecyclerAdapter<Student,MainAdapter.viewHolder>  {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<Student> options) {
        super(options);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //parent,false use for recyclerview's unwanted gape
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_mainfood ,parent ,false);
        return new viewHolder(view);
    }
//viewHolder( view) call public class viewHolder extends RecyclerView.ViewHolder
    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Student model) {
// Add firstname from model class (here
        // "Student.class")to appropriate view in Card
        // view (here "single_item.xml")
//        holder.image.setText
        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .centerCrop()//optional
               .placeholder(R.drawable.loading_spinner)
                .into(holder.image);
        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.duration.setText(model.getDuration());
    }

    public class viewHolder extends RecyclerView.ViewHolder {
//        String course,duration, name,image;
        ImageView image;
        TextView  course,duration,name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            course = (TextView)itemView.findViewById(R.id.txt_course);
            name = itemView.findViewById(R.id.name);
            duration = (TextView)itemView.findViewById(R.id.txt_duration);

        }
    }
}
