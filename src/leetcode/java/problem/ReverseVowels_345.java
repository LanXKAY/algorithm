package leetcode.java.problem;

import java.util.Arrays;
import java.util.HashSet;

/**
<p>给你一个字符串 <code>s</code> ，仅反转字符串中的所有元音字母，并返回结果字符串。</p>

<p>元音字母包括 <code>'a'</code>、<code>'e'</code>、<code>'i'</code>、<code>'o'</code>、<code>'u'</code>，且可能以大小写两种形式出现。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "hello"
<strong>输出：</strong>"holle"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "leetcode"
<strong>输出：</strong>"leotcede"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> 由 <strong>可打印的 ASCII</strong> 字符组成</li>
</ul>
<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 253</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class ReverseVowels_345 {
    public String reverseVowels(String s) {
        char[] t = s.toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0;
        int right = t.length-1;
        while (left < right) {
            while (left < t.length && !set.contains(t[left])) {
                left++;
            }
            while (right > -1 && !set.contains(t[right])) {
                right--;
            }
            if (left >= right) {
                break;
            } else {
                char tmp = t[left];
                t[left] = t[right];
                t[right] = tmp;
                left++;
                right--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(t);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
