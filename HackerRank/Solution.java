import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Maximum element
// link-https://www.hackerrank.com/challenges/maximum-element/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scn=new Scanner(System.in);
        int q=scn.nextInt();
        Stack<Integer> st=new Stack<>();
        Stack<Integer> mxSt=new Stack<>();
        mxSt.push(Integer.MIN_VALUE);
        for(int i=0;i<q;i++){
            int c=scn.nextInt();
            switch(c){
                case 1:
                    int item=scn.nextInt();
                    st.push(item);
                    int mxOfStack=mxSt.peek();
                    if(item > mxOfStack){
                        mxSt.push(item);
                    }
                    else{
                        mxSt.push(mxOfStack);
                    }
                    break;
                case 2:
                    mxSt.pop();
                    st.pop();
                    break;
                case 3:
                    System.out.println(mxSt.peek());
                    break;
            }
        }
    }  




    //  
}
