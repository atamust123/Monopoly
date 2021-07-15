
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileReaders {

    public FileReaders(Everything p[], ChanceList cl,
            CommunityChestList ccl) throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("property.json"));

        JSONArray msg = (JSONArray) jsonObject.get("1");
        Iterator<JSONObject> iterator = msg.iterator();
        while (iterator.hasNext()) {
            JSONObject jtemp = iterator.next();
            int id = Integer.parseInt((String) jtemp.get("id"));
            String name = (String) jtemp.get("name");
            double cost = Double.parseDouble((String) jtemp.get("cost"));
            p[id] = new Land(name, id, cost);
        }

        msg = (JSONArray) jsonObject.get("2");
        iterator = msg.iterator();
        while (iterator.hasNext()) {
            JSONObject jtemp = iterator.next();
            int id = Integer.parseInt((String) jtemp.get("id"));
            String name = (String) jtemp.get("name");
            double cost = Double.parseDouble((String) jtemp.get("cost"));
            p[id] = new RailRoad(name, id, cost);
        }

        msg = (JSONArray) jsonObject.get("3");
        iterator = msg.iterator();
        while (iterator.hasNext()) {
            JSONObject jtemp = iterator.next();
            int id = Integer.parseInt((String) jtemp.get("id"));
            String name = (String) jtemp.get("name");
            double cost = Double.parseDouble((String) jtemp.get("cost"));
            p[id] = new Company(name, id, cost);
        }

        
        p[1] = new Everything("GO",1);
        //look 
        
        p[18] = new Everything("Community Chest",18);
        p[3] = new Everything("Community Chest",3);
        p[34] = new Everything("Community Chest",34);
        
        p[5] = new Everything("Income Tax",5);  
        p[39] = new Everything("Super Tax",39);
        
        p[31] = new Everything("Go to Jail",31);
        p[11] = new Everything("Jail",11);
        //look
        
        p[21] = new Everything("Free Parking",21);
        //look
        
        p[8] = new Everything("Chance",8);
        p[23] = new Everything("Chance",23);
        p[37] = new Everything("Chance",37);
        
        
        jsonObject = (JSONObject) parser.parse(new FileReader("list.json"));
        msg = (JSONArray) jsonObject.get("chanceList");
        iterator = msg.iterator();
        while (iterator.hasNext()) {
            JSONObject jtemp = iterator.next();
            cl.setItem((String) jtemp.get("item"));
        }
        cl.setCounter(0);

        msg = (JSONArray) jsonObject.get("communityChestList");
        iterator = msg.iterator();
        while (iterator.hasNext()) {
            JSONObject jtemp = iterator.next();
            ccl.setItem((String) jtemp.get("item"));
        }
        ccl.setCounter(0);

    }

}
