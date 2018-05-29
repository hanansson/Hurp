import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Vorrat {

    public JSONObject produktErstellen(String name, String art, JSONObject produkt) {

        Scanner input = new Scanner(System.in);

        System.out.print("Produktname: ");
        name = input.nextLine();

        System.out.print("Produktart: ");
        art = input.nextLine();

        produkt.put("name", name);
        produkt.put("art", art);

        return produkt;

    }
}
