package org.quietlip.unit_04_assessment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.quietlip.unit_04_assessment.model.Animals;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnimalsViewHolder extends RecyclerView.ViewHolder {
    public static final String LINK = "link";
    public static final String NAME = "name";
    public static final String IMAGE = "image";

    private CircleImageView animalImage;
    private TextView animalNameTextView;

    public AnimalsViewHolder(@NonNull final View itemView) {
        super(itemView);

        animalImage = itemView.findViewById(R.id.animal_image_view);
        animalNameTextView = itemView.findViewById(R.id.animal_name_text_view);

    }

    public void onBind(final Animals animals){
        String animalName = animals.getAnimal();

        Picasso.get()
                .load(animals.getImage())
                .into(animalImage);

        animalNameTextView.setText(animalName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), SecondActivity.class);
                intent.putExtra(LINK, animals.getWiki());
                intent.putExtra(IMAGE, animals.getImage());
                intent.putExtra(NAME, animals.getAnimal());
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
