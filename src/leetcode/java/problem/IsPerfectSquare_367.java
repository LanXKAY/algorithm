package leetcode.java.problem;

/**
<p>给定一个 <strong>正整数</strong> <code>num</code> ，编写一个函数，如果 <code>num</code> 是一个完全平方数，则返回 <code>true</code> ，否则返回 <code>false</code> 。</p>

<p><strong>进阶：不要</strong> 使用任何内置的库函数，如  <code>sqrt</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num = 16
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num = 14
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= num <= 2^31 - 1</code></li>
</ul>
<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 406</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class IsPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long n = (long)num;
        long left = 0;
        long right = (long)num / 2 + 1;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (left * left) == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
