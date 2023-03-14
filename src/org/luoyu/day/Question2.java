package org.luoyu.day;

/**
 * leetcode:第二道题
 * 两数相加
 */
public class Question2 {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。<br/>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。<br/>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。<br/>
     * <br/>
     * <img width="400px" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg"/><br/>
     * <p>
     * <p>
     * 示例 1：<br/>
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]<br/>
     * 输出：[8,9,9,9,0,0,0,1]<br/>
     * <p>
     * <p>
     * 提示：<br/>
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内<br/>
     * 0 <= Node.val <= 9<br/>
     * 题目数据保证列表表示的数字不含前导零<br/>
     * <p>
     * 来源：力扣（LeetCode）<br/>
     * 链接：https://leetcode.cn/problems/add-two-numbers<br/>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br/>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode cur = prev;
        //当l1 不等于null或l2 不等于空时，就进入循环
        while (l1 != null || l2 != null) {
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x = l1 != null ? l1.val : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 != null ? l2.val : 0;
            //将两个链表的值，进行相加，并加上进位数
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            //将求和数赋值给新链表的节点，
            //注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
            //所以这个时候要创一个新的节点，将值赋予节点
            cur.next = new ListNode(sum);
            //将新链表的节点后移
            cur = cur.next;
            //当链表l1不等于null的时候，将l1 的节点后移
            if (l1 != null) {
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
