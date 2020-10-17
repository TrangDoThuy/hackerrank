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

public class countTriplets {
    static boolean triplet(long i,long j, long k, long r){
        if((j==(i*r))&&(k==(j*r))){
                return true;
        }
        return false;
    }
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long result =0;
        int n = arr.size();
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        HashMap<Long,Long> mapPairs = new HashMap<Long,Long>();

        for(int i=n-1;i>=0;i--){
            //System.out.println("i = "+i);
            if(mapPairs.containsKey(arr.get(i)*r)) {
                result += mapPairs.get(arr.get(i) * r);
            }
            if (map.containsKey(arr.get(i) * r)) {
                if (mapPairs.containsKey(arr.get(i))) {
                    mapPairs.put(arr.get(i), mapPairs.get(arr.get(i)) + map.get(arr.get(i) * r));
                } else {
                    mapPairs.put(arr.get(i), map.get(arr.get(i) * r));
                }
            }
            if (map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), (long)1);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

//        int n = Integer.parseInt(nr[0]);
//
//        long r = Long.parseLong(nr[1]);
//
//        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
//
//        long ans = countTriplets(arr, r);
//
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        List<Long> list=Arrays.asList((long)1,(long)1,(long)1,(long)1,(long)1);
        System.out.println(countTriplets(list,1));
    }
}
