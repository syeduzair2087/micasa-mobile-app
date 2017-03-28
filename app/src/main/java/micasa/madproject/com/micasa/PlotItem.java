package micasa.madproject.com.micasa;

import java.security.acl.Owner;

/**
 * Created by Syed Uzair Mumtaz on 12/26/2015.
 */
public class PlotItem {
    public int ID, Size;
    public String Name, Location, OwnerName, OwnerEmail, OwnerContact, OwnerLocation, SizeUnit;
    public long Price;
    public boolean Leased;

    public PlotItem(int ID, String Name, String Area, int Size, String SizeUnit, long Price, boolean Leased, String OwnerName, String OwnerEmail, String OwnerContact, String OwnerLocation ) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Area;
        this.Size = Size;
        this.SizeUnit = SizeUnit;
        this.Price = Price;
        this.Leased = Leased;
        this.OwnerName = OwnerName;
        this.OwnerEmail = OwnerEmail;
        this.OwnerContact = OwnerContact;
        this.OwnerLocation = OwnerLocation;
    }
}
