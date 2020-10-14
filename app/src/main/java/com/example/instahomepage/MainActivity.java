package com.example.instahomepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerpost;
    List<Integer> posts=new ArrayList<>();
    List<Integer> likeposts;
    RecyclerAdapter recyclerAdapter;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            likeposts=new ArrayList<>();
            setTheme(R.style.darktheme);
            likeposts.add(R.drawable.group);
        }
        else {
            //likeposts.remove(0);
            likeposts=new ArrayList<>();
            setTheme(R.style.AppTheme);
            likeposts.add(R.drawable.groupdark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerpost=findViewById(R.id.recyclerposts);
        posts.add(R.drawable.post1);
        posts.add(R.drawable.post2);
        posts.add(R.drawable.post3);
        posts.add(R.drawable.post4);
        posts.add(R.drawable.post5);
        posts.add(R.drawable.post1);
        posts.add(R.drawable.post2);
        posts.add(R.drawable.post3);
        posts.add(R.drawable.post4);
        posts.add(R.drawable.post5);
        aSwitch=findViewById(R.id.aswitch);
        recyclerAdapter=new RecyclerAdapter(posts,MainActivity.this,likeposts);
        recyclerpost.setAdapter(recyclerAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerpost.setLayoutManager(linearLayoutManager);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            aSwitch.setChecked(true);
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    RestartApp();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    RestartApp();
                }
            }
        });



    }
    public void RestartApp(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}