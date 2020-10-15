import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        if(note==null){
            System.out.println("No");
            return;
        }

        HashMap<String,Integer> table = new HashMap<String,Integer>();
        int n_magazine = magazine.length;
        int n_note = note.length;
        if(n_note>n_magazine){
            System.out.println("No");
            return;
        }

        for(int i=0;i<n_magazine;i++){
            if(table.containsKey(magazine[i])){
                table.put(magazine[i],table.get(magazine[i])+1);
            }else{
                table.put(magazine[i],1);
            }
        }
        for(int i=0;i<n_note;i++){
            if(table.containsKey(note[i])){
                table.put(note[i],table.get(note[i])-1);
                if(table.get(note[i])<0){
                    System.out.println("No");
                    return;
                }
            }else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
