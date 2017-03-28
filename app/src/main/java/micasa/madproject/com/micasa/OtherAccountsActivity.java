package micasa.madproject.com.micasa;

import android.app.Activity;
import android.os.Bundle;

public class OtherAccountsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Choose an account");
        getActionBar().setIcon(android.R.color.transparent);
    }
}
