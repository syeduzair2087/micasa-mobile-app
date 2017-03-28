package micasa.madproject.com.micasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Syed Uzair Mumtaz on 12/25/2015.
 */
public class DescriptionActivity extends Activity {

    TextView lblTitle, lblPropertyType, lblPropertyLocationValue, lblPropertySizeValue, lblPropertyPriceValue, lblOwnerNameValue, lblOwnerEmailValue, lblOwnerContactValue, lblOwnerLocationValue, lblLeased, lblLeasedValue, lblApptName, lblApptNameValue, lblApptBlock, lblApptBlockValue, lblApptFloor, lblApptFloorValue, lblApptRooms, lblApptRoomsValue, lblHouseFloors, lblHouseFloorsValue, lblHouseFloor, lblHouseFloorValue, lblHouseRooms, lblHouseRoomsValue;

    int PropertyID;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent thisIntent = getIntent();
        String id = thisIntent.getStringExtra("property_id");
        String type = thisIntent.getStringExtra("property_type");
        PropertyID = Integer.parseInt(id);

        lblTitle = (TextView)findViewById(R.id.lblTitle);
        lblPropertyType = (TextView)findViewById(R.id.lblType);
        lblPropertyLocationValue = (TextView)findViewById(R.id.lblLocationValue);
        lblPropertySizeValue = (TextView)findViewById(R.id.lblSizeValue);
        lblPropertyPriceValue = (TextView)findViewById(R.id.lblPriceValue);
        lblOwnerNameValue = (TextView)findViewById(R.id.lblOwnerNameValue);
        lblOwnerEmailValue = (TextView)findViewById(R.id.lblOwnerEmailValue);
        lblOwnerContactValue = (TextView)findViewById(R.id.lblOwnerContactValue);
        lblOwnerLocationValue = (TextView)findViewById(R.id.lblOwnerLocationValue);
        lblLeasedValue = (TextView)findViewById(R.id.lblLeasedValue);
        lblLeased = (TextView)findViewById(R.id.lblLeased);
        lblApptName = (TextView)findViewById(R.id.lblApptName);
        lblApptNameValue = (TextView)findViewById(R.id.lblApptNameValue);
        lblApptBlock = (TextView)findViewById(R.id.lblApptBlock);
        lblApptBlockValue = (TextView)findViewById(R.id.lblApptBlockValue);
        lblApptFloor = (TextView)findViewById(R.id.lblApptFloor);
        lblApptFloorValue = (TextView)findViewById(R.id.lblApptFloorValue);
        lblApptRooms = (TextView)findViewById(R.id.lblApptRooms);
        lblApptRoomsValue = (TextView)findViewById(R.id.lblApptRoomsValue);
        lblHouseFloors = (TextView)findViewById(R.id.lblHouseFloors);
        lblHouseFloorsValue = (TextView)findViewById(R.id.lblHouseFloorsValue);
        lblHouseFloor = (TextView)findViewById(R.id.lblHouseFloor);
        lblHouseFloorValue = (TextView)findViewById(R.id.lblHouseFloorValue);
        lblHouseRooms = (TextView)findViewById(R.id.lblHouseRooms);
        lblHouseRoomsValue = (TextView)findViewById(R.id.lblHouseRoomsValue);


        if(type.equals("plot"))
        {
            restService = new RestService();

            restService.GetPropertyService().getPlotByID(PropertyID, new retrofit.Callback<PlotItem>()
            {

                @Override
                public void success(PlotItem plotItem, Response response) {
                    Toast.makeText(getBaseContext(), "Rest Called", Toast.LENGTH_SHORT).show();
                    lblTitle.setText(plotItem.Name);
                    lblPropertyLocationValue.setText(plotItem.Location);
                    lblPropertySizeValue.setText(plotItem.Size + " " + plotItem.SizeUnit);
                    lblPropertyPriceValue.setText("PKR. " + plotItem.Price);
                    lblLeasedValue.setText(GetLeased(plotItem.Leased));
                    lblLeased.setVisibility(View.VISIBLE);
                    lblLeasedValue.setVisibility(View.VISIBLE);
                    lblOwnerNameValue.setText(plotItem.OwnerName);
                    lblOwnerEmailValue.setText(plotItem.OwnerEmail);
                    lblOwnerContactValue.setText(plotItem.OwnerContact);
                    lblOwnerLocationValue.setText(plotItem.OwnerLocation);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DescriptionActivity.this, "Receive failed", Toast.LENGTH_SHORT).show();
                }
            });

        }

        else if(type.equals("appartment"))
        {
            restService = new RestService();

            restService.GetPropertyService().getAppartmentByID(PropertyID, new retrofit.Callback<AppartmentItem>() {

                @Override
                public void success(AppartmentItem appartmentItem, Response response) {
                    Toast.makeText(getBaseContext(), "Rest Called", Toast.LENGTH_SHORT).show();
                    lblTitle.setText(appartmentItem.Name);
                    lblPropertyLocationValue.setText(appartmentItem.Location);
                    lblPropertySizeValue.setText(appartmentItem.Size + " " + appartmentItem.SizeUnit);
                    lblPropertyPriceValue.setText("PKR. " + appartmentItem.Price);

                    lblPropertyType.setText("For " + appartmentItem.Type);
                    lblPropertyType.setVisibility(View.VISIBLE);

                    lblApptNameValue.setText(appartmentItem.AppartmentName);
                    lblApptName.setVisibility(View.VISIBLE);
                    lblApptNameValue.setVisibility(View.VISIBLE);

                    lblApptBlockValue.setText(appartmentItem.Block);
                    lblApptBlock.setVisibility(View.VISIBLE);
                    lblApptBlockValue.setVisibility(View.VISIBLE);

                    lblApptFloorValue.setText(appartmentItem.Floor + "");
                    lblApptFloor.setVisibility(View.VISIBLE);
                    lblApptFloorValue.setVisibility(View.VISIBLE);

                    lblApptRoomsValue.setText(appartmentItem.Rooms + "");
                    lblApptRooms.setVisibility(View.VISIBLE);
                    lblApptRoomsValue.setVisibility(View.VISIBLE);

                    lblOwnerNameValue.setText(appartmentItem.OwnerName);
                    lblOwnerEmailValue.setText(appartmentItem.OwnerEmail);
                    lblOwnerContactValue.setText(appartmentItem.OwnerContact);
                    lblOwnerLocationValue.setText(appartmentItem.OwnerLocation);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DescriptionActivity.this, "Receive failed", Toast.LENGTH_SHORT).show();
                }
            });

        }

        else if(type.equals("house_full"))
        {
            restService = new RestService();

            restService.GetPropertyService().getHouseFullByID(PropertyID, new retrofit.Callback<HouseFullItem>() {

                @Override
                public void success(HouseFullItem houseFullItem, Response response) {
                    Toast.makeText(getBaseContext(), "Rest Called", Toast.LENGTH_SHORT).show();
                    lblTitle.setText(houseFullItem.Name);
                    lblPropertyLocationValue.setText(houseFullItem.Location);
                    lblPropertySizeValue.setText(houseFullItem.Size + " " + houseFullItem.SizeUnit);
                    lblPropertyPriceValue.setText("PKR. " + houseFullItem.Price);

                    lblPropertyType.setText("For " + houseFullItem.Type);
                    lblPropertyType.setVisibility(View.VISIBLE);

                    lblHouseFloorsValue.setText(houseFullItem.Floors + "");
                    lblHouseFloors.setVisibility(View.VISIBLE);
                    lblHouseFloorsValue.setVisibility(View.VISIBLE);

                    lblHouseRoomsValue.setText(houseFullItem.Rooms + "");
                    lblHouseRooms.setVisibility(View.VISIBLE);
                    lblHouseRoomsValue.setVisibility(View.VISIBLE);

                    lblOwnerNameValue.setText(houseFullItem.OwnerName);
                    lblOwnerEmailValue.setText(houseFullItem.OwnerEmail);
                    lblOwnerContactValue.setText(houseFullItem.OwnerContact);
                    lblOwnerLocationValue.setText(houseFullItem.OwnerLocation);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DescriptionActivity.this, "Receive failed", Toast.LENGTH_SHORT).show();
                }
            });

        }

        else if(type.equals("house_portion"))
        {
            restService = new RestService();

            restService.GetPropertyService().getHousePortionByID(PropertyID, new retrofit.Callback<HousePortionItem>() {

                @Override
                public void success(HousePortionItem housePortionItem, Response response) {
                    Toast.makeText(getBaseContext(), "Rest Called", Toast.LENGTH_SHORT).show();
                    lblTitle.setText(housePortionItem.Name);
                    lblPropertyLocationValue.setText(housePortionItem.Location);
                    lblPropertySizeValue.setText(housePortionItem.Size + " " + housePortionItem.SizeUnit);
                    lblPropertyPriceValue.setText("PKR. " + housePortionItem.Price);

                    lblPropertyType.setText("For " + housePortionItem.Type);
                    lblPropertyType.setVisibility(View.VISIBLE);

                    lblHouseFloorValue.setText(housePortionItem.Floor + "");
                    lblHouseFloor.setVisibility(View.VISIBLE);
                    lblHouseFloorValue.setVisibility(View.VISIBLE);

                    lblHouseRoomsValue.setText(housePortionItem.Rooms + "");
                    lblHouseRooms.setVisibility(View.VISIBLE);
                    lblHouseRoomsValue.setVisibility(View.VISIBLE);

                    lblOwnerNameValue.setText(housePortionItem.OwnerName);
                    lblOwnerEmailValue.setText(housePortionItem.OwnerEmail);
                    lblOwnerContactValue.setText(housePortionItem.OwnerContact);
                    lblOwnerLocationValue.setText(housePortionItem.OwnerLocation);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DescriptionActivity.this, "Receive failed", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private String GetLeased(boolean Leased)
    {
        if(Leased)
            return "Yes";

        else
            return "No";
    }
}
