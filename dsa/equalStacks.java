import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    Stack<Integer> st1=new Stack<>();
    Stack<Integer> st2=new Stack<>();
    Stack<Integer> st3=new Stack<>();
    int sth1=0,sth2=0,sth3=0;
    for(int i= h1.size()-1;i>=0;i--){
        sth1 += h1.get(i);
        st1.push(sth1);
    }
    for(int i= h2.size()-1;i>=0;i--){
        sth2 += h2.get(i);
        st2.push(sth2);
    }
    for(int i=h2.size()-1;i>=0;i--){
        sth3 += h3.get(i);
        st3.push(sth3);
    }
    
    while(true){
        if(st1.isEmpty() || st2.isEmpty() || st3.isEmpty()) return 0;
        
        if(st1.peek() == st3.peek() && st2.peek() == st3.peek()) return st1.peek();
        else if(st1.peek() >= st3.peek() && st1.peek() >= st2.peek() ) 
            st1.pop();
        else if(st2.peek() >= st3.peek() && st2.peek() >= st1.peek() ) 
            st2.pop();
        else if(st3.peek() >= st1.peek() && st3.peek() >= st2.peek() )
             st3.pop();
    }
    }

}

public class equalStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}