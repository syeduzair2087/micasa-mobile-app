package micasa.madproject.com.micasa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Syed Uzair Mumtaz on 12/25/2015.
 */
class ImageLoadTask extends AsyncTask<String, String, Bitmap> {

    private  Bitmap bitmap;
    private ImageView img;

    public ImageLoadTask(ImageView Img)
    {
        this.img = Img;
    }

    protected Bitmap doInBackground(String... args) {
        try {


            bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }



    protected void onPostExecute(Bitmap image) {

        if (image != null) {
            img.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 60, 50, false));
        }
    }
}