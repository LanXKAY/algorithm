package leetcode.java.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
<p>给定两个数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code> ，返回 <em>它们的交集</em>&nbsp;。输出结果中的每个元素一定是 <strong>唯一</strong> 的。我们可以 <strong>不考虑输出结果的顺序</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,2,2,1], nums2 = [2,2]
<strong>输出：</strong>[2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>输出：</strong>[9,4]
<strong>解释：</strong>[4,9] 也是可通过的
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 564</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class TwoArraysIntersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int pos1 = 0;
        int pos2 = 0;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (pos1 < len1 && pos2 < len2) {
            if (nums1[pos1] == nums2[pos2]) {
                int tmp = nums1[pos1];
                list.add(tmp);
                while (pos1 < len1 && nums1[pos1] == tmp) {
                    pos1++;
                }
                while (pos2 < len2 && nums2[pos2] == tmp) {
                    pos2++;
                }
            } else if (nums1[pos1] < nums2[pos2]) {
                pos1++;
            } else {
                pos2++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
