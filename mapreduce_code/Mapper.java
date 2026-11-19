import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Mapper {
    public static void main(String[] args) {   

        Map<String, Integer> line_counts = new HashMap<>();
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            
            input.nextLine();
            
            String filepath = System.getenv("mapreduce_map_input_file");
            String[] splits = filepath.split("/");
            String filename = splits[splits.length - 1];
            if (line_counts.containsKey(filename)) {
                int count = line_counts.get(filename);
                line_counts.put(filename, count+1);
            } else {
                line_counts.put(filename, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : line_counts.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}