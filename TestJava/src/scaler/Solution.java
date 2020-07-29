package scaler;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public int solve(String A, int B, String C) {
        int n=A.length();
        char ch= C.charAt(0);

        int i=0,j=0;
        int maxLen=0;
        int cnt=0;

        while(j<n){
            if(A.charAt(j)!=ch) cnt++;

            if(cnt<=B){
                //j++;
            }
            else{
                //shrink the window from left
                while(i<j && cnt>B){
                    if(A.charAt(i)!=ch) cnt--;
                }

            }

            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }

        return maxLen;
    }
}
