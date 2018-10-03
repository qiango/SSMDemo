package com.wangq.ssm.controller;



import com.wangq.ssm.dao.UploadDao;

import static com.sun.org.apache.bcel.internal.classfile.Utility.toHexString;
import com.wangq.ssm.util.ValueUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Random;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadDao uploadDao;
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" ,"svg"};


    @ResponseBody
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String uploadImage(@RequestParam("uploadFiles")MultipartFile uploadFiles){
       String realName=uploadFiles.getOriginalFilename();

        return null;
    }
    public String getHash(InputStream is, String hashType) throws Exception {
        byte buffer[] = new byte[1024];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        for(int numRead = 0; (numRead = is.read(buffer)) > 0;)
        {
            md5.update(buffer, 0, numRead);
        }
        is.close();
        return toHexString(md5.digest());
    }


    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        System.out.println("comming!");
        String path = request.getSession().getServletContext().getRealPath("/images");
        System.out.println("path>>"+path);

        String fileName = file.getOriginalFilename();
        System.out.println("fileName>>"+fileName);
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(fileName, type)) {
                isLegal = true;
                break;
            }
        }
        if(!isLegal){
            return ValueUtil.toError(HttpStatus.SC_INTERNAL_SERVER_ERROR, "文件格式不正确");
        }
        int fileNames=(int)(Math.random()*9+1)*100000;
        System.out.println((int)((Math.random()*9+1)*100000));
        File dir = new File(path, fileNames+".png");
        System.out.println("dir.exists()>>"+dir.exists());
        if(!dir.exists()){
            dir.mkdirs();
        }
        System.out.println("dir.exists()>>"+dir.exists());
//		MultipartFile自带的解析方法
        file.transferTo(dir);

        return "ok";
    }


}
