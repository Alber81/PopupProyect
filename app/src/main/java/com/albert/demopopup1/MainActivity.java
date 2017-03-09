package com.albert.demopopup1;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog1();
    }

    Dialog dialog;

    private void showDialog1() {
        // custom dialog
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

/*new CountDownTimer(20000, 1000) {

    public void onTick(long millisUntilFinished) {
        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
    }

    public void onFinish() {
        mTextField.setText("done!");
    }
}.start();
*/