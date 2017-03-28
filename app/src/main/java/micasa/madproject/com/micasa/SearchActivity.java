package micasa.madproject.com.micasa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;

import java.sql.Array;

public class SearchActivity extends Activity{

    String[] Zones = {"Zone 1", "Zone 2"};
    String[] Blocks = {"Block 1", "Block 2"};
    String[] Categories = {"Appartment", "Bungalow"};
    String[] Sizes = {"Size 1", "Size 2"};

    Spinner SpnZones;
    Spinner SpnBlocks;
    Spinner SpnCategories;
    Spinner SpnSizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search");
        getActionBar().setIcon(android.R.color.transparent);
        SpnZones = (Spinner) findViewById(R.id.spnZones);
        SpnBlocks = (Spinner)findViewById(R.id.spnBlock);
        SpnCategories = (Spinner)findViewById(R.id.spnCategory);
        SpnSizes = (Spinner)findViewById(R.id.spnSize);



        ArrayAdapter<String> ZonesAdapter = new ArrayAdapter<String>(this, R.layout.micasa_list_item_1, Zones);
        SpnZones.setAdapter(ZonesAdapter);

        ArrayAdapter<String> BlocksAdapter = new ArrayAdapter<String>(this, R.layout.micasa_list_item_1, Blocks);
        SpnBlocks.setAdapter(BlocksAdapter);

        ArrayAdapter<String> CategoriesAdapter = new ArrayAdapter<String>(this, R.layout.micasa_list_item_1, Categories);
        SpnCategories.setAdapter(CategoriesAdapter);

        ArrayAdapter<String> SizesAdapter = new ArrayAdapter<String>(this, R.layout.micasa_list_item_1, Sizes);
        SpnSizes.setAdapter(SizesAdapter);

    }


}
