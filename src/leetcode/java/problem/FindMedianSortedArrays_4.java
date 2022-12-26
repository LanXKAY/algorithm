package leetcode.java.problem;

/**
 <p>给定两个大小分别为 <code>m</code> 和 <code>n</code> 的正序（从小到大）数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。请你找出并返回这两个正序数组的 <strong>中位数</strong> 。</p>

 <p>算法的时间复杂度应该为 <code>O(log (m+n))</code> 。</p>

 <p>&nbsp;</p>

 <p><strong>示例 1：</strong></p>

 <pre>
 <strong>输入：</strong>nums1 = [1,3], nums2 = [2]
 <strong>输出：</strong>2.00000
 <strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
 </pre>

 <p><strong>示例 2：</strong></p>

 <pre>
 <strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
 <strong>输出：</strong>2.50000
 <strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 </pre>

 <p>&nbsp;</p>

 <p>&nbsp;</p>

 <p><strong>提示：</strong></p>

 <ul>
 <li><code>nums1.length == m</code></li>
 <li><code>nums2.length == n</code></li>
 <li><code>0 &lt;= m &lt;= 1000</code></li>
 <li><code>0 &lt;= n &lt;= 1000</code></li>
 <li><code>1 &lt;= m + n &lt;= 2000</code></li>
 <li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
 </ul>
 <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li></div></div><br><div><li>👍 5559</li><li>👎 0</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)

// 暴力解法
// 对两数组分别排序后合并然后寻找中位数
class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = mergeTwoSortedArrays(nums1, nums2);
        int len = nums.length;
        if (len % 2 == 0) {
            return (double)(nums[len/2]+nums[len/2-1])/(double)(2);
        } else {
            return (double)(nums[len/2]);
        }
    }

    private int[] mergeTwoSortedArrays (int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1 + len2];

        int pointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < len1 && pointer2 < len2) {
            int tmp;
            if (nums1[pointer1] < nums2[pointer2]) {
                tmp = nums1[pointer1++];
            } else {
                tmp = nums2[pointer2++];
            }
            res[pointer] = tmp;
            pointer++;
        }

        while (pointer1 < len1) {
            res[pointer] = nums1[pointer1++];
            pointer++;
        }
        while (pointer2 < len2) {
            res[pointer] = nums2[pointer2++];
            pointer++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)