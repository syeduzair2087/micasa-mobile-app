package micasa.madproject.com.micasa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Syed Uzair Mumtaz on 12/25/2015.
 */
public class ImageActivity extends Activity {

    ImageView img;
    Bitmap bitmap;
//    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_image);
        img = (ImageView) findViewById(R.id.imageView2);

//        new ImageLoadTask("http:////joombig.com//demo-extensions1//images//gallery_slider//Swan_large.jpg", img);

        String img_url = "http://192.168.0.102:2087//ads//9//images//plots1.jpg"; //url of the image

        new ImageLoadTask(img).execute(img_url);
    }


}

