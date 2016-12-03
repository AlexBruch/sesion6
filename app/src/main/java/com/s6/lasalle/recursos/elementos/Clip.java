package com.s6.lasalle.recursos.elementos;

import android.content.DialogInterface;
import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.s6.lasalle.recursos.R;

public class Clip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);

        ImageView imageview = (ImageView) findViewById(R.id.image);
        ClipDrawable drawable = (ClipDrawable) imageview.getDrawable();
        drawable.setLevel(drawable.getLevel() + 1000);

        /** BUTTON **/

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Clip.this);
                builder.setMessage(getString(R.string.alert_dialog_details)).setTitle(getString(R.string.alert_dialog_title));
                builder.setPositiveButton(getString(R.string.accept), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
