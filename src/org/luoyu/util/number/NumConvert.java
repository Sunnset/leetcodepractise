package org.luoyu.util.number;

import java.awt.*;
import java.util.Arrays;

public class NumConvert {

    private static final String[] UNITS_BIG = new String[]{"亿", "万", ""};

    private static final String[] UNITS_BASE = new String[]{"千", "百", "十", ""};
    private static final String[] UNITS_UPPER_CASE = new String[]{"仟", "佰", "拾", ""};
    private static final String[] NUMBER_CHINESE = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    private static final String[] NUMBER_UPPER_CASE = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static String converToChinese(int num) {
        return converToUpperCase(num, false);
    }

    public static String converToUpperCase(int num) {
        return converToUpperCase(num, true);
    }

    public static String converToUpperCase(int num,boolean toUpperCase) {
        int[] strs = split(num, 4);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String _chinese = baseToChinese(strs[i],toUpperCase);
            result.append(_chinese);
            if (_chinese.length() >0) {
                result.append(UNITS_BIG[UNITS_BIG.length - strs.length + i]);
            }
        }
        return result.toString();
    }



    /**
     * 将数字从结尾按照每四位进行分割
     * @param num 数字
     * @param bitCount 分割位数
     * @return
     */
    public static int[] split(int num, int bitCount){
        String _num = String.valueOf(num);
        bitCount = 4;
        int numLength = _num.length(), divisor = numLength / bitCount, remainder = numLength % bitCount;

        int[] result = new int[remainder > 0 ? (divisor + 1) : divisor];
        int subIndex = 0, _index = 0;
        do {
            result[_index++] = Integer.parseInt(_num.substring(subIndex, (subIndex == 0 && remainder > 0) ? remainder : subIndex + bitCount));
            subIndex = (subIndex == 0 && remainder > 0) ? remainder : (subIndex + bitCount);
        }
        while (subIndex + 4 <= _num.length());
        return result;
    }

    /**
     * 将小于等于4位的数字转为中文
     * @param num 数字
     * @return
     */
    public static String baseToChinese(int num,boolean toUpperCase){
        if (num == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String[] nums = String.valueOf(num).split("");
        for (int i = 0; i < nums.length; i++) {
            result.append((toUpperCase ? NUMBER_UPPER_CASE : NUMBER_CHINESE)[Integer.parseInt(nums[i])])
                    .append((toUpperCase ? UNITS_UPPER_CASE : UNITS_BASE)[(toUpperCase ? UNITS_UPPER_CASE : UNITS_BASE).length - nums.length + i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println(converToUpperCase(num));

    }
}
