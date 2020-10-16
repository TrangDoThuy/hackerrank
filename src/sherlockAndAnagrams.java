import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        if(s== null){
            return 0;
        }
        int n  = s.length();
        if(n==0){
            return 0;
        }
        if(n==1){
            return 0;
        }
        int result=0;
        HashMap<String,Integer> table = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                char[] arr = s.substring(i,j+1).toCharArray();

                Arrays.sort(arr);
                String subString = String. valueOf(arr);
                if(table.containsKey(subString)){
                    table.put(subString,table.get(subString)+1);
                }else{
                    table.put(subString,1);
                }
            }
        }
        for(Map.Entry<String,Integer> entry: table.entrySet()){
            result+=(entry.getValue()*(entry.getValue()-1)/2);
        }
        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
