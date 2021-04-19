import java.io.*;
import java.util.*;

// public class Solution{
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         int tc=scn.nextInt();
//         for(int i=0;i<tc;i++){
//             int x=scn.nextInt();
//             int[] arr=new int[x];
//             for(int j=0;j<x;j++){
//                 arr[j]=scn.nextInt();
//             }
//             int cost=0;
//             for(int j=0;j<x-1;j++){
//                 int k = j;
//                 int mn = j;
//                 while(k != (x)){
//                     if(arr[k] < arr[mn]){
//                         mn=k;
//                     }
//                     k++;
//                 }
//                 cost += mn - j + 1 ;
//                 int n1=j;
//                 int n2=mn;
//                 while(n1 < n2){
//                     int temp=arr[n1];
//                     arr[n1]=arr[n2];
//                     arr[n2]=temp;
//                     n1++;
//                     n2--;
//                 }
//                 System.out.println(mn);
//                 System.out.println(j);
//                 for(int m=0;m<x;m++){
//                  System.out.print(arr[m]);
//             }
//                 System.out.println(); 
//             }
//             System.out.println("Case #"+(i+1)+": "+cost);
//         }
//     }
// }

// javac Solution.java && java Solution
// 3
// 4
// 4 2 1 3
// 2
// 1 2
// 7
// 7 6 5 4 3 2 1


public class Solution{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int tc=scn.nextInt();
        for(int i=0;i<tc;i++){
            int x=scn.nextInt();
            int y=scn.nextInt();
            String s=scn.next();
            // int cc=0;
            // int cj=0;
            int cost=0;
            // for(int j=0;j<s.length();j++){
            //     if(s.charAt(j) == 'C') cc++;
            //     else if(s.charAt(j) == 'K') cj++;
            // }
            // char c = cc >= cj ? 'C':'J';
            // for(int j=0;j<s.length();j++){
            //     if(s.charAt(j) == '?') s.charAt(j) = c;
            // }
            StringBuilder str= new StringBuilder();
            for(int j=0;j < s.length();j++){
                if(s.charAt(j)=='C' || s.charAt(j)=='J') str.append(s.charAt(j));
                // else if(s.charAt(j)=='J' && s.charAt(j+1)=='C') cost+=y;
            }
            System.out.println(str);
            for(int j=0;j < str.length()-1;j++){
                if(str.charAt(j)=='C' && str.charAt(j+1)=='J') cost += x;
                else if(str.charAt(j)=='J' && str.charAt(j+1)=='C') cost += y;
            }
            // for(int j=0;j<s.length();j++){
            //     System.out.print(s.charAt(j));
            // }
            // System.out.println();
            System.out.println("Case #"+(i+1)+": "+cost);
        }
    }
}