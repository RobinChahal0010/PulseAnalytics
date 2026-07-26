import java.util.*;

public class Main {

    static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==== PulseAnalytics ====");
            System.out.println("1. Add Data");
            System.out.println("2. Show Frequency");
            System.out.println("3. Show Grouped Frequency");
            System.out.println("4. Show Top Trend");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addData(sc);
                    break;

                case 2:
                    showFrequency();
                    break;

                case 3:
                    showGroupedFrequency();
                    break;

                case 4:
                    showTopTrend();
                    break;

                case 5:
                    System.out.println("Exiting PulseAnalytics...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void addData(Scanner sc) {

        System.out.print("Enter Data: ");
        String input = sc.nextLine().toLowerCase();

        data.add(input);

        System.out.println("Data Added Successfully!");
    }

    
    public static HashMap<String, Integer> buildFrequencyMap() {
        // to preserve order 
        HashMap<String, Integer> freq = new LinkedHashMap<>();

        for (String item : data) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        return freq;
    }

    
    public static void showFrequency() {

        HashMap<String, Integer> freq = buildFrequencyMap();

        if (freq.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        System.out.println("\n=== Frequency Analysis ===");
        freq.entrySet()
        .stream()
        .sorted((a, b) -> b.getValue(

        
    }

    
    public static void showGroupedFrequency() {

        HashMap<String, Integer> freq = buildFrequencyMap();

        if (freq.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        HashMap<Integer, ArrayList<String>> grouped = new HashMap<>();

        for (String key : freq.keySet()) {

            int count = freq.get(key);

            if (!grouped.containsKey(count)) {
                grouped.put(count, new ArrayList<>());
            }

            grouped.get(count).add(key);
        }

        System.out.println("\n=== Grouped Frequency ===");

        for (int count : grouped.keySet()) {
            System.out.println(count + " -> " + grouped.get(count));
        }
    }

    
    public static void showTopTrend() {

        HashMap<String, Integer> freq = buildFrequencyMap();

        if (freq.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        int max = Collections.max(freq.values());
        System.out.println("\n=== Top Trends ===");

        for(Map.Entry<String,Integer> entry : freq.entrySet()) {

            if (entry.getValue() == max) {
                 System.out.println(entry.getKey()+" -> "+entry.getValue());
            }
        }

        System.out.println("\n=== Top Trend ===");
        System.out.println(trend + " -> " + max);
    }
}
