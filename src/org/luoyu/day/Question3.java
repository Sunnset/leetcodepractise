package org.luoyu.day;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode:第三道题
 * 无重复字符的最长子串
 */
public class Question3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。<br/>
     * 示例：<br/>
     * 输入: s = "pwwkew"<br/>
     * 输出: 3<br/>
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。<br/>
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。<br/>
     *提示：<br/>
     *     * 0 <= s.length <= 5 * 104<br/>
     * s 由英文字母、数字、符号和空格组成<br/>
     * <br/>
     * 来源：力扣（LeetCode）<br/>
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters<br/>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br/>
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
