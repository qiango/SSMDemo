package com.wangq.ssm.List;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
}
