package com.guanting.common.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.guanting.common.constant.ConstantProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * 使用阿里云OSS存储对象上传图片
 *
 * @author MrXiao
 * @version 1.0.0
 * <p>
 * <p>
 * <p>
 * 调用示例：OSSClientUtil.checkImage(file,OSSClientUtil.getOSSClient(),folder);
 */
@Configuration
@PropertySource("classpath:application-dev.properties")
public class OSSClientUtil {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);

    @Autowired
    private ConstantProperties properties;

    /**
     * 阿里云API的密钥Access Key ID
     */
    private static String accessKeyId;
    /**
     * 阿里云API的密钥Access Key Secret
     */
    private static String accessKeySecret;
    /**
     * 阿里云API的内或外网域名
     */
    private static String endpoint;
    /**
     * 阿里云API的bucket名称
     */
    private static String bucketName;

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */


    public static OSSClient getOSSClient() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setSupportCname(false);
        return new OSSClient(endpoint, accessKeyId, accessKeySecret, clientConfiguration);
    }


    /**
     * 上传图片至OSS
     *
     * @param ossClient  oss连接
     * @param file       上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public static String uploadObject2OSS(OSSClient ossClient, File file, String bucketName, String folder) {
        String resultStr = null;
        try {
            // 以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
            // 文件名
            String fileName = file.getName();
            // 文件大小
            Long fileSize = file.length();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".png".equalsIgnoreCase(fileExtension)) {
            return "image/png";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        // 默认返回类型
        return "";
    }


    /**
     * 单个图片上传
     *
     * @param file
     * @param ossClient
     * @param folder    此参数必须为"jsbh/"  + Constant.picPath.wpbg +" /" [Constant.java 查看注释] 例："330600111/Constant.picPath.wpbg
     * @return
     */
    public static String checkImage(MultipartFile file, OSSClient ossClient, String folder) {
        String fileUrl = uploadImg2Oss(file, ossClient, folder);
        String str = getImgUrl(fileUrl, ossClient, folder);
        ossClient.shutdown();
        if (!StringUtils.isEmpty(str)) {
            return str.trim();
        } else {
            return null;
        }

    }


    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public static String getUrl(String key, OSSClient ossClient) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }


    /**
     * 获取图片路径
     *
     * @param fileUrl
     * @return
     */
    public static String getImgUrl(String fileUrl, OSSClient ossClient, String folder) {
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            String url = getUrl(folder + split[split.length - 1], ossClient);
            return url;
        }
        return null;
    }


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public static String uploadImg2Oss(MultipartFile file, OSSClient ossClient, String folder) {
        if (file.getSize() > 1024 * 1024 * 20) {
            return "图片太大";//RestResultGenerator.createErrorResult(ResponseEnum.PHOTO_TOO_MAX);
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            uploadFile2OSS(ossClient, inputStream, name, folder);
            return name;//RestResultGenerator.createSuccessResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(String.valueOf(e));
            return null;//RestResultGenerator.createErrorResult(ResponseEnum.PHOTO_UPLOAD);
        }
    }

    /**
     * 上传图片获取fileUrl
     *
     * @param instream
     * @param fileName
     * @return
     */
    public static String uploadFile2OSS(OSSClient ossClient, InputStream instream, String fileName, String folder) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件

            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {

            System.out.println("上传失败");

        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 删除文件
     * @param ossClient ossClient
     * @param filePath 文件路径
     * @return String
     */
    public static String deleteFile(OSSClient ossClient,String filePath) {
        String ret = "";
        try {
            boolean exist = ossClient.doesObjectExist(bucketName, filePath);
            if(!exist){
                ret = "文件不存在";
            }else {
                ossClient.deleteObject(bucketName,filePath);
                ret = "删除成功";
            }
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            ret = "删除失败";
        }finally {
            ossClient.shutdown();
        }
        return ret;
    }

    /**
     * 岗位协同文件上传
     * @param file 文件
     * @param ossClient oss
     * @param folder 文件路径
     * @return String
     */
    public static String[] uploadGwxtFile(MultipartFile file, OSSClient ossClient, String folder) {
        String[] returnStr = null;
        //上传文件并返回文件名
        String fileUrl = uploadImg2Oss(file, ossClient, folder);
        //生成url
        String str = getImgUrl(fileUrl, ossClient, folder);
        ossClient.shutdown();
        if (!StringUtils.isEmpty(str)) {
            returnStr = new String[2];
            returnStr[0] = folder + fileUrl;
            returnStr[1] = str.trim();
            return returnStr;
        } else {
            return null;
        }

    }



    @Value("${accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        OSSClientUtil.accessKeyId = accessKeyId;
    }

    @Value("${accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        OSSClientUtil.accessKeySecret = accessKeySecret;
    }

    @Value("${endpoint}")
    public void setEndpoint(String endpoint) {
        OSSClientUtil.endpoint = endpoint;
    }

    @Value("${bucketName}")
    public void setBucketName(String bucketName) {
        OSSClientUtil.bucketName = bucketName;
    }

    /* @Value("${aliyun.oss.folder}")
    public void setFolder(String folder) {
        OSSClientUtil.folder = folder;
    }*/
}