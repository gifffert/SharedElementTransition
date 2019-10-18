package ru.embersoft.sharedelementtransition;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

public class EasyTransitionAnimation extends AppCompatActivity {

    ImageView imageView;
    CardView profileImage, cardView;
    TextView name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_transition_animation);

        imageView = findViewById(R.id.imageView);
        profileImage = findViewById(R.id.view);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        cardView = findViewById(R.id.cardView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyTransitionAnimation.this, DetailActivity.class);
                Activity activity = (Activity) EasyTransitionAnimation.this;
                Pair[] pairs = new Pair[5];
                pairs[0] = new Pair<>(imageView, ViewCompat.getTransitionName(imageView));
                pairs[1] = new Pair<>(profileImage, ViewCompat.getTransitionName(profileImage));
                pairs[2] = new Pair<>(name, ViewCompat.getTransitionName(name));
                pairs[3] = new Pair<>(desc, ViewCompat.getTransitionName(desc));
                pairs[4] = new Pair<>(cardView, ViewCompat.getTransitionName(cardView));

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
                activity.startActivity(intent, optionsCompat.toBundle());
            }
        });
    }
}
