import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Reducer {
    public static void main(String[] args) {   

        Map<String, Integer> line_counts = new HashMap<>();
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

            String line = input.nextLine().trim();
            
            String[] splits = line.split("\t");
            String filename = splits[0];
            int add = Integer.parseInt(splits[1]);

            if (line_counts.containsKey(filename)) {
                int count = line_counts.get(filename);
                line_counts.put(filename, count + add);
            } else {
                line_counts.put(filename, add);
            }
        }

        for (Map.Entry<String, Integer> entry : line_counts.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}