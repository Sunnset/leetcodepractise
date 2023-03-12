package org.luoyu.day;

import java.util.HashMap;

/**
 * leetcode:第一道题
 * 两数之和
 */
public final class Question1 {
    /**
     * 题目：
     * 给定一个一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,2};
        int target = 9;
        long start = System.currentTimeMillis();
        int[] hash = hash(nums, target);
        System.out.printf("程序耗时：%d毫秒",System.currentTimeMillis() - start);
        if (hash.length==0) {
            System.out.println("未找到指定数组");
        } else {
            System.out.printf("找到数组下标，下标1：%d，下标2：%d",hash[0],hash[1]);
        }
    }


    /**
     * 官方推荐哈希算法
     * @param nums
     * @param target
     * @return
     */
    public static int[] hash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
