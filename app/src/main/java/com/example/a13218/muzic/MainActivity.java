package com.example.a13218.muzic;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button showBtn,refreshBtn;
    private ImageView showImg;

    private ArrayList<Sister> data;
    private int curPos=0;
    private int page=1;
    private SisterApi sisterApi;
    private PictureLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader=new PictureLoader();
        sisterApi=new SisterApi();
        initData();
        initUI();
    }

    private void initData(){
        data=new ArrayList<>();
        new SisterTask(page).execute();
    }

    private void initUI(){
        showImg=findViewById(R.id.image);
        showBtn=findViewById(R.id.btn1);
        refreshBtn=findViewById(R.id.btn2);
        showBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if(data!=null&&!data.isEmpty()) {
                    if (curPos > 9) {
                        curPos = 0;
                    }
                    loader.load(showImg, data.get(curPos).getUrl());
                    curPos++;
                }
                break;
            case R.id.btn2:
                page++;
                new SisterTask(page).execute();
                curPos=0;
                break;
        }
    }

    private class SisterTask extends AsyncTask<Void,Void,ArrayList<Sister>>{
        private int page;

        public SisterTask(int page){
            this.page=page;
        }

        @Override
        protected ArrayList<Sister> doInBackground(Void... voids) {
            return  sisterApi.fetchSister(10,page);
        }

        @Override
        protected void onPostExecute(ArrayList<Sister> sisters) {
            super.onPostExecute(sisters);
            data.clear();
            data.addAll(sisters);
        }
    }
}
