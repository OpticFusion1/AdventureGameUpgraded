package abc;


import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {


        //SERIALIZATION
        try(ObjectOutputStream doPliku=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for(Location location: locations.values()) {
                doPliku.writeObject(location);

            }
        }




        //BYTE STREAM
//        try(DataOutputStream doPliku=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//
//            for(Location location : locations.values()) {
//                doPliku.writeInt(location.getLocationID());
//                doPliku.writeUTF(location.getDescription());
//                System.out.println("Writing location: "+ location.getLocationID() +" : "+ location.getDescription());
//                System.out.println("Writing "+ (location.getExits().size() -1)+" exits.");
//                doPliku.writeInt(location.getExits().size()-1);
//                for(String kierunek: location.getExits().keySet()) {
//                    if(!kierunek.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + kierunek + ","+location.getExits().get(kierunek));
//                        doPliku.writeUTF(kierunek);
//                        doPliku.writeInt(location.getExits().get(kierunek));
//                    }
//                }
//            }
//
//        }


        //TEXT STREAM
//        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//        BufferedWriter dirFile= new BufferedWriter(new FileWriter("directions.txt"))) {
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID()+ ","+direction +","+ location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }
//
    }

    static {

        try(ObjectInputStream odczytPliku = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
boolean eof=false;
while(!eof) {
    try {
Location location = (Location) odczytPliku.readObject();
locations.put(location.getLocationID(), location);

    }
    catch(EOFException e ) {
        eof=true;
    }
}
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }


//        try(DataInputStream odczytPliku = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//boolean eof=false;
//            while(!eof) {
//                try {
//
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int odczytPlikuID=odczytPliku.readInt();
//                    String description= odczytPliku.readUTF();
//                    int iloscWyjsc=odczytPliku.readInt();
//                    System.out.println("ilosc wyjsc: "+ iloscWyjsc);
//                    for(int i=0;i<iloscWyjsc;i++) {
//                        String direction = odczytPliku.readUTF();
//                        int destination = odczytPliku.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("Direction= "+direction+"destination= "+destination);
//                    }
//                    locations.put(odczytPlikuID,new Location(odczytPlikuID,description,exits));
//                }catch(EOFException ex) {
//                    eof=true;
//                }
//                }
//
//
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }








//        try(Scanner scanner= new Scanner(new BufferedReader(new FileReader("locations.txt")));
//            Scanner scannery = new Scanner(new BufferedReader(new FileReader("directions.txt"))))
//        {
//
//            scanner.useDelimiter(",");
//            scannery.useDelimiter(",");
//
//            while(scanner.hasNextLine()) {
//                int figure=scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String loca=scanner.nextLine();
//                System.out.println("Imported loca: "+loca+" number: "+figure);
//                Map<String,Integer> tempExit = new HashMap<>();
//
//                locations.put(figure, new Location(figure, loca, tempExit));
//            }
//
//            while(scannery.hasNextLine()) {
//                int fig=scannery.nextInt();
//                scannery.skip(scannery.delimiter());
//                String dupa=scannery.next();
//                scannery.skip(scannery.delimiter());
//                String dest=scannery.nextLine();
//                int desty= Integer.parseInt(dest);
//                System.out.println("nothing happened");
//                Location location=locations.get(fig);
//                location.addExit(dupa,desty);
//            }
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
        }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
