package TryingJson;
import ProjectJava.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        String jFilePath = "C:\\Users\\Home\\Desktop\\code NOW\\TesdaJava\\LearningJava\\src\\TryingJson\\json folder" +
                "\\sample.json"; //<---- named the json file don't forget
        ArrayList<Item> list1 = new ArrayList<>();

        Item item = new Item(8,"Zero",10);
        list1.add(item);
        Item item1 = new Item(9,"steel",2);
        list1.add(item1);
        Item item2 = new Item(12,"Soda pop",0);
        list1.add(item2);

        try {
            //THIS IS FROM A JAR FILE NAMED JACKSON, total of 3 jar named core, annotation, databind
            ObjectMapper objToJson = new ObjectMapper();

            //CONVERT java Objects to JSON format,basically it reads object in json way
            String jsonString = objToJson.writeValueAsString(list1);


            System.out.println("Convert an arraylist of Item into json file...\n" + jsonString);
            //output: [{"amount":123,"name":"love"},{"amount":321,"name":"evol"}]


            //CREATE a JSON FILE in the specified folder
            System.out.println("\nCreating File in " + jFilePath);
            objToJson.writeValue(new File(jFilePath), list1);
            System.out.println("Status: Success");

            //jsonString = "[{"amount":123,"name":"love"},{"amount":321,"name":"evol"}]"
            ObjectMapper jsonToObj = new ObjectMapper();

            /*System.out.println("\nConverting JSON format into Item Object as list");
            List<Item> list2 = jsonToObj.readValue(jsonString, new TypeReference<List<Item>>() {});
            System.out.println("List size: " + list2.size() + "\nContents");
            for (Item items : list2) {
                System.out.println(items.getName() + " " + items.getAmount());
            }*/

            /*System.out.println("\nConverting JSON format into Item object as Array");
            Item[] items = jsonToObj.readValue(jsonString,Item[].class);
            System.out.println("Array length: " + items.length + "\nContents");
            for(Item i : items) {
                System.out.println(i.getName() + " " + i.getAmount());
            }*/

            System.out.println("\nConverting JSON format into Item object as Arraylist");
            ArrayList<Item> items = jsonToObj.readValue(jsonString, new TypeReference<ArrayList<Item>>(){});
            System.out.println("Arraylist size: " + items.size() + "\nContents");
            for(Item i : items) {
                System.out.println(i.getName() + " " + i.getAmount());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
