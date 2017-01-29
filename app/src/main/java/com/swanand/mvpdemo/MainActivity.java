package com.swanand.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.swanand.mvpdemo.presenter.MainPresenter;
import com.swanand.mvpdemo.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter=new MainPresenter(this);
        mainPresenter.presentDetails();
        button= (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.onButtonClick();
            }
        });
    }

    @Override
    public void openNewWindow() {
        Intent intent=new Intent(MainActivity.this,QuestionsActivity.class);
        startActivity(intent);
    }
}
