// https://leetcode.com/problems/shortest-palindrome/solution/

// brute force.
// 1. 找到从index 0 开始的s的一个最长的palindrome的substring
// 2. 把s中剩下部分，reverse后，拼到s最开头
class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        String rvs = reverse(s);
        for (int i = s.length(); i > 0; i--) {
            if (s.substring(0, i).equals(rvs.substring(len - i))) 
                return new StringBuilder(s.substring(i)).reverse().append(s).toString();
        }
        return s;
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

// recursion
// Time complexity: O(n^2)
// Each iteration of shortestPalindrome is linear in size of substring and the maximum number of recursive calls can be n/2 times as shown in the Intuition section.
// Let the time complexity of the algorithm be T(n). Since, at the each step for the worst case, the string can be divide into 2 parts and we require only one part for further computation. 
// Hence, the time complexity for the worst case can be represented as : T(n)=T(n-2)+O(n). So, T(n) = O(n) + O(n-2) + O(n-4) + ... + O(1), which is O(n^2)



// kmp

