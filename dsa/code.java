import java.io.*;
import java.util.*;
public class code{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int tc =scn.nextInt();
        for(int j=1;j<=tc;j++){
            int num=scn.nextInt();
            int[] arr=new int[num];
            for(int i=0;i<num;i++){
                arr[i]=scn.nextInt();
            }
            // HashMap<Integer,Integer> map=new HashMap<>();
            // int cnt=1;
            Arrays.sort(arr);
            int ans=1;
            int var=1;
            for(int i=1;i<num;i++){
                int n=arr[i];
                if(n == arr[i-1]){
                    ans+=var;
                }
                else{
                    var+=1;
                    ans+=var;
                }
                
            }
            System.out.println("Case #"+j+": "+ans);
        }
    }
}