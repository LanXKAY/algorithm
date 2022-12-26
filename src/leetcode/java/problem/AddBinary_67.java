package leetcode.java.problem;

/**
 <p>给你两个二进制字符串，返回它们的和（用二进制表示）。</p>

 <p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>

 <p>&nbsp;</p>

 <p><strong>示例&nbsp;1:</strong></p>

 <pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
 <strong>输出:</strong> &quot;100&quot;</pre>

 <p><strong>示例&nbsp;2:</strong></p>

 <pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
 <strong>输出:</strong> &quot;10101&quot;</pre>

 <p>&nbsp;</p>

 <p><strong>提示：</strong></p>

 <ul>
 <li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
 <li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
 <li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
 </ul>
 <div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 836</li><li>👎 0</li></div>
 */


class AddBinary_67 {
    public String addBinary(String a, String b) {
        boolean carryFlag = false;
        StringBuilder sb = new StringBuilder();

        if (a.length() < b.length()) {
            sb.append(a).reverse();
            for (int i = 0; i < b.length() - a.length(); i++) {
                sb.append('0');
            }
            a = sb.toString();
            sb.delete(0, sb.length());

            sb.append(b);
            b = sb.reverse().toString();
            sb.delete(0, sb.length());
        } else {
            sb.append(a);
            a = sb.reverse().toString();
            sb.delete(0, sb.length());

            sb.append(b).reverse();
            for (int i = 0; i < a.length() - b.length(); i++) {
                sb.append('0');
            }
            b = sb.toString();
            sb.delete(0, sb.length());
        }

        int len = a.length();

        for (int i = 0; i < len; i++) {
            int x = (a.charAt(i) == '1') ? 1 : 0;
            int y = (b.charAt(i) == '1') ? 1 : 0;
            int z = (carryFlag) ? 1 : 0;
            switch (x+y+z) {
                case 0:
                    sb.append('0');
                    carryFlag = false;
                    break;
                case 1:
                    sb.append('1');
                    carryFlag = false;
                    break;
                case 2:
                    sb.append('0');
                    carryFlag = true;
                    break;
                case 3:
                    sb.append('1');
                    carryFlag = true;
                    break;
                default:
                    break;
            }
        }

        if (carryFlag) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
