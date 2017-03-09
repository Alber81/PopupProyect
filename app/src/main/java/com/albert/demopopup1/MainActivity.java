package com.albert.demopopup1;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog();
    }

    Dialog dialog;

    private void showDialog() {
        // custom dialog
        final Random rGeneratorImg = new Random();

        final Integer[] imagenesID =
                {R.drawable.bocasecaman, R.drawable.candycrush, R.drawable.chikito,};

        final ImageView iv = (ImageView) findViewById(R.id.popup_image);

        final int resource = imagenesID[rGeneratorImg.nextInt(imagenesID.length)];
        iv.setImageResource(resource);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup1);

        // set the custom dialog components - text, image and button
        ImageButton close = (ImageButton) dialog.findViewById(R.id.btnClose);

        // Close Button
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //TODO Close button action
            }
        });


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

}
