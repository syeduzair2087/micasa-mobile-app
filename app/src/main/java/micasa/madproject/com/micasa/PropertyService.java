package micasa.madproject.com.micasa;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public interface PropertyService {
    @GET("/api/{type}")
    public void getAllPlots(@Path("type") String Type, Callback <ArrayList<PropertyItem>> callback);

    @GET("/api/plot/{id}")
    public void getPlotByID(@Path("id") int ID, Callback <PlotItem> callback);

    @GET("/api/appartment/{id}")
    public void getAppartmentByID(@Path("id") int ID, Callback <AppartmentItem> callback);

    @GET("/api/house_full/{id}")
    public void getHouseFullByID(@Path("id") int ID, Callback <HouseFullItem> callback);

    @GET("/api/house_portion/{id}")
    public void getHousePortionByID(@Path("id") int ID, Callback <HousePortionItem> callback);
}
