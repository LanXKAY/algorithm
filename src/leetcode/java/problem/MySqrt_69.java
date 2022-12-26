package leetcode.java.problem;

/**
<p>给你一个非负整数 <code>x</code> ，计算并返回&nbsp;<code>x</code>&nbsp;的 <strong>算术平方根</strong> 。</p>

<p>由于返回类型是整数，结果只保留 <strong>整数部分 </strong>，小数部分将被 <strong>舍去 。</strong></p>

<p><strong>注意：</strong>不允许使用任何内置指数函数和算符，例如 <code>pow(x, 0.5)</code> 或者 <code>x ** 0.5</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>x = 4
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>x = 8
<strong>输出：</strong>2
<strong>解释：</strong>8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 1055</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class MySqrt_69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }

        long tmp = (long)x;
        long left = 1;
        long right = (x/2)+1;

        while (left < right) {
            long mid = (left + right)/2;
            if (mid * mid == tmp) {
                return (int)mid;
            } else if (mid * mid < tmp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right * right > tmp) {
            return (int)(right-1);
        } else {
            return (int)(right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
