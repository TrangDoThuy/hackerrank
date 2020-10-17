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

public class frequencyQueries {

    // Complete the freqQuery function below.

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        int n = queries.size();
        long max =0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        for(int i=0;i<n;i++){
            long num =queries.get(i).get(1);
            if(queries.get(i).get(0)==1){
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+(long)1);
                    if(map.get(num)>max){
                        max=map.get(num);
                    }
                }else{
                    map.put(num,(long)1);
                    if(map.get(num)>max){
                        max=map.get(num);
                    }
                }
            }else if(queries.get(i).get(0)==2){
                if(map.containsKey(num)){
                    map.put(num,map.get(num)-(long)1);
                    if(map.get(num)<=0){
                        map.remove(num);
                    }
                }
            }else{
                if(num>max){
                    result.add(0);
                    continue;
                }
                if(map.containsValue(num)){
                    result.add(1);
                }else{
                    result.add(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
