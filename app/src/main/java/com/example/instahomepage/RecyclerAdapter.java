package com.example.instahomepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    List<Integer> posts=new ArrayList<>();
    List<Integer> likeposts=new ArrayList<>();
    Context context;

    public RecyclerAdapter(List<Integer> posts, Context context,List<Integer> likeposts) {
        this.posts = posts;
        this.context = context;
        this.likeposts=likeposts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.postcards,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.postsimages.setImageResource(posts.get(position));
        Glide.with(context).load(posts.get(position)).centerCrop()

                .into(holder.postsimages);
        //holder.likedphoto.setImageResource(posts.get(position));
        Glide.with(context).load(likeposts.get(0)).into(holder.likedphoto);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView postsimages,likedphoto;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postsimages=itemView.findViewById(R.id.imageposts);
            likedphoto=itemView.findViewById(R.id.likedphoto);
        }
    }
}
