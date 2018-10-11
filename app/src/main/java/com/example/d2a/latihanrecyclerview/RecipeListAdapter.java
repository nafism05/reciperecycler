package com.example.d2a.latihanrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.WordViewHolder> {
//    private final LinkedList<String> wordList;
    private final LinkedList<Recipe> recipeList;
    private LayoutInflater inflater;
    private Context context;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        this.recipeList = recipeList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recipe_item, parent, false);

        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordViewHolder holder, int position) {
//        String currentText = recipeList.get(position);
        holder.title.setText(recipeList.get(position).getTitle());
        holder.description.setText(recipeList.get(position).getDescription());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(context, DetailView.class);
                mIntent.putExtra("title", holder.title.getText().toString());
                mIntent.putExtra("description", holder.description.getText().toString());
                context.startActivity(mIntent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView title, description;
        LinearLayout layout;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.recipe_title);
            this.description = (TextView) itemView.findViewById(R.id.recipe_description);
            this.layout = itemView.findViewById(R.id.layout);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
        }
    }
}
