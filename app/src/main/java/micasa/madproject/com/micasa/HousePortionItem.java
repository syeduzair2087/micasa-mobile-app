package micasa.madproject.com.micasa;

/**
 * Created by Syed Uzair Mumtaz on 12/26/2015.
 */
public class HousePortionItem {
    public int ID, Size, Floor, Rooms;
    public String Name, Location, OwnerName, OwnerEmail, OwnerContact, OwnerLocation, SizeUnit, Type;
    public long Price;

    public HousePortionItem(int ID, String Name, String Area, int Size, String SizeUnit, long Price, String Type,  int Floor, int Rooms, String OwnerName, String OwnerEmail, String OwnerContact, String OwnerLocation ) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Area;
        this.Size = Size;
        this.SizeUnit = SizeUnit;
        this.Price = Price;
        this.Type = Type;
        this.Floor = Floor;
        this.Rooms = Rooms;
        this.OwnerName = OwnerName;
        this.OwnerEmail = OwnerEmail;
        this.OwnerContact = OwnerContact;
        this.OwnerLocation = OwnerLocation;
    }
}
