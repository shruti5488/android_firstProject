package com.example.shruti5488.test.holders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shruti5488.test.R;
import com.example.shruti5488.test.models.Legislator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * Created by shruti5488 on 11/19/16.
 */

public class LegislatorViewHolder extends RecyclerView.ViewHolder {
    private ImageView leg_image;
    private  TextView leg_name;
    private  TextView leg_state;


    public LegislatorViewHolder(View itemView) {
        super(itemView);
        this.leg_image= (ImageView)itemView.findViewById(R.id.imageView);
        this.leg_name = (TextView)itemView.findViewById(R.id.textViewName);
        this.leg_state = (TextView)itemView.findViewById(R.id.textViewState);
    }

    public void updateUI(Legislator legislator){
        String uri = legislator.getImage();

        try {
            DecodeBitMap decodeBitMap = new DecodeBitMap(leg_image,legislator);
            decodeBitMap.execute();

            leg_name.setText(legislator.getName());
//            Log.d("watchdogs","song image " + uri);
            leg_state.setText(legislator.getState());
        } catch(Exception e){
            //Log.d("MusicGo","exception just generated "+e.getMessage());
        }
    }
    public Bitmap decodeUri(String imageUri){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Boolean scaleByHeight = Math.abs(options.outHeight - 100) >= Math.abs(options.outWidth - 100);
        if(options.outHeight *  options.outWidth * 2 >= 16384){
            double sampleSize = scaleByHeight ? options.outHeight/4000 : options.outWidth/2000;
            options.inSampleSize = (int) Math.pow(2d,Math.floor(Math.log(sampleSize)/Math.log(2d)));
        }
        options.inJustDecodeBounds = false;
        options.inTempStorage = new byte[1024];
        InputStream in = null;
        try {
            in = new java.net.URL(imageUri).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap output =  BitmapFactory.decodeStream(in,new Rect(2,2,2,2),options);
        Bitmap scaled = Bitmap.createScaledBitmap(output, 300, 300, true);
        return scaled;

    }

    class DecodeBitMap extends AsyncTask<Void,Void,Bitmap> {
        private final WeakReference<ImageView> mImageViewWeakReerence;
        private Legislator legislator;

        public DecodeBitMap(ImageView imageView, Legislator instaImage) {
            this.mImageViewWeakReerence = new WeakReference<ImageView>(imageView);
            this.legislator = instaImage;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            return decodeUri(legislator.getImage());
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
          //  Log.d("Hello", "bitmap" + bitmap);
            if(bitmap != null) {
            //    Log.d("Hello", "Width size" + bitmap.getWidth());
             //   Log.d("Hello", "Height size" + bitmap.getHeight());
            }
            final ImageView imgView = mImageViewWeakReerence.get();
            if(imgView != null){
                imgView.setImageBitmap(bitmap);
                imgView.setBackground(null);
            }
        }
    }

}
