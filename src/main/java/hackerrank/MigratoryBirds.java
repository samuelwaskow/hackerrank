import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    
    
        final List<Integer> birds = new ArrayList<>();
        final List<Integer> birdsCount = new ArrayList<>();
        
        for(final Integer b : arr){
            if(birds.contains(b)){
                
                final int index = birds.indexOf(b);
                birdsCount.set(index, birdsCount.get(index) + 1);
                
            } else {
                birds.add(b);
                birdsCount.add(1);
            }
        }
        
        int max = 0;
        int result = 0;
        for(int i = 0; i < birdsCount.size(); i++){
            final Integer c = birdsCount.get(i);
            if(c > max){
                max = c;                
                result = birds.get(i);
            } else if(c == max && birds.get(i) < result){
                result = birds.get(i);
            }
        }
        return result;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
