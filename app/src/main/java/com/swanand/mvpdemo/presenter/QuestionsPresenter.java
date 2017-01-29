package com.swanand.mvpdemo.presenter;

import android.util.Log;

import com.swanand.mvpdemo.api.ApiInterface;
import com.swanand.mvpdemo.model.Questions;
import com.swanand.mvpdemo.view.QuestionsView;

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

public class QuestionsPresenter {
    private final QuestionsView questionsView;
    private static Retrofit retrofit = null;

    public QuestionsPresenter(QuestionsView questionsView) {
        this.questionsView = questionsView;
    }

    public void presentQuestions()
    {
        questionsView.showProgressDialog();
        getDetails();


    }
    public void getDetails(){


        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com/2.2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        Map<String, String> params = new HashMap<>();
        params.put("order","desc");
        params.put("sort","activity");
        params.put("site","stackoverflow");
        Call<Questions> retrieveQuestions=apiInterface.getQuestions(params);
        retrieveQuestions.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Log.d("test",response.body().toString());

                questionsView.renderData(response.body().getItems());
                questionsView.dismissProgressDialog();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });


    }
}
