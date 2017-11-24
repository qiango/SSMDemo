package com.wangq.ssm.List;


import org.junit.Test;

import java.util.*;

/**
 * 集合的特点：1、用于存储对象的容器
 *           2、集合的长度是可变的
 *           3、集合中不可以存储基本的数据类型值
 */

public class ListTest {

    /**
     *迭代器在迭代使用的时候，不能对集合中的元素进行增加删除的操作，否则会报错
     *迭代器取元素的时候，在循环中,it.next()方法只能用一次，多次会继续向下取
     *
     *
     *
     */

    /**
     *哈希表确定元素是否相同
     * 1、判断的是两个元素的哈希值（其实就是元素在哈希表按照一定的规则存的地址）是否相同，如果相同再判断两个对象的内容是否相同
     *2、判断哈希值相同，其实判断的是对象的hashcode的方法，判断内容相同，用的是equals方法，
     * 注意：如果哈希值不同，则不需要再去判断equals。
     *
     *ArrayList存对象的时候，若对象未复写equals方法，则list.contains(obj)方法认为已存在的元素不存在。（false）
     *HashSet存对象的时候，若对象为复写hashCode方法，则set.contains(obj)方法认为已存在的元素不存在。（false）（先比较地址hashcode，再比较equals）
     * hashMap同上
     * remove（）方法同理
     */

    @Test
    public void hashTest(){
        HashSet<HashTest> set=new HashSet();
        ArrayList list=new ArrayList();
        set.add(new HashTest(11,"wangqian"));
        set.add(new HashTest(12,"wangqian1"));
////
        list.add(new HashTest(12,"wangqian1"));
        list.add(new HashTest(11,"wangqian"));
        Boolean b=set.contains(new HashTest(11,"wangqian"));
        Boolean c=list.contains(new HashTest(11,"wangqian"));
        System.out.println(b+"......"+c);
        for (HashTest h:set){
            System.out.println(h.getAge()+"...."+h.getName());
        }
    }
    @Test
    public void get(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i=0;i<list.size();i++){
            list.remove(i);
        }
        //while用完迭代器还没消失，但用for就会释放内存，因此开发中一般使用for
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for (Iterator iterator=list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println(list);
    }

    @Test
    public void treeSet(){//重构一个比较器，通过字符串的长度来排序。treeMap也是同理。加个比较器，其底层就是treeSet
        TreeSet treeSet=new TreeSet(new TreeSetTest());

        treeSet.add("ads");
        treeSet.add("a");
        treeSet.add("dsa");
        treeSet.add("dasdasd");
        Iterator iterator=treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
