package org.quietlip.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.quietlip.unit_04_assessment.AnimalsViewHolder;
import org.quietlip.unit_04_assessment.R;
import org.quietlip.unit_04_assessment.model.Animals;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<AnimalsViewHolder> {
    private List<Animals> animalslist = new ArrayList<>();

    public RecyclerViewAdapter(List<Animals> animalslist) {
        this.animalslist = animalslist;
    }

    @NonNull
    @Override
    public AnimalsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animals_item, viewGroup, false);
        return new AnimalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsViewHolder animalsViewHolder, int i) {
        animalsViewHolder.onBind(animalslist.get(i));
    }

    @Override
    public int getItemCount() {
        return animalslist.size();
    }
}
