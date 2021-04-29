package superheroes;

import java.util.logging.Logger;

public class HeroesMain {
    private static final Logger LOGGER = Logger.getLogger(HeroesMain.class.getSimpleName());

    public static void main(String[] args) {

        try {
            LOGGER.info("start method main()");
            JsonParser heroesParser = new JsonParser();
            LOGGER.info("object type JsonParser created");
            Thread.sleep(1000);
            HeroesSquad heroesSquad1 = heroesParser.parser();
            LOGGER.info("created list Squad.json");
            Thread.sleep(1000);
            System.out.println("New Name Squad: " + heroesSquad1.toString());
            LOGGER.info("print list Squad");
            Thread.sleep(1000);

            System.out.println("-------------------------------------------------------------");
            LOGGER.info("start Gson parser program");
            Thread.sleep(1000);
            GsonParser gsonParser = new GsonParser();
            LOGGER.info("created object GsonParser");
            Thread.sleep(1000);

            HeroesSquad heroesSquad2 = gsonParser.parserGson();
            LOGGER.info("rename file name");
            Thread.sleep(1000);
            LOGGER.info("print new name from Gson");
            System.out.println("New Name Squad (GSON): " + heroesSquad2.toString());
            Thread.sleep(1000);

        } catch (Throwable e) {
            LOGGER.throwing(HeroesMain.class.getSimpleName(), "main", e);
        }
        LOGGER.info("program stopped to work");


    }
}
