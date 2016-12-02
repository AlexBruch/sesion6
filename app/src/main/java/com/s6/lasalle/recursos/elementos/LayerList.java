package com.s6.lasalle.recursos.elementos;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
