package superheroes;

public class HeroesMain {
    public static void main(String[] args) {
        JsonParser heroesParser = new JsonParser();
        HeroesSquad heroesSquad1 = heroesParser.parser();
        System.out.println("New Name Squad: " + heroesSquad1.toString());

        System.out.println("-------------------------------------------------------------");

        GsonParser gsonParser = new GsonParser();
        HeroesSquad heroesSquad2 = gsonParser.parserGson();
        System.out.println("New Name Squad (GSON): " + heroesSquad2.toString());
    }
}
