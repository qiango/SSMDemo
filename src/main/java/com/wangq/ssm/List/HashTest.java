package com.wangq.ssm.List;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 11:06 AM 11/23/17
 */
//哈希实例
public class HashTest extends Object{

    private int age;
    private String name;


    public HashTest(int age,String name){
        this.age=age;
        this.name=name;
    }
    @Override
    public boolean equals(Object o) {
        System.out.println("....equals..."+o.getClass().getName());
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTest hashTest = (HashTest) o;

        if (age != hashTest.age) return false;
        return name != null ? name.equals(hashTest.name) : hashTest.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("....hashCode...");
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
