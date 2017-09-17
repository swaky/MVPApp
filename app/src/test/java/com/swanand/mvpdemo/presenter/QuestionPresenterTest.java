package com.swanand.mvpdemo.presenter;

import android.app.LauncherActivity;

import com.swanand.mvpdemo.model.Item;
import com.swanand.mvpdemo.model.Questions;
import com.swanand.mvpdemo.view.QuestionsView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by swanand on 1/29/2017.
 */

public class QuestionPresenterTest {

    private QuestionsPresenter questionsPresenter;
    @Before
    public void setUp() throws Exception{
       questionsPresenter=new QuestionsPresenter();
    }
    @Test
    public void testPresentQuestion(){
        QuestionsView questionsView=mock(QuestionsView.class);
        questionsPresenter.presentQuestions(questionsView);
        verify(questionsView).showProgressDialog();


    }

    @Test
    public void testQuestionApi()
    {
QuestionsView questionsView=mock(QuestionsView.class);

        //questionsPresenter.test();
        questionsPresenter.getDetails();

        List<Item> questionses=new ArrayList<>();
        verify(questionsView).renderData(questionses);
    }
}
