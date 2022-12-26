package leetcode.java.problem;

/**
 <p>将一个给定字符串 <code>s</code> 根据给定的行数 <code>numRows</code> ，以从上往下、从左到右进行 Z 字形排列。</p>

 <p>比如输入字符串为 <code>"PAYPALISHIRING"</code> 行数为 <code>3</code> 时，排列如下：</p>

 <pre>
 P   A   H   N
 A P L S I I G
 Y   I   R</pre>

 <p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>"PAHNAPLSIIGYIR"</code>。</p>

 <p>请你实现这个将字符串进行指定行数变换的函数：</p>

 <pre>
 string convert(string s, int numRows);</pre>

 <p> </p>

 <p><strong>示例 1：</strong></p>

 <pre>
 <strong>输入：</strong>s = "PAYPALISHIRING", numRows = 3
 <strong>输出：</strong>"PAHNAPLSIIGYIR"
 </pre>
 <strong>示例 2：</strong>

 <pre>
 <strong>输入：</strong>s = "PAYPALISHIRING", numRows = 4
 <strong>输出：</strong>"PINALSIGYAHRPI"
 <strong>解释：</strong>
 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 </pre>

 <p><strong>示例 3：</strong></p>

 <pre>
 <strong>输入：</strong>s = "A", numRows = 1
 <strong>输出：</strong>"A"
 </pre>

 <p> </p>

 <p><strong>提示：</strong></p>

 <ul>
 <li><code>1 <= s.length <= 1000</code></li>
 <li><code>s</code> 由英文字母（小写和大写）、<code>','</code> 和 <code>'.'</code> 组成</li>
 <li><code>1 <= numRows <= 1000</code></li>
 </ul>
 <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1713</li><li>👎 0</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class ZConvert_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()) {
            return s;
        }

        int t = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        int pos = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j+i < s.length(); j += t) {
                sb.append(s.charAt(j+i));
                if (0 < i && i < numRows - 1 && j + t - i < s.length()) {
                    sb.append(s.charAt(j + t - i));
                }
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
