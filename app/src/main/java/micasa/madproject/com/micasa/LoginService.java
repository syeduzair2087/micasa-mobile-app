package micasa.madproject.com.micasa;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public interface LoginService {
    @GET("/api/login/{email}/{password}")
    public void getLoginID(@Path("email") String Email, @Path("password") String Password, Callback<Integer> callback);
}
