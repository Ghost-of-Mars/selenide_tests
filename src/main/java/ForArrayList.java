import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ForArrayList {


    public static void main(String[] args) {

        //ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Antony");
        arrayList.add("Mark");
        arrayList.add(1, "Maria");
        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println();
        arrayList.remove(0);
        arrayList.remove("Mark");
        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println(arrayList.get(0));

        //Maps
        Map<Integer, String> mapIntStr = new HashMap<>();
        mapIntStr.put(1, "Nope");
        mapIntStr.put(2, "Nop");
        mapIntStr.put(3, "No");
        mapIntStr.put(4, "N");
        mapIntStr.put(5, "");
        mapIntStr.put(6, null);
        mapIntStr.put(7, null);

        System.out.println(mapIntStr);

        for (Integer integer : mapIntStr.keySet()) {
            System.out.println(integer);
        }
        System.out.println();

        for (String value : mapIntStr.values()) {
            System.out.println(value);
        }

        mapIntStr.remove(7);
        mapIntStr.remove(5, "");

        System.out.println("asdfgasdf" + mapIntStr.get(48));
        System.out.println(mapIntStr.getOrDefault(8, "lol"));

        TreeMap<Integer, String> stringMap = new TreeMap<>();
        stringMap.put(56, "a");
        stringMap.put(5, "a");
        stringMap.put(6, "a");
        stringMap.put(560, "a");
        stringMap.put(561, "a");

        System.out.println(stringMap);
        System.out.println(stringMap.descendingMap());
        System.out.println(stringMap.headMap(10));
        System.out.println(stringMap.descendingMap().headMap(10));
        System.out.println(stringMap.tailMap(10));
        System.out.println(stringMap.descendingMap().tailMap(10));

        System.out.println(stringMap.isEmpty());

    }
}
