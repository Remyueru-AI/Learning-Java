package Day4.Space.MilkyWay.fourthPlanet;

public class Phobos {
    private static String phobosInfo = "Phobos a satellite of mars together with daimos";
    Phobos(){
         System.out.println(phobosInfo);
         System.out.println("Does someeone landed here at phobos: "+ isLanded());
    }

     static boolean isLanded(){
         boolean landed = true;
         return landed;
    }
}
