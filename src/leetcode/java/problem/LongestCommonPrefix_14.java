package leetcode.java.problem;

/**
 <p>编写一个函数来查找字符串数组中的最长公共前缀。</p>

 <p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>

 <p>&nbsp;</p>

 <p><strong>示例 1：</strong></p>

 <pre>
 <strong>输入：</strong>strs = ["flower","flow","flight"]
 <strong>输出：</strong>"fl"
 </pre>

 <p><strong>示例 2：</strong></p>

 <pre>
 <strong>输入：</strong>strs = ["dog","racecar","car"]
 <strong>输出：</strong>""
 <strong>解释：</strong>输入不存在公共前缀。</pre>

 <p>&nbsp;</p>

 <p><strong>提示：</strong></p>

 <ul>
 <li><code>1 &lt;= strs.length &lt;= 200</code></li>
 <li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
 <li><code>strs[i]</code> 仅由小写英文字母组成</li>
 </ul>
 <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 2312</li><li>👎 0</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.length == 0) {
            return sb.toString();
        } else if (strs.length == 1) {
            return strs[0];
        }

        int len = strs[0].length();
        for (String str :
                strs) {
            len = Math.min(len, str.length());
        };

        boolean flag = true;
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(ch);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
