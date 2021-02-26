package superheroes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {
    HeroesSquad squad = new HeroesSquad();

    public HeroesSquad parser() {
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("superHeroes.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String nameSquad = (String) jsonObject.get("squadName");
            String homeTown = (String) jsonObject.get("homeTown");

            JSONArray heroesArray = (JSONArray) jsonObject.get("members");

            List<Heroes> heroesList = new ArrayList<>();

            for (Object heroes : heroesArray) {
                JSONObject heroe = (JSONObject) heroes;

                String nameHeroe = (String) heroe.get("name");
                Long ageHeroe = (Long) heroe.get("age");
                String secretIdentityHeroe = (String) heroe.get("secretIdentity");
                String powerHeroe = (String) heroe.get("power");

                Heroes heroesNew = new Heroes(nameHeroe, ageHeroe, secretIdentityHeroe, powerHeroe);
                heroesList.add(heroesNew);
            }



            squad.setSquadName("NEW_" + nameSquad);
            squad.setHomeTown("NEW_" + homeTown);
            squad.setMembers(heroesList);


            return squad;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
