package com.jcstool.controller;

import com.jcstool.base.BaseController;
import com.jcstool.web.Operater;
import com.jcstool.web.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 文件上传
 * @module upload
 * @Author : qinjiawang
 * @Date : 2019/09/20
 * @Desoription :
 */
@RestController
@RequestMapping("/api/v1/upload")
public class UploadController extends BaseController {

    /**
     * 图片服务器地址
     */
    @Value("${api.pic}")
    String API_FOR_PIC;

    @Value("${resources.upload.suffix}")
    String FILE_SUFFIX;

    /**
     * 上传图片,
     * 预览地址:
     * http://localhost:port/uploads/
     * @param file 支持格式为.jpg .png .jpeg .bmg等
     * @return
     */
    @PostMapping(value = {"/pic"})
    public R fileUpload(@RequestParam(value = "files") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return R.isFail().message("file is empty.");
            }
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(),"static/upload/");
            if(!upload.exists()) {
                upload.mkdirs();
            }
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String infilename = UUID.randomUUID() + suffixName;
            File upload0 = new File(path.getAbsolutePath(),"logistics/uploads/"+infilename); // 新文件名
            if (!upload0.getParentFile().exists()) {
                upload0.getParentFile().mkdirs();
            }
            file.transferTo(upload0);
            return R.isOK().build(API_FOR_PIC+infilename);
        } catch (Exception e){
            return R.isFail().message("upload failed");
        }
    }

    /**
     * 判断文件类型
     * @param suffix
     * @return
     */
    private boolean validSuffix(String suffix){
        if(Operater.isEmpty(suffix)){
            return false;
        }
        if(Operater.isEmpty(FILE_SUFFIX)){
            return false;
        }
        return FILE_SUFFIX.toLowerCase().contains(suffix.toLowerCase());
    }


    //获取上传文件的后缀名
    private String getSuffix(MultipartFile file) {
        String allName = file.getOriginalFilename();
        return allName.substring(allName.lastIndexOf("."));
    }
}
