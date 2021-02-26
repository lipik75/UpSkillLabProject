package superheroes;

import com.google.gson.Gson;

import java.io.FileReader;

public class GsonParser {
    public HeroesSquad parserGson() {

        Gson gson = new Gson();
        try (FileReader reader = new FileReader("superHeroes.json")) {
            HeroesSquad heroesSquad = gson.fromJson(reader, HeroesSquad.class);
            heroesSquad.setSquadName("NEW_" + heroesSquad.getSquadName());
            heroesSquad.setHomeTown("NEW_" + heroesSquad.getHomeTown());
            return heroesSquad;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
