import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Produkterstellung {

    public static void main(String[] args) throws IOException {

        String name = "";

        String art = "";

        Vorrat v = new Vorrat();

        JSONObject produkt = new JSONObject();

        v.produktErstellen(name, art, produkt);

        JSONArray produktliste = new JSONArray();
        produktliste.add(produkt);

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
        JSONObject jsonObject;

        try {

            String s;

            br = new BufferedReader(new FileReader("Vorratsliste.json"));

            while ((s = br.readLine()) != null) {

                Object obj;

                try {
                    obj = parser.parse(s);
                    jsonObject = (JSONObject) obj;
                    produktliste.add(jsonObject);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            } catch(IOException e){
                e.printStackTrace();
            } finally{
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.print(produktliste.size());
            }
        }
    }
