package leetcode.java.problem;

/**
<p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。</p>

<p><strong>说明：</strong>本题中，我们将空字符串定义为有效的回文串。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> "A man, a plan, a canal: Panama"
<strong>输出:</strong> true
<strong>解释：</strong>"amanaplanacanalpanama" 是回文串
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> "race a car"
<strong>输出:</strong> false
<strong>解释：</strong>"raceacar" 不是回文串
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 2 * 10<sup>5</sup></code></li>
	<li>字符串 <code>s</code> 由 ASCII 字符组成</li>
</ul>
<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 542</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class IsPalindrome_125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        String tmp = sb.toString();

        return (tmp.toLowerCase()).equals(sb.reverse().toString().toLowerCase());
    }

    private boolean isEqual (char a, char b) {
        if (Character.isLetter(a) && Character.isLetter(b)) {
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        } else if (Character.isDigit(a) && Character.isDigit(b)) {
            return a == b;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
