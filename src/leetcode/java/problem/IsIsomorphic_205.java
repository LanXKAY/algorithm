package leetcode.java.problem;

/**
<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和&nbsp;<code>t</code>&nbsp;，判断它们是否是同构的。</p>

<p>如果&nbsp;<code>s</code>&nbsp;中的字符可以按某种映射关系替换得到&nbsp;<code>t</code>&nbsp;，那么这两个字符串是同构的。</p>

<p>每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入：</strong>s = <code>"egg", </code>t = <code>"add"</code>
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = <code>"foo", </code>t = <code>"bar"</code>
<strong>输出：</strong>false</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = <code>"paper", </code>t = <code>"title"</code>
<strong>输出：</strong>true</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<p><meta charset="UTF-8" /></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>t.length == s.length</code></li>
	<li><code>s</code>&nbsp;和&nbsp;<code>t</code>&nbsp;由任意有效的 ASCII 字符组成</li>
</ul>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 474</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] sTot = new int[128];
		int[] tTos = new int[128];
		for (int i = 0; i < 128; i++) {
			sTot[i] = -1;
			tTos[i] = -1;
		}

		for (int i = 0; i < s.length(); i++) {
			int sTmp = s.charAt(i);
			int tTmp = t.charAt(i);

			if ((sTot[sTmp] != -1 || tTos[tTmp] != -1) && (sTot[sTmp] != tTmp || tTos[tTmp] != sTmp)) {
				return false;
			} else {
				sTot[sTmp] = tTmp;
				tTos[tTmp] = sTmp;
			}
		}

		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
