package com.swanand.mvpdemo.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.swanand.mvpdemo.MyApplication;
import com.swanand.mvpdemo.api.ApiInterface;
import com.swanand.mvpdemo.model.Questions;
import com.swanand.mvpdemo.view.QuestionsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by swanand on 1/28/2017.
 */

public class QuestionsPresenter {
    private Context context;
    private QuestionsView questionsView;
    private static Retrofit retrofit = null;

    public QuestionsPresenter(Context context) {
      this.context=context;
    }

    public void presentQuestions(QuestionsView questionsView)
    {
    this.questionsView=questionsView;
        questionsView.showProgressDialog();
        getDetails();


    }
    public void getDetails(){



       // MyApplication myapplication=MyApplication.get((Activity) context);
        ApiInterface apiInterface=MyApplication.get((Activity) context).getApiInterface();
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
