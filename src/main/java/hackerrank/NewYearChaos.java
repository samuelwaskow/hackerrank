package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class NewYearChaosResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static void minimumBribes(List<Integer> q) {

        final int total = q.size();
        int totalbribes = 0;

        for (int i = 0; i < total; i++) {
            
            if(q.get(i) == i + 1){
                continue;
            }

            int index = 0;

            for (int j = 0; j < total; j++) {

                if (q.get(j) == i + 1) {
                    index = j;
                    break;
                }
            }

            int bribes = 0;
            while (i < index) {
                if (q.get(i) > q.get(index)) {
                    final int tmp = q.get(i);
                    q.set(i, q.get(index));
                    q.set(index, tmp);
                    bribes++;
                    index--;
                } else {
                    break;
                }
            }

            System.out.println(q.toString() + " - " + i + " - " + index + " - " + bribes);
            if (bribes > 2) {
                System.out.println("Too chaotic");
                break;
            } else {
                totalbribes += bribes;
            }
        }

        System.out.println(totalbribes);

    }

}

public class NewYearChaos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                NewYearChaosResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
