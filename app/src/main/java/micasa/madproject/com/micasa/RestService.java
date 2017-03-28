package micasa.madproject.com.micasa;

import retrofit.RestAdapter;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public class RestService {
    private static final String URL = "http://192.168.75.1/";
    private RestAdapter restAdapter;
    private LoginService LoginApi;
    private PropertyService PropertyApi;

    public RestService()
    {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        LoginApi = restAdapter.create(LoginService.class);
        PropertyApi = restAdapter.create(PropertyService.class);
    }

    public LoginService GetService()
    {
        return LoginApi;
    }
    public PropertyService GetPropertyService() { return PropertyApi; }
}
