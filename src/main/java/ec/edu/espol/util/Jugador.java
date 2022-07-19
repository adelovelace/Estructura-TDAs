package ec.edu.espol.util;

public class Jugador {

    private String name;
    private String team;
    private String position;
    private double heightInches;
    private double weightLbs;
    private double age;

    public Jugador(String name, String team, String position, double heightInches, double weightLbs, double age){
        this.name = name;
        this.team = team;
        this.position = position;
        this.heightInches = heightInches;
        this.weightLbs = weightLbs;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(int weightLbs) {
        this.weightLbs = weightLbs;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
