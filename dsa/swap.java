import java.io.*;
import java.util.*;
public class swap{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n =scn.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=scn.nextInt();
        }
        // int mx=0;
        int idx=0;
        for(int i=0;i<n;i++){
            arr2[i]=scn.nextInt();
            if(Math.abs(arr1[0]-arr2[i]) < Math.abs(arr1[0]-arr2[idx])){
                // mx = arr2[i];
                idx=i;
            }

        }
        
        boolean res=false;
        if(Math.abs(arr1[0]-arr2[0]) < Math.abs(arr1[0]-arr2[idx])){
            res=true;
        }
        //  System.out.println(res +" "+" "+arr2[idx]+" "+idx);
        int ans=0;
        if(res == true){
            for(int i=0;i<n;i++){
                ans+=Math.abs(arr1[i]-arr2[i]);
            }
        }
        else{
            int temp=arr2[0];
            arr2[0]=arr2[idx];
            arr2[idx]=temp;
            for(int i=0;i<n;i++){
                ans+=Math.abs(arr1[i]-arr2[i]);
                // System.out.println(ans);
            }
        }
        System.out.println(ans);
    }
}