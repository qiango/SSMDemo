package com.wangq.ssm.List;

import java.util.Comparator;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 5:40 PM 11/23/17
 */
public class TreeSetTest implements Comparator{//重构的一个比较器
    @Override
    public int compare(Object o1, Object o2) {
        String a= (String) o1;
        String b= (String) o2;
        int temp=a.length()-b.length();
        return temp==0?a.compareTo(b):temp;
    }
}
