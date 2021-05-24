package superheroes;

public class Heroes {
    private String name;
    private Long age;
    private String secretIdentity;
    private String power;

    public Heroes(String name, Long age, String secretIdentity, String power) {
        this.name = name;
        this.age = age;
        this.secretIdentity = secretIdentity;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public String getPowers() {
        return power;
    }

    @Override
    public String toString() {
        return  "\n" + "name = '" + name + '\'' + "\n" +
                "age = " + age + "\n" +
                "secretIdentity = '" + secretIdentity + '\'' + "\n" +
                "power = '" + power + '\'' + '}' + "\n" + "==========================";
    }
}
