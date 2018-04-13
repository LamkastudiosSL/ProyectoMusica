package com.studios.lamka.eresloqueescuchas.Ventanas;

import android.app.Activity;
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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;

import java.io.File;

public class PantallaFotoEstilo extends Activity {

    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pantalla_foto_estilo);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cl = findViewById(R.id.cl);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int heightR = (int) (height*0.3);
        int widthR = (int) (width*0.3);

        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "¿ELQE?" + "/" + "temp" + ".jpg";

        Bitmap bitmap = BitmapFactory.decodeFile(mPath);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(getBaseContext().getResources(), bitmap);

        //BitmapDrawable bitmapDrawableR = (BitmapDrawable) resize(bitmapDrawable);

        ImageView testimage = findViewById(R.id.testimage);



        Resources r = getResources();
        Drawable[] layers = new Drawable[2];
        layers[0] = bitmapDrawable;
        layers[1] = r.getDrawable(R.mipmap.electronica);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setLayerInset(0, (int) (width*0.25), (int) -(height*0.17),(int) (width*0.32), (int) (height*1.50));
        layerDrawable.setLayerInset(1, 0, 0, 0, 0);
        testimage.setImageDrawable(layerDrawable);

        //Toast.makeText(getBaseContext(), (int) (width*0.3) + " " + (int) (height*0.3), Toast.LENGTH_SHORT).show();
    }

    /*private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }*/
}
