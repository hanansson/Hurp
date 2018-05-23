import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.Scanner;

public class Produkterstellung {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.print("Produktname: ");

        String name = input.nextLine();
        JSONArray produktliste = new JSONArray();
        System.out.print("Produktart: ");

        String art = input.nextLine();

        JSONObject produkt = new JSONObject();
        produkt.put("name", name);
        produkt.put("art", art);

        JSONArray produtkliste = new JSONArray();
        produtkliste.add(produkt);

        System.out.print(produkt.get("name"));

        File f = new File("Vorratsliste.json");
        if (f.exists()) {

            FileWriter fw = new FileWriter("Vorratsliste.json", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(produkt.toJSONString());
            bw.close();

        } else {

            FileWriter fw = new FileWriter("Vorratsliste.json", true);
            fw.write(produkt.toJSONString());
            fw.close();

        }
    }
}
