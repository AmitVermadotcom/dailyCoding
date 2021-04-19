import java.io.*;
import java.util.*;

public class question{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // int ans = trap(arr);
        // System.out.println(ans);
    }

    // Trapping water.
    public static int trap(int[] height) {
        int[] ngtr=NGTR(height);
        int[] ngtl=NGTL(height);
        int trp=0;
        // for(int i=0;i<ngtl.length;i++){
        //     System.out.print(ngtr[i]+",");
        // }
        // System.out.println();
        // for(int i=0;i<ngtl.length;i++){
        //     System.out.print(ngtl[i]+",");
        // }
        // System.out.println();
        for(int i=0;i<height.length;i++){
            if(ngtr[i] != height.length && ngtl[i] != -1){
                int l = ngtr[i]-ngtl[i]-1;
                if(l > 0){
                    // System.out.println(Math.min(height[ngtr[i]],height[ngtl[i]]));
                    int sum = l * (Math.min(height[ngtr[i]],height[ngtl[i]]) - height[i]);
                    System.out.println(sum);
                    trp+=sum;
                }
            }
        }
        return trp;
    }
    public static int[] NGTR(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,arr.length);
        for(int i=0;i<n;i++){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        
        return ans;
    }
    public static int[] NGTL(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=n-1;i >= 0;i--){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        
        return ans;
    }
// 242 valid anagram.
    public boolean isAnagram(String s, String t) {
        // boolean ans=false;
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> maps=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            maps.put(c,maps.getOrDefault(c,0)+1);
        }
        for(int j=0;j<t.length();j++){
            char c=t.charAt(j);
            if(!maps.containsKey(c)){
                return false;
            }
            int f=maps.get(c);
            if(f == 0) return false;
            maps.put(c,--f);
        }
        
        return true;
    }
    // or
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int e:arr){
            if(e != 0) return false;
        }
        return true;
        
    }
// 49 group Anagrams.
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            String rles=RLES(s);
            map.putIfAbsent(rles,new ArrayList<>());
            map.get(rles).add(s);
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    public String RLES(String s){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                sb.append((char)(i + 'a'));
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    // 215 kth largest eleent T.C = N+KlogN;

    public int findKthLargest(int[] nums, int k) {
        int n =nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            heapify(nums,i,n);
        }
        int nk=k;
        while(nk > 0){   // iterative method
            swap(nums,0,n--);
            heapify(nums,0,n);
            nk--;
        }
        return nums[nums.length-k];
    }
    public static void heapify(int[] arr,int pi,int n){
        // if(pi >= n) return;
        int maxIdx= pi;
        int li = (2*pi)+1;
        int ri=(2*pi)+2;
        if(li <= n && arr[li] > arr[maxIdx] ){
            maxIdx = li;
        }
        if(ri <= n && arr[ri] > arr[maxIdx]){
            maxIdx=ri;
        }
        if(maxIdx != pi){
            swap(arr,maxIdx,pi);
            heapify(arr,maxIdx,n);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
}

// javac question.java && java question
// 12
// 0 1 0 2 1 0 1 3 2 1 2 1