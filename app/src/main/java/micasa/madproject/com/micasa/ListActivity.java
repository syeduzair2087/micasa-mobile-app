package micasa.madproject.com.micasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public class ListActivity extends Activity {

    TextView lblListTitle;
    ArrayAdapter<PropertyItem> PropertyAdapter;
    RestService restService;
    ListView lstProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lblListTitle = (TextView)findViewById(R.id.lblListTitle);
        lstProperties = (ListView)findViewById(R.id.lstProperties);

        Intent ThisIntent = getIntent();

        final String Type = ThisIntent.getStringExtra("type");
        String ApiName = GetApiName(Type);

        lblListTitle.setText(Type);

        restService = new RestService();

        restService.GetPropertyService().getAllPlots(ApiName, new retrofit.Callback<ArrayList<PropertyItem>>()
        {

         @Override
         public void success(ArrayList<PropertyItem> propertyItems, Response response) {
             Toast.makeText(ListActivity.this, "Successfully loaded!", Toast.LENGTH_SHORT).show();
             lstProperties.setAdapter(new PropertyItemAdapter(getBaseContext(), propertyItems));
         }

         @Override
         public void failure(RetrofitError error) {
             Toast.makeText(ListActivity.this, "Failed to load!", Toast.LENGTH_SHORT).show();
         }
         }
        );

        lstProperties.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtID = (TextView) view.findViewById(R.id.lblID);
                String ID = txtID.getText().toString();

                Intent DescriptionIntent = new Intent(getBaseContext(), DescriptionActivity.class);
                DescriptionIntent.putExtra("property_id", ID);
                DescriptionIntent.putExtra("property_type", GetApiName(Type));

                startActivity(DescriptionIntent);

//                Toast.makeText(getBaseContext(), ID, Toast.LENGTH_SHORT).show();
            }
        });

    }



    private String GetApiName(String SelectedType) {
        if(SelectedType.equals("Plot"))
            return "plot";

        else if(SelectedType.equals("Appartment"))
            return "appartment";

        else if(SelectedType.equals("House Full"))
            return "house_full";

        else if(SelectedType.equals("House Portion"))
            return "house_portion";

        else
            return "";
    }
}
