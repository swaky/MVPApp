package com.swanand.mvpdemo.dagger.components;

import com.swanand.mvpdemo.QuestionsActivity;
import com.swanand.mvpdemo.dagger.modules.QuestionActivityModule;
import com.swanand.mvpdemo.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by swanand on 9/17/2017.
 */

@ActivityScope
@Component(modules = QuestionActivityModule.class,dependencies = StackApplicationComponent.class)
public interface QuestionActivityComponent {
 void injectQuestionActivity(QuestionsActivity activity);
}
