package com.studios.lamka.eresloqueescuchas.vista;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.vista.paginasEncuestas.PaginaFinal;

import android.app.Activity;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PantallaCamara extends Activity implements SurfaceHolder.Callback {

    private Camera camera;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private final String tag = "VideoServer";
    private Button start, stop, capture;
    private List<Camera.Size> previewSizes;
    private Camera.Size mPreviewSize;
    protected List<Camera.Size> pictureSizes;
    protected Camera.Size mPictureSize;

    private static boolean DEBUGGING = true;
    private static final String LOG_TAG = "CameraPreviewSample";
    private static final String CAMERA_PARAM_ORIENTATION = "orientation";
    private static final String CAMERA_PARAM_LANDSCAPE = "landscape";
    private static final String CAMERA_PARAM_PORTRAIT = "portrait";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pantalla_camara);

        /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);*/
        capture = findViewById(R.id.capture);
        capture.setEnabled(false);

        start = findViewById(R.id.start);
        start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                capture.setEnabled(true);
                start_camera();
            }
        });

        //stop = findViewById(R.id.stop);
        /*stop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                stop_camera();
            }
        });*/


        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capture.setEnabled(false);
                camera.takePicture(null, null, fotoCallback);


                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(getBaseContext(), PaginaFinal.class);
                startActivity(i);
                finish();
            }
        });

        surfaceView = findViewById(R.id.surfaceView1);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    private void start_camera() {
        try {
            camera = Camera.open();
        } catch (RuntimeException e) {
            Log.e(tag, "init_camera: " + e);
            return;
        }

        //modify parameter
        /*if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
        param.setPreviewFrameRate(20);
        previewSizes = param.getSupportedPreviewSizes();
        previewSize = previewSizes.get(0);
        param.setPreviewSize(previewSize.width, previewSize.height);
        param.setRotation(90);
        camera.setParameters(param);*/


        boolean portrait = isPortrait();
        //configureCameraParameters(param, portrait);

        try {
            camera.release();
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);

            Camera.Parameters param = camera.getParameters();
            previewSizes = param.getSupportedPreviewSizes();
            mPreviewSize = previewSizes.get(0);
            pictureSizes = param.getSupportedPictureSizes();
            mPictureSize = pictureSizes.get(0);
            param.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
            param.setPictureSize(mPictureSize.width, mPictureSize.height);
            param.setJpegQuality(100);
            param.setPictureFormat(ImageFormat.JPEG);
            camera.setParameters(param);

            camera.setDisplayOrientation(90);
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {
            Log.e(tag, "init_camera: " + e);
            return;
        }
    }

    private void stop_camera() {
        camera.stopPreview();
        camera.release();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }


    //PARAMETROS DEFINIDOS PARA LA CAMARA
    /*protected void configureCameraParameters(Camera.Parameters cameraParams, boolean portrait) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) {
            if (portrait) {
                cameraParams.set(CAMERA_PARAM_ORIENTATION, CAMERA_PARAM_PORTRAIT);
            } else {
                cameraParams.set(CAMERA_PARAM_ORIENTATION, CAMERA_PARAM_LANDSCAPE);
            }
        } else {
            int angle;
            Display display = this.getWindowManager().getDefaultDisplay();
            switch (display.getRotation()) {
                case Surface.ROTATION_0:
                    angle = 90;
                    break;
                case Surface.ROTATION_90:
                    angle = 0;
                    break;
                case Surface.ROTATION_180:
                    angle = 270;
                    break;
                case Surface.ROTATION_270:
                    angle = 180;
                    break;
                default:
                    angle = 90;
                    break;
            }
            Log.v(LOG_TAG, "angle: " + angle);
            camera.setDisplayOrientation(angle);
        }

        cameraParams.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
        cameraParams.setPictureSize(mPictureSize.width, mPictureSize.height);
        if (DEBUGGING) {
            Log.v(LOG_TAG, "Preview Actual Size - w: " + mPreviewSize.width + ", h: " + mPreviewSize.height);
            Log.v(LOG_TAG, "Picture Actual Size - w: " + mPictureSize.width + ", h: " + mPictureSize.height);
        }

        camera.setParameters(cameraParams);
    }*/


    public boolean isPortrait() {
        return (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT);
    }


    //METODO QUE TOMA LA FOTO Y LA GUARDA EN LA CARPETA
    Camera.PictureCallback fotoCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera)

        {

            String path = Environment.getExternalStorageDirectory().toString() + "/" + "¿ELQE?" + "/" + "temp" + ".jpg";
            File imageFile = new File(path);

            FileOutputStream outStream = null;
            try {

                outStream = new FileOutputStream(path);
                outStream.write(data);
                outStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                camera.stopPreview();
                camera.release();
                camera = null;
                //Toast.makeText(getApplicationContext(), "Image snapshot Done", Toast.LENGTH_LONG).show();


            }

            String photopath = imageFile.getPath().toString();

            Bitmap bmp = BitmapFactory.decodeFile(photopath);
            Matrix matrix = new Matrix();
            matrix.postRotate(270);
            bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);

            FileOutputStream fOut;
            try {

                fOut = new FileOutputStream(imageFile);
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                fOut.flush();
                fOut.close();

            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}

