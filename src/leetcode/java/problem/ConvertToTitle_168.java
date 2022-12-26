package leetcode.java.problem;

/**
<p>给你一个整数 <code>columnNumber</code> ，返回它在 Excel 表中相对应的列名称。</p>

<p>例如：</p>

<pre>
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
</pre>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>columnNumber = 1
<strong>输出：</strong>"A"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>columnNumber = 28
<strong>输出：</strong>"AB"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>columnNumber = 701
<strong>输出：</strong>"ZY"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>columnNumber = 2147483647
<strong>输出：</strong>"FXSHRXW"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= columnNumber <= 2<sup>31</sup> - 1</code></li>
</ul>
<div><div>Related Topics</div><div><li>数学</li><li>字符串</li></div></div><br><div><li>👍 538</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class  ConvertToTitle_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int tmp = columnNumber % 26;
            if (tmp == 0) {
                sb.append('Z');
            } else {
                sb.append((char)('A' + tmp - 1));
            }
            if (columnNumber == 26) {
                break;
            }
            columnNumber /= 26;
            if (tmp == 0) {
                columnNumber--;
            }
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
