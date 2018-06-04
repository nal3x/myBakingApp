package com.example.nalex.mybakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nalex.mybakingapp.R;
import com.example.nalex.mybakingapp.model.Step;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder>{

    private List<Step> mStepsList;

    public static class StepViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipe_step_textview) TextView mRecipeStepDescription;

        public StepViewHolder (View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View recipeView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_step_list_item, parent, false);

        StepViewHolder stepViewHolder = new StepViewHolder(recipeView);

        return stepViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        Step recipeStep = mStepsList.get(position);
        String stepDescription = recipeStep.getDescription();

        holder.mRecipeStepDescription.setText(stepDescription);

    }

    @Override
    public int getItemCount() {
        if (null == mStepsList) return 0;
        return mStepsList.size();
    }

}
