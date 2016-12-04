package com.s6.lasalle.recursos.elementos;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.s6.lasalle.recursos.R;

public class LayerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layerlist);

        Drawable d = (Drawable) getResources().getDrawable(R.drawable.layerlist);
        Bitmap b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        LayerDrawable ld = (LayerDrawable) getResources().getDrawable(R.drawable.layerlist);
        ld.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ld.draw(new Canvas(b));

        /** BUTTON **/

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LayerList.this);
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
                dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
                dialog.show();
            }
        });
    }
}
