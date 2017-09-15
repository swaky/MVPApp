package com.swanand.mvpdemo.presenter;

import android.util.Log;

import com.swanand.mvpdemo.api.ApiInterface;
import com.swanand.mvpdemo.model.Questions;
import com.swanand.mvpdemo.view.MainView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swanand on 1/28/2017.
 */

public class MainPresenter {


    public MainPresenter() {


    }

    public void onButtonClick(MainView mainView){
        mainView.openNewWindow();

    }


    public void showTabAcvitivty(MainView mainView)
    {
        mainView.openTabWindow();
    }

    public void presentDetails() {

    }


}
