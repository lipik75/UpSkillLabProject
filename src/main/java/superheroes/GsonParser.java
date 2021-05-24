package superheroes;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    public HeroesSquad parserGson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("superHeroes.json")) {
            HeroesSquad heroesSquad = gson.fromJson(reader, HeroesSquad.class);
            heroesSquad.setSquadName("NEW_" + heroesSquad.getSquadName());
            heroesSquad.setHomeTown("NEW_" + heroesSquad.getHomeTown());
            return heroesSquad;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
