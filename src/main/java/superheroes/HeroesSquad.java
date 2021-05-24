package superheroes;

import java.util.List;

public class HeroesSquad {

    private String squadName;
    private String homeTown;
    private List<Heroes> members;

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public List<Heroes> getMembers() {
        return members;
    }

    public void setMembers(List<Heroes> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "\n" + "squadName -> " + squadName + "\n" +
                "homeTown -> " + homeTown + "\n" +
                "MEMBERS: " + members;
    }
}
