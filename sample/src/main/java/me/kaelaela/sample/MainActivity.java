package me.kaelaela.sample;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        findViewById(R.id.change_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random random = new Random();
        int color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        toolbar.setBackgroundColor(color);
        Drawable navigationIcon = DrawableColorChanger.changeColor(this, color, R.drawable.ic_arrow_back);
        toolbar.setNavigationIcon(navigationIcon);
        ImageView oval = (ImageView) findViewById(R.id.oval);
        color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        Drawable newOval = DrawableColorChanger.changeColor(this, color, R.drawable.oval);
        oval.setImageDrawable(newOval);
    }
}
