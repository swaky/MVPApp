package com.swanand.mvpdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.swanand.mvpdemo.R;
import com.swanand.mvpdemo.model.Item;
import com.swanand.mvpdemo.model.Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swanand on 1/28/2017.
 */

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

    private final Context context;
    private final Picasso picasso;
    private List<Item> items=new ArrayList<>();

    public void addQuestions(List<Item> items)
    {
        this.items=items;
    }

    public QuestionsAdapter(Context context,Picasso picasso) {
    this.context=context;
        this.picasso=picasso;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.questioncard,parent,false);
        QuestionViewHolder holder=new QuestionViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.displayname.setText(items.get(position).getOwner().getDisplayName());
        picasso.load(items.get(position).getOwner().getProfileImage()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
      public  TextView title,displayname;
      public ImageView thumbnail;
        public QuestionViewHolder(View itemView) {
            super(itemView);
            this.title= (TextView) itemView.findViewById(R.id.question);
            this.thumbnail=(ImageView)itemView.findViewById(R.id.thumbnail);
            this.displayname= (TextView) itemView.findViewById(R.id.displayname);
        }
    }
}
