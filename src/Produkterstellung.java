
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;

public class Produkterstellung {

    public static void main(String[] args) throws IOException {

        String name = "";
        String art = "";
        Vorrat v = new Vorrat();

        ArrayList<Vorrat1> vorratsliste = new ArrayList<>();

        JSONObject produkt = new JSONObject();

        v.jsonProduktErstellen(name, art, produkt);


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

        BufferedReader br = null;
        JSONParser parser = new JSONParser();

        try {

            String s;

            br = new BufferedReader(new FileReader("Vorratsliste.json"));

            while ((s = br.readLine()) != null) {


                try {
                    produkt = (JSONObject) parser.parse(s);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                String name1 = (String) produkt.get("name");
                String art1 = (String) produkt.get("art");

                Vorrat1 produkt1 = new Vorrat1();
                produkt1.name = name1;
                produkt1.art = art1;
                vorratsliste.add(produkt1);



            }

            } catch(IOException e){
                e.printStackTrace();
            } finally{
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

            System.out.print(vorratsliste);


        }
    }
