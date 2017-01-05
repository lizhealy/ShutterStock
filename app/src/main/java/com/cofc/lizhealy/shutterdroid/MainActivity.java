package com.cofc.lizhealy.shutterdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cofc.lizhealy.shutterdroid.api.Image;
import com.cofc.lizhealy.shutterdroid.api.ShutterStock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private List<Image> mImages;
    private ImagesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImages = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new ImagesAdapter(this, mImages);
        recyclerView.setAdapter(mAdapter);

        ShutterStock.getRecent(new Date(), new Callback<List<Image>>() {
            @Override
            public void success(List<Image> images, Response response) {
                mImages.clear();
                mImages.addAll(images);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }
}
