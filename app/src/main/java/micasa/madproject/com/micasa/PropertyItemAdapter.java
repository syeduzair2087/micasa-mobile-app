package micasa.madproject.com.micasa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Syed Uzair Mumtaz on 12/25/2015.
 */
public class PropertyItemAdapter extends BaseAdapter {
    private ArrayList<PropertyItem> PropertyArray;
    private LayoutInflater PropertyInflater;

    public  PropertyItemAdapter(Context context, ArrayList<PropertyItem> PList) {
        PropertyArray = PList;
        PropertyInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return PropertyArray.size();
    }

    @Override
    public Object getItem(int position) {
        return PropertyArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return PropertyArray.get(position).ID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = PropertyInflater.inflate(R.layout.property_list_item, null);
            holder = new ViewHolder();
            holder.lblID = (TextView) convertView.findViewById(R.id.lblID);
            holder.lblName = (TextView) convertView.findViewById(R.id.lblName);
            holder.lblPrice = (TextView) convertView.findViewById(R.id.lblPrice);
            holder.lblArea = (TextView) convertView.findViewById(R.id.lblArea);
            holder.imgImage = (ImageView) convertView.findViewById(R.id.imgImage);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder)convertView.getTag();
        }


        holder.lblID.setText(PropertyArray.get(position).ID + "");
        holder.lblName.setText(PropertyArray.get(position).Name + "");
        holder.lblPrice.setText("Price: PKR. " + PropertyArray.get(position).Price + "");
        holder.lblArea.setText("Location: " + PropertyArray.get(position).Area);

//        new ImageLoadTask(PropertyArray.get(position).Image, holder.imgImage);
        String ImagePath = PropertyArray.get(position).Image;

        new ImageLoadTask(holder.imgImage).execute(ImagePath);
//        holder.imgImage.setImageResource(R.drawable.micasa_logo);

        return convertView;
    }

    static class ViewHolder {
        TextView lblID;
        TextView lblName;
        TextView lblPrice;
        TextView lblArea;
        ImageView imgImage;
    }
}
