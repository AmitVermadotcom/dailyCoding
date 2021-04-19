import java.io.*;
import java.util.*;

public class Main{

    
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int tc=scn.nextInt();
        for(int t=0;t<tc;t++){
            int a=scn.nextInt();
            int b=scn.nextInt();
            String s=scn.nextLine();
            int i =0;
            int j=s.length()-1;
            while(i < j){
                if(s.charAt(i) == s.charAt(j)){
                    if(s.charAt(i) == '0'){
                        a=a-2;
                    }
                    else if(s.charAt(i) == '1'){
                        b=b-2;
                    }
                    else{
                        if(a >= b){
                            s.charAt(i) = '0';
                            s.charAt(j) = '0';
                            a-=2;
                        }
                        else{
                            s.charAt(i) = '1';
                            s.charAt(j) = '1';
                            b-=2;
                        }
                    }
                }
                else {
                    if(s.charAt(i) == '0'){
                        a-=1;
                        if(s.charAt(j) == '1'){
                            System.out.print(-1);
                            return ;
                        }
                        else if(s.charAt(j) == '?'){
                            s.charAt(j)='0';
                            a-=1;
                        }
                    }
                    else if(s.charAt(i) == '1'){
                        b-=1;
                        if(s.charAt(j) == '0') {
                            System.out.print(-1);
                            return;
                        }
                        else if(s.charAt(j) == '?'){
                            s.charAt(j) = '1';
                            b-=1;
                        }
                    }
                    else if(s.charAt(i) == '?'){
                        if(s.charAt(j) == '0'){
                            s.charAt(i)='0';
                            a-=2;
                        }
                        else if(s.charAt(j) == '1'){
                            s.charAt(i)='1';
                            b-=2;
                        }
                    }
                }

                if(a<0 || b<0){
                    System.out.println(-1);
                    return ;
                }
                i++;
                j--;
            }
            if(s.length()%2 != 0){
                if(s.charAt(i) == '0'){
                    a-=1;
                }
                else if(s.charAt(i) == '1'){
                    b-=1;
                }
                else{
                    if(a >= b){
                        s.charAt(i) ='0';
                        a-=1;
                    }
                    else{
                        s.charAt(i) ='1';
                        b-=1;
                    }
                }
                
            }
            if(a != 0 && b != 0){
                System.out.print(-1);
                return ;
            }
            for(int l =0;l<s.length();l++){
                System.out.print(c+" ");
            }
        }
    }
    
}





// 1157A REACHABLE NUMBERS......
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     int n=scn.nextInt();
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     while(map.containsKey(n) == false){
    //         map.put(n,1);
    //         n++;
    //         while(n%10 == 0){
    //             n/=10;
    //         }
    //     }
    //     System.out.println(map.size());
    // }