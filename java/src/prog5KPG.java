/*
 * Java portion of Project5
 * CSCI 265
 * Kaleb Gilson - kaleb.gilson@und.edu - 4/21/23
 */

import java.util.ArrayList;
import java.util.HashMap;

public class prog5KPG {

    public static void main(String[] args) {
        HashMap<String, Double> parts = new HashMap<>();
        parts.put("Part1", 57.99);
        parts.put("Part2", 98.5);
        parts.put("Part3", 7.95);
        parts.put("Part4", 19.99);

        System.out.println(addPart(parts, "Part5", 0.01));
        System.out.println(addPart(parts, "Part4", 0.01));
        System.out.println(totalParts(parts));
        System.out.println(partsGreaterThan(parts, 0.02));
        System.out.println(isPart(parts, "Part5"));
        System.out.println(isPart(parts, "Part7"));
        System.out.println(leastExpensivePart(parts));
        System.out.println(mostExpensivePart(parts));
        System.out.println(averagePrice(parts));

        printParts(parts);
    }

    /**
     * Add a part to the parts map
     *
     * @param parts Map to add the part to
     * @param part part to add
     * @param cost cost of the part
     * @return if the part was not already in the list
     */
    public static boolean addPart(HashMap<String, Double> parts, String part, double cost) {
        if (parts.containsKey(part)){
            parts.put(part, cost);
            return false;
        } else {
            parts.put(part, cost);
            return true;
        }
    }

    /**
     * Get the total number of parts in the map
     * @param parts Map of parts
     * @return the total amount of parts
     */
    public static int totalParts(HashMap<String, Double> parts) {
        return parts.size();
    }

    /**
     * Get the parts that are greater than the given limit
     * @param parts Map of parts
     * @param upperLimit Price that the parts must be above
     * @return List of parts above the given limit
     */
    public static ArrayList<String> partsGreaterThan(HashMap<String, Double> parts, double upperLimit) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String key : parts.keySet()) {
            if (parts.get(key) >= upperLimit) {
                arrayList.add(key);
            }
        }

        return arrayList;
    }

    /**
     * Get if the part is in the map
     * @param parts Map of parts
     * @param part Part to query from the map
     * @return If the part is in the map
     */
    public static boolean isPart(HashMap<String, Double> parts, String part) {
        return parts.containsKey(part);
    }

    /**
     * Get the least expensive part in the map
     * @param parts Map of parts
     * @return Least expensive part in the map
     */
    public static String leastExpensivePart(HashMap<String, Double> parts) {
        String part = null;
        double price = 0;
        for (String key : parts.keySet()) {
            if (part == null || parts.get(key) < price) {
                part = key;
                price = parts.get(key);
            }
        }

        return part;
    }

    /**
     * Get the most expensive part in the map
     * @param parts Map of parts
     * @return Most expensive part in the map
     */
    public static String mostExpensivePart(HashMap<String, Double> parts) {
        String part = null;
        double price = 0;
        for (String key : parts.keySet()) {
            if (part == null || parts.get(key) > price) {
                part = key;
                price = parts.get(key);
            }
        }

        return part;
    }

    /**
     * Get the average price of parts in the given map
     * @param parts Map of parts
     * @return The average price of parts in the given map
     */
    public static double averagePrice(HashMap<String, Double> parts) {
        double totalPrices = 0;
        if (parts.size() == 0) return -1;
        for (String key : parts.keySet()) {
            totalPrices += parts.get(key);
        }

        return totalPrices / parts.size();
    }

    /**
     * A formatted list of parts and their prices
     * @param parts Map of parts
     */
    public static void printParts(HashMap<String, Double> parts) {
        System.out.printf("%-15s %10s%n", "Part", "Price");
        System.out.println("------------------------------");

        for (String key : parts.keySet()) {
            System.out.printf("%-15s %10.2f%n", key, parts.get(key));
        }
    }
}
