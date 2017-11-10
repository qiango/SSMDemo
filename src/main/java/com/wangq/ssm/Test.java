package com.wangq.ssm;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

    //求数组最大
    @org.junit.Test
    public void arr(){
        int arr[]={1,3,2,6,5};
        int max=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        System.out.println(arr[max]);
    }

    @org.junit.Test
    public void arrar(){
        int [] arr={1,2,6,8,4,3,7};
        //选择排序
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    @org.junit.Test
    public void email(){
        // 收件人电子邮箱
        String to = "1351705361@qq.com";

        // 发件人电子邮箱
        String from = "13437194372@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "localhost";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }



}
