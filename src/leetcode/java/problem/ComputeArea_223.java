package leetcode.java.problem;

/**
<p>给你 <strong>二维</strong> 平面上两个 <strong>由直线构成且边与坐标轴平行/垂直</strong> 的矩形，请你计算并返回两个矩形覆盖的总面积。</p>

<p>每个矩形由其 <strong>左下</strong> 顶点和 <strong>右上</strong> 顶点坐标表示：</p>

<div class="MachineTrans-Lines">
<ul>
	<li class="MachineTrans-lang-zh-CN">第一个矩形由其左下顶点 <code>(ax1, ay1)</code> 和右上顶点 <code>(ax2, ay2)</code> 定义。</li>
	<li class="MachineTrans-lang-zh-CN">第二个矩形由其左下顶点 <code>(bx1, by1)</code> 和右上顶点 <code>(bx2, by2)</code> 定义。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="Rectangle Area" src="https://assets.leetcode.com/uploads/2021/05/08/rectangle-plane.png" style="width: 700px; height: 365px;" />
<pre>
<strong>输入：</strong>ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
<strong>输出：</strong>45
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
<strong>输出：</strong>16
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-10<sup>4</sup> &lt;= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 &lt;= 10<sup>4</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>几何</li><li>数学</li></div></div><br><div><li>👍 194</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class ComputeArea_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int areaA = (ax2 - ax1) * (ay2 - ay1);
		int areaB = (bx2 - bx1) * (by2 - by1);

		int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
		int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);

		return areaA + areaB - overlapArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
