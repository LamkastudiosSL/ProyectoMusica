package com.studios.lamka.eresloqueescuchas.Ventanas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;

import com.studios.lamka.eresloqueescuchas.R;

import java.io.File;

public class PantallaFotoEstilo extends AppCompatActivity {

    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pantalla_foto_estilo);

        cl = findViewById(R.id.cl);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "¿ELQE?" + "/" + "temp" + ".jpg";

        Bitmap bitmap = BitmapFactory.decodeFile(mPath);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(getBaseContext().getResources(), bitmap);

        ImageView testimage = findViewById(R.id.testimage);

        Resources r = getResources();
        Drawable[] layers = new Drawable[2];
        layers[0] = bitmapDrawable;
        layers[1] = r.getDrawable(R.mipmap.reggaeboy);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setLayerSize(0, width, height);
        layerDrawable.setLayerSize(1, width, height);
        testimage.setImageDrawable(layerDrawable);
    }
}
