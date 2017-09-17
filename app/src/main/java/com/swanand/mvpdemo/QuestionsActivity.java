package com.swanand.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swanand.mvpdemo.adapters.QuestionsAdapter;
import com.swanand.mvpdemo.dagger.components.DaggerQuestionActivityComponent;
import com.swanand.mvpdemo.dagger.components.QuestionActivityComponent;
import com.swanand.mvpdemo.dagger.modules.QuestionActivityModule;
import com.swanand.mvpdemo.model.Item;
import com.swanand.mvpdemo.presenter.QuestionsPresenter;
import com.swanand.mvpdemo.view.QuestionsView;

import java.util.List;

import javax.inject.Inject;

public class QuestionsActivity extends AppCompatActivity implements QuestionsView {

    @Inject
    QuestionsPresenter questionsPresenter;
    ProgressDialog progressDialog;
    QuestionsAdapter questionsAdapter;
    RecyclerView questionsRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        initRecyclerView();

        QuestionActivityComponent component= DaggerQuestionActivityComponent.builder()
                .questionActivityModule(new QuestionActivityModule(this))
                .stackApplicationComponent(MyApplication.get(this).getComponent())
                .build();

        component.injectQuestionActivity(this);
        questionsPresenter.presentQuestions(this);

    }

    public void initRecyclerView(){
        questionsRecyclerview= (RecyclerView) findViewById(R.id.recycler_view);
        questionsRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        questionsRecyclerview.setItemAnimator(new DefaultItemAnimator());
        Picasso picasso=MyApplication.get(this).getPicasso();
        questionsAdapter=new QuestionsAdapter(this,picasso);
        questionsRecyclerview.setAdapter(questionsAdapter);
    }

    @Override
    public void renderData(List<Item> items) {

        questionsAdapter.addQuestions(items);
        questionsAdapter.notifyDataSetChanged();

    }

    @Override
    public void showProgressDialog() {
         progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
