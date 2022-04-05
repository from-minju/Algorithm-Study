

class Planet {
    String name;
    int moons;

    Planet(String name, int moons){
        this.name = name;
        this.moons = moons;
    }
}

public class n45 {
    public static void main(String[] args) {
        Planet[] planets = {
                new Planet("Mercury", 0),
                new Planet("Venus", 0),
                new Planet("Earth", 1),
                new Planet("Mars", 2)
        };

        System.out.println(planets);
        System.out.println(planets[2].name);
        System.out.println(planets[2].moons);
    }
}

