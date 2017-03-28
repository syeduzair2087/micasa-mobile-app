package micasa.madproject.com.micasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public class HomeActivity extends Activity {

    Button btnHouseFull, btnHousePortion, btnAppartment, btnPlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnHouseFull = (Button)findViewById(R.id.btnHouseFull);
        btnHousePortion = (Button)findViewById(R.id.btnHousePortion);
        btnAppartment = (Button)findViewById(R.id.btnAppartment);
        btnPlot = (Button)findViewById(R.id.btnPlot);

        btnHouseFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HouseFullIntent = new Intent(getBaseContext(), ListActivity.class);
                HouseFullIntent.putExtra("type", "House Full");
                startActivity(HouseFullIntent);
            }
        });

        btnHousePortion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HousePortionIntent = new Intent(getBaseContext(), ListActivity.class);
                HousePortionIntent.putExtra("type", "House Portion");
                startActivity(HousePortionIntent);
            }
        });

        btnAppartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppartmentIntent = new Intent(getBaseContext(), ListActivity.class);
                AppartmentIntent.putExtra("type", "Appartment");
                startActivity(AppartmentIntent);
            }
        });

        btnPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PlotIntent = new Intent(getBaseContext(), ListActivity.class);
                PlotIntent.putExtra("type", "Plot");
                startActivity(PlotIntent);
            }
        });
    }
}
