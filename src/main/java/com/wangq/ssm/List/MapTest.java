package com.wangq.ssm.List;

import org.junit.Test;

import javax.persistence.Table;
import java.util.*;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 10:28 AM 11/21/17
 */
public class MapTest {

    /**
     *map集合也称为双列集合，collection集合称为单列集合
     *添加：put，返回前一个和key关联的值，如果没有，则返回null
     *删除：void clear():清空集合
     *value remove(key)；根据指定的key翻出这个键值对，返回key对应的值
     * 判断：boolean containsKey（key）；
     *      boolean containValue（value）；
     *      boolean isEmpty（）；
     */
    @Test
    public void get(){
        Map<Integer,String> map=new HashMap<>();
        String map1 = map.put(1, "map");
        String map2 = map.put(1, "maps");
        System.out.println(map2);
        for(Map.Entry m:map.entrySet()){//遍历key和value
            System.out.println(m.getKey()+"..."+m.getValue());
        }
        System.out.println(map.size());

        for(String s :map.values()){//遍历value
            System.out.println(s);
        }

        for(Integer integer:map.keySet()){//遍历key
            System.out.println(integer);
        }

        Collection<String> values = map.values();

    }

    /**
     *给一定一串字符串，统计其中的字符出现的次数
     *首先转成字符数组，再遍历数组，将所得数据放入到map集合中
     *
     */
    @Test
    public void getString(){
        String s="aaskglasssjnajda,235f asda";
        char[] chars=s.toCharArray();
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<chars.length;i++){
            int count=1;
            char key=chars[i];
            //这一行就是去掉字母以外的数据
            if(!(key>='a'&&key<='z'||key>='A'&&key<='Z')){
                    continue;
            }
            Integer value=map.get(String.valueOf(key));
            if(value!=null){
                count=value+1;
            }
            map.put(String.valueOf(key),count);
        }
        //对数量进行排序,先把map转成list
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry);
            }

        }


    //了解了上面HashMap的put和get操作原理，可以通过下面这个小例题进行知识巩固，
    // 题目是打印在数组中出现n/2以上的元素，我们便可以使用HashMap的特性来解决。
    @Test
    public void  HashMapTest() {
            int [] a = {2,1,3,2,0,4,2,1,2,3,1,5,6,2,2,3};
            Map<Integer, Integer> map = new HashMap<Integer,Integer>();
            for(int i=0; i<a.length; i++){
                if(map.containsKey(a[i])){
                    int tmp = map.get(a[i]);
                    tmp+=1;
                    map.put(a[i], tmp);
                }else{
                    map.put(a[i], 1);
                }
            }
            Set<Integer> set = map.keySet();
            for (Integer s : set) {
                if(map.get(s)>=a.length/2){
                    System.out.println(s);
                }
            }
    }
}
