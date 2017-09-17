package com.swanand.mvpdemo.dagger.modules;

import com.swanand.mvpdemo.view.QuestionsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by swanand on 9/17/2017.
 */

@Module
public class QuestionActivityModule {

    private final QuestionsView view;

    public QuestionActivityModule(QuestionsView view)
   {
       this.view=view;
   }
    @Provides
    public QuestionsView questionsview(){
        return view;
    }
}
