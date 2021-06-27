package com.guanting.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by maochengcheng on 2019/1/8.
 * 常量配置文件
 */

@Component
@PropertySource({"classpath:application-dev.properties"})
public class ConstantProperties {

    @Value("${ftpServerHost}")
    private String ftpHost;

    @Value("${ftpServerPort}")
    private int ftpPort;

    @Value("${ftpServerUser}")
    private String ftpUser;

    @Value("${ftpServerPwd}")
    private String ftpPwd;

    @Value("${ftpServerPath}")
    private String ftpPath;

    @Value("${udpReceivePort}")
    private String udpReceivePort;

    @Value("${udpSendPort}")
    private String udpSendPort;

    @Value("${picturePath}")
    private String picturePath;

    @Value("${httpPath}")
    private String httpPath;

    @Value("${ftpServerPersonalPhotoDataPath}")
    private String ftpServerPersonalPhotoDataPath;

    @Value("${webServicePath}")
    private String webServicePath;

    @Value("http://59.202.39.69:32007/yztb/rest/sendInfo/acceptInfoJson/add")
    private String jgPath;

    @Value("${sendMessageServer}")
    private String sendMessageServer;

    @Value("${sendMessagePort}")
    private int sendMessagePort;

    @Value("${zfythPath}")
    private String zfythPath;

    @Value("${xtjg}")
    private String xtjg;

    @Value("${jcyYwdm}")
    private String jcyYwdm;

    @Value("${fyYwdm}")
    private String fyYwdm;

    @Value("${jyYwdm}")
    private String jyYwdm;

    @Value("${jyXtjg}")
    private String jyXtjg;

    @Value("${jcyXtjg}")
    private String jcyXtjg;

    @Value("${fyXtjg}")
    private String fyXtjg;

    @Value("${jsbh}")
    private int jsbh;

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPwd() {
        return ftpPwd;
    }

    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
    }

    public String getUdpReceivePort() {
        return udpReceivePort;
    }

    public void setUdpReceivePort(String udpReceivePort) {
        this.udpReceivePort = udpReceivePort;
    }

    public String getUdpSendPort() {
        return udpSendPort;
    }

    public void setUdpSendPort(String udpSendPort) {
        this.udpSendPort = udpSendPort;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    public String getFtpServerPersonalPhotoDataPath() {
        return ftpServerPersonalPhotoDataPath;
    }

    public void setFtpServerPersonalPhotoDataPath(String ftpServerPersonalPhotoDataPath) {
        this.ftpServerPersonalPhotoDataPath = ftpServerPersonalPhotoDataPath;
    }

    public String getWebServicePath() {
        return webServicePath;
    }

    public void setWebServicePath(String webServicePath) {
        this.webServicePath = webServicePath;
    }

    public String getJgPath() {
        return jgPath;
    }

    public void setJgPath(String webServicePath) {
        this.jgPath = jgPath;
    }

    public int getJsbh() {
        return jsbh;
    }

    public void setJsbh(int jsbh) {
        this.jsbh = jsbh;
    }

    public String getSendMessageServer() {
        return sendMessageServer;
    }

    public void setSendMessageServer(String sendMessageServer) {
        this.sendMessageServer = sendMessageServer;
    }

    public int getSendMessagePort() {
        return sendMessagePort;
    }

    public void setSendMessagePort(int sendMessagePort) {
        this.sendMessagePort = sendMessagePort;
    }

    public String getZfythPath() {
        return zfythPath;
    }

    public void setZfythPath(String zfythPath) {
        this.zfythPath = zfythPath;
    }

    public String getXtjg() {
        return xtjg;
    }

    public void setXtjg(String xtjg) {
        this.xtjg = xtjg;
    }

    public String getJcyYwdm() {
        return jcyYwdm;
    }

    public void setJcyYwdm(String jcyYwdm) {
        this.jcyYwdm = jcyYwdm;
    }

    public String getFyYwdm() {
        return fyYwdm;
    }

    public void setFyYwdm(String fyYwdm) {
        this.fyYwdm = fyYwdm;
    }

    public String getJyYwdm() {
        return jyYwdm;
    }

    public void setJyYwdm(String jyYwdm) {
        this.jyYwdm = jyYwdm;
    }

    public String getJyXtjg() {
        return jyXtjg;
    }

    public void setJyXtjg(String jyXtjg) {
        this.jyXtjg = jyXtjg;
    }

    public String getJcyXtjg() {
        return jcyXtjg;
    }

    public void setJcyXtjg(String jcyXtjg) {
        this.jcyXtjg = jcyXtjg;
    }

    public String getFyXtjg() {
        return fyXtjg;
    }

    public void setFyXtjg(String fyXtjg) {
        this.fyXtjg = fyXtjg;
    }
}
