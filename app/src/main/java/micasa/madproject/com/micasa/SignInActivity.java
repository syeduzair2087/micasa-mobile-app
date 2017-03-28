package micasa.madproject.com.micasa;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignInActivity extends Activity implements View.OnClickListener{

    TextView AnotherAccount;
    Button btnLogin;
    EditText txtEmail, txtPassword;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation.IsNotEmpty(txtEmail.getText().toString())) {
                    if (Validation.IsValidEmail(txtEmail.getText().toString())) {
                        if (Validation.IsNotEmpty(txtPassword.getText().toString())) {
                            restService = new RestService();
                            restService.GetService().getLoginID(txtEmail.getText().toString(), txtPassword.getText().toString(), new retrofit.Callback<Integer>() {
                                @Override
                                public void success(Integer integer, Response response) {
                                    if (integer != 0) {
                                        Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                        Intent HomeIntent = new Intent(getBaseContext(), HomeActivity.class);
                                        startActivity(HomeIntent);
                                    }
                                    else
                                        Toast.makeText(SignInActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                                }
                                @Override
                                public void failure(RetrofitError error) {
                                }
                            });
                        }
                        else
                            Toast.makeText(SignInActivity.this, "Password cannot be left empty", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SignInActivity.this, "Email is not in a correct format", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SignInActivity.this, "Email cannot be left empty", Toast.LENGTH_SHORT).show();
            }






        });
    }

    @Override
    public void onClick(View v) {

    }
}
