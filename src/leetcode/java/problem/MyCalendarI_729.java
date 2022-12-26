package leetcode.java.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
<p>实现一个 <code>MyCalendar</code> 类来存放你的日程安排。如果要添加的日程安排不会造成 <strong>重复预订</strong> ，则可以存储这个新的日程安排。</p>

<p>当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 <strong>重复预订</strong> 。</p>

<p>日程可以用一对整数 <code>start</code> 和 <code>end</code> 表示，这里的时间是半开区间，即 <code>[start, end)</code>, 实数&nbsp;<code>x</code> 的范围为， &nbsp;<code>start &lt;= x &lt; end</code> 。</p>

<p>实现 <code>MyCalendar</code> 类：</p>

<ul>
	<li><code>MyCalendar()</code> 初始化日历对象。</li>
	<li><code>boolean book(int start, int end)</code> 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 <code>true</code> 。否则，返回 <code>false</code>&nbsp;并且不要将该日程安排添加到日历中。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
<strong>输出：</strong>
[null, true, false, true]

<strong>解释：</strong>
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= start &lt; end &lt;= 10<sup>9</sup></code></li>
	<li>每个测试用例，调用 <code>book</code> 方法的次数最多不超过 <code>1000</code> 次。</li>
</ul>
<div><div>Related Topics</div><div><li>设计</li><li>线段树</li><li>二分查找</li><li>有序集合</li></div></div><br><div><li>👍 186</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class MyCalendarI_729 {
    ArrayList<int[]> list = new ArrayList<>();

    public MyCalendarI_729() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if (start >= end) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if ((start < list.get(i)[0] && end > list.get(i)[0]) ||
                    (start < list.get(i)[1] && end > list.get(i)[1]) ||
                    (start >= list.get(i)[0] && end <= list.get(i)[1]) ||
                    (start <= list.get(i)[0] && end >= list.get(i)[1])) {
                return false;
            }
        }

        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        list.add(temp);
        Collections.sort(list, (first, second) -> {
            if (first[0] == second[0]) {
                return first[1]-second[1];
            }
            return first[0] - second[0];
        });
        return true;
    }

    private int[][] list2Array (ArrayList<int[]> list) {
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = list.get(j)[0];
            res[j][1] = list.get(j)[1];
        }

        return res;
    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> {
            if (first[0] == second[0]) {
                return first[1]-second[1];
            }
            return first[0] - second[0];
        });
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int j = i+1;
            while (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            }
            list.add(intervals[i]);
            i = j;
        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = list.get(j)[0];
            res[j][1] = list.get(j)[1];
        }

        return res;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)
