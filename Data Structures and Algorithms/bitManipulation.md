1. n & -n  
n & -n取得n的二进制最右面的1，所以可以用 n &-n == n 来判断n是不是2的整数次幂

2. n & (n - 1)  
n & (n-1)作用：将n的二进制表示中的最低位为1的改为0，比如n = 10100(二进制），则(n-1) = 10011，n & (n-1) = 10000，可以看到原本最低位为1的那位变为0。  
应用：判断一个数是否是2的次幂，n > 0 && ((n & (n - 1)) == 0)

3. n & 1  
判断奇偶  
末尾取1

4. XOR 判断唯一元素  
lc 136， 389
