package com.wangq.ssm;

import java.util.*;

public class Test {

    @org.junit.Test
    public void test() {
//        System.out.println(DateUtil.toString());
//        System.out.println(DateUtil.getNowTime());
//        System.out.println(DateUtil.toString());
//        Date str = new Date();
//        String ss= DateUtil.toString(str,"yyyy-MM-dd HH:mm:ss");
//        System.out.println(str);
//        System.out.println(ss);
//==比较的是地址，equals比较的是对象内容
        String s1="a";
        String s2="a";
        String s3=new String("a");
        String s4=new String("a");
        System.out.println(s1==s2);//t
        System.out.println(s1.compareTo(s2));//0
        System.out.println(s1.equals(s2));//t
        System.out.println(s2==s3);//f
        System.out.println(s2.equals(s3));//t
        System.out.println(s3==s4);//f
        System.out.println(s3.equals(s4));//t

    }

    //map排序
    @org.junit.Test
    public void getMap(){
        Map<Integer,String> map=new HashMap();
        map.put(1,"a");
        map.put(7,"c");
        map.put(6,"v");
        map.put(4,"b");
        List<Map.Entry<Integer,String>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return 0;
            }
        });
    for(Map.Entry entry:map.entrySet()){
        System.out.println(entry);
    }

    }

    @org.junit.Test
    public void sss(){
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(1);
        //顺序
//        Collections.sort(list);
        //倒序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (Integer l:list){
            System.out.println(l);
        }
    }



}
