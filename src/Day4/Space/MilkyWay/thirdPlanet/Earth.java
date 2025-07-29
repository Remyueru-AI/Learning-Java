package Day4.Space.MilkyWay.thirdPlanet;

import Day4.Space.MilkyWay.fourthPlanet.Mars;

public class Earth {
    public static void main(String[] args) {
        System.out.println("We are at earth.");
        Moon moon = new Moon();
        moon.moonFacts();

        Mars mars = new Mars();
        mars.isLanded();

    }

}
