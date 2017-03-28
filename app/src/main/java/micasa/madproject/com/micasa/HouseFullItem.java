package micasa.madproject.com.micasa;

/**
 * Created by Syed Uzair Mumtaz on 12/26/2015.
 */
public class HouseFullItem {
    public int ID, Size, Floors, Rooms;
    public String Name, Location, OwnerName, OwnerEmail, OwnerContact, OwnerLocation, SizeUnit, Type;
    public long Price;

    public HouseFullItem(int ID, String Name, String Area, int Size, String SizeUnit, long Price, String Type,  int Floors, int Rooms, String OwnerName, String OwnerEmail, String OwnerContact, String OwnerLocation ) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Area;
        this.Size = Size;
        this.SizeUnit = SizeUnit;
        this.Price = Price;
        this.Type = Type;
        this.Floors = Floors;
        this.Rooms = Rooms;
        this.OwnerName = OwnerName;
        this.OwnerEmail = OwnerEmail;
        this.OwnerContact = OwnerContact;
        this.OwnerLocation = OwnerLocation;
    }
}
