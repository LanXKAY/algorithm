package leetcode.java.problem;

import java.util.ArrayList;
import java.util.List;

/**
<p>给定一个 &nbsp;<strong>无重复元素</strong> 的&nbsp;<strong>有序</strong> 整数数组 <code>nums</code> 。</p>

<p>返回 <em><strong>恰好覆盖数组中所有数字</strong> 的 <strong>最小有序</strong> 区间范围列表&nbsp;</em>。也就是说，<code>nums</code> 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 <code>nums</code> 的数字 <code>x</code> 。</p>

<p>列表中的每个区间范围 <code>[a,b]</code> 应该按如下格式输出：</p>

<ul>
	<li><code>"a-&gt;b"</code> ，如果 <code>a != b</code></li>
	<li><code>"a"</code> ，如果 <code>a == b</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,2,4,5,7]
<strong>输出：</strong>["0-&gt;2","4-&gt;5","7"]
<strong>解释：</strong>区间范围是：
[0,2] --&gt; "0-&gt;2"
[4,5] --&gt; "4-&gt;5"
[7,7] --&gt; "7"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,2,3,4,6,8,9]
<strong>输出：</strong>["0","2-&gt;4","6","8-&gt;9"]
<strong>解释：</strong>区间范围是：
[0,0] --&gt; "0"
[2,4] --&gt; "2-&gt;4"
[6,6] --&gt; "6"
[8,9] --&gt; "8-&gt;9"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 20</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>nums</code> 中的所有值都 <strong>互不相同</strong></li>
	<li><code>nums</code> 按升序排列</li>
</ul>
<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 221</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		} else if (nums.length == 1) {
			StringBuilder tmp = new StringBuilder();
			tmp.append(nums[0]);
			res.add(tmp.toString());
			return res;
		}

		int left = 0;
		int right = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[right]+1) {
				right++;
			} else {
				StringBuilder tmp = new StringBuilder();
				if (left == right) {
					tmp.append(nums[left]);
					res.add(tmp.toString());
				} else {
					tmp.append(nums[left]).append("->").append(nums[right]);
					res.add(tmp.toString());
				}
				left = right + 1;
				right = right + 1;
			}
		}

		StringBuilder tmp = new StringBuilder();
		if (left == right) {
			tmp.append(nums[left]);
			res.add(tmp.toString());
		} else {
			tmp.append(nums[left]).append("->").append(nums[right]);
			res.add(tmp.toString());
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
