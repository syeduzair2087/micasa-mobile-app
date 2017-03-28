package micasa.madproject.com.micasa;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public class PropertyItem {
    public int ID;
    public String Name, Area, Image;
    public long Price;

    public PropertyItem(int ID, String Name, long Price, String Area, String Image) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Area = Area;
        this.Image = Image;
    }

}