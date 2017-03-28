package micasa.madproject.com.micasa;

/**
 * Created by Syed Uzair Mumtaz on 12/24/2015.
 */
public class Validation {
    public static boolean IsNotEmpty(String Value)
    {
        return !Value.isEmpty();
    }

    public static boolean IsValidEmail(String email)
    {
        return email.matches("\\S+@\\S+.\\.\\S+");
    }
}
