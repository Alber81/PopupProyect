package com.albert.demopopup1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backCounter();


    }

    private void  backCounter() {
        // Cuenta hasta 3000 milisegundos de 1000 en 1000 milisegundos
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                showDialog();
            }
        }.start();
    }



    private void showDialog() {
        // custom dialog
        final Random rGeneratorImg = new Random();

        final Integer[] imagenesID =
                {R.drawable.bocasecaman, R.drawable.candycrush, R.drawable.chikito,};


        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup1);
        iv = (ImageView) dialog.findViewById(R.id.popup_image);

        // set the custom dialog components - text, image and button
        final int resourceImg = imagenesID[rGeneratorImg.nextInt(imagenesID.length)];
        iv.setImageResource(resourceImg);
        ImageButton close = (ImageButton) dialog.findViewById(R.id.btnClose);


        // Close Button
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                backCounter();
            }
        });


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

}

