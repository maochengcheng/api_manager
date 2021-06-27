package com.guanting.common.utils;

import com.guanting.common.constant.ConstantProperties;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.ConnectException;
import java.util.Base64;

@Component
public class FtpUtil {

	private static FtpUtil ftpUtil;

	@Autowired
	private ConstantProperties properties;

	@PostConstruct
	public void init() {
		ftpUtil = this;
	}

	// log日志
	private Logger log = Logger.getLogger(this.getClass());

	public boolean uploadFile(String path, String filename, File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return uploadFile(ftpUtil.properties.getFtpHost(),
				ftpUtil.properties.getFtpPort(),
				ftpUtil.properties.getFtpUser(),
				ftpUtil.properties.getFtpPwd(), path, filename, fileInputStream);
	}

	public boolean uploadFile(String path, String filename, InputStream fileInputStream) {
		return uploadFile(ftpUtil.properties.getFtpHost(),
				ftpUtil.properties.getFtpPort(),
				ftpUtil.properties.getFtpUser(),
				ftpUtil.properties.getFtpPwd(), path, filename, fileInputStream);
	}

	public boolean downFile(String filePath, OutputStream is) {
		String path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		String fileName = filePath.substring(filePath.indexOf("/"), filePath.length());
		return downFile(ftpUtil.properties.getFtpHost(),
				ftpUtil.properties.getFtpPort(),
				ftpUtil.properties.getFtpUser(),
				ftpUtil.properties.getFtpPwd(), path, fileName, is);
	}

	/**
	 * Description: 向FTP服务器上传文件 @Version1.0 Jul 27, 2008 4:31:09 PM by
	 * 崔红保（cuihongbao@d-heaven.com）创建
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public boolean uploadFile(String url, int port, String username, String password, String path,
			String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			// 设置传输方式
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 将文件编码由ISO-889-1转为utf-8
			ftp.setControlEncoding("utf-8");
			//取消服务器获取自身Ip地址和提交的host进行匹配
			ftp.setRemoteVerificationEnabled(false);
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			String fileName=new String(filename.getBytes("GBK"),"iso-8859-1");

			if(!StringUtils.isEmpty(path)){
				String[] ftppaths = path.split("/");
				int filelngth = ftppaths.length;
				for(int i=0; i<filelngth; i++) {
					ftp.makeDirectory(ftppaths[i]);
					ftp.changeWorkingDirectory(ftppaths[i]);
				}
			}
			//ftp.makeDirectory(path);
			//ftp.changeWorkingDirectory(path);
			ftp.storeFile(fileName, input);

			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}

	public boolean downFile(String url, int port, String username, String password, String remotePath,
			String fileName, OutputStream is) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("FTP服务连接失败!");
				return success;
			}
			//取消服务器获取自身Ip地址和提交的host进行匹配
			ftp.setRemoteVerificationEnabled(false);
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录

			ftp.enterLocalPassiveMode();

			ftp.retrieveFile(fileName, is);
			is.close();

			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	
	/**
	 * 从文件服务器上下载文件到本地
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param ftpPath
	 * @param localPath
	 * @param fileName
	 * @return
	 */
	public boolean downloadFile(String host, int port, String userName, String password, String ftpPath, String fileName ,String localPath) {
		boolean success = false;
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;
		try {
			ftpClient.connect(host, port); // 连接服务器
			ftpClient.login(userName, password); // 登录服务器
			// 判断登陆是否成功
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				ftpClient.disconnect();
				log.info("登录失败！");
				success = true;
				return success;
			}
			ftpClient.setControlEncoding("UTF-8"); // 中文支持
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); // 设置传输方式
			ftpClient.changeWorkingDirectory(ftpPath);// 转移到FTP服务器目录
			
			String filename = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
			File localFile = new File(localPath + File.separatorChar + fileName);
			fos = new FileOutputStream(localFile);
			ftpClient.retrieveFile(filename, fos);
			fos.close();
			ftpClient.logout();
			success = true;
			log.info("下载成功");
		} catch (ConnectException e) {
			log.error("ftp服务连接失败!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			log.error("没有找到" + fileName + "文件!");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("下载失败！");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	
	
     /**获取FTPClient对象
      * 
      * @param host 
      * @param port
      * @param userName
      * @param password
      * @return
      */
     public static FTPClient initFtp(String host, int port,String userName, String password) {
         int reply;
         FTPClient ftpClient = new FTPClient();
         try {
             // 1.连接服务器
        	 ftpClient.connect(host, port);
             // 2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
        	 ftpClient.login(userName, password);
             // 3.判断登陆是否成功
             reply = ftpClient.getReplyCode();
             if (!FTPReply.isPositiveCompletion(reply)) {
            	 ftpClient.disconnect();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return ftpClient;
     }


	public String selectPhotoToByte64(String filePath) {
		String path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		String fileName = filePath.substring(filePath.indexOf("/"), filePath.length());
		return selectPhotoToByte64(ftpUtil.properties.getFtpHost(),
				ftpUtil.properties.getFtpPort(),
				ftpUtil.properties.getFtpUser(),
				ftpUtil.properties.getFtpPwd(), path, fileName);
	}

	public boolean removeFile(String filePath) {
		String path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		String fileName = filePath.substring(filePath.indexOf("/"), filePath.length());
		return removeFile(ftpUtil.properties.getFtpHost(),
				ftpUtil.properties.getFtpPort(),
				ftpUtil.properties.getFtpUser(),
				ftpUtil.properties.getFtpPwd(), path, fileName);
	}

	/**
	 * 从ftp 读取文件转为byte64
	 * @param url
	 * @param port
	 * @param username
	 * @param password
	 * @param remotePath
	 * @param fileName
	 * @return
	 */
	public String selectPhotoToByte64(String url, int port, String username, String password, String remotePath,
							String fileName) {
		FTPClient ftp = new FTPClient();
		InputStream is = null;
		String byte64String = "";
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			// 登录
			ftp.login(username, password);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("FTP服务连接失败!");
				return byte64String;
			}
			//取消服务器获取自身Ip地址和提交的host进行匹配
			ftp.setRemoteVerificationEnabled(false);
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录

			//采用主动模式,出现假死状态。调用FTPClient.enterLocalPassiveMode();
			//这个方法的意思就是每次数据连接之前，ftp client告诉ftp server：数据连接的端口号已经告诉你了，你只需被动接受数据连接的请求就行
			ftp.enterLocalPassiveMode();

			is = ftp.retrieveFileStream(fileName);
			byte[] bytes = IOUtils.toByteArray(is);
			Base64.Encoder encoder = Base64.getEncoder();
			//byte64String = BASE64Utils2.getBase64FromInputStream(is);
			//byte64String = BASE64Utils.getBase64FromInputStream(is);
			byte64String = encoder.encodeToString(bytes);
			if(is != null){
				is.close();
				ftp.completePendingCommand();
			}
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return byte64String;
	}


	/**
	 * 删除文件
	 * @param url
	 * @param port
	 * @param username
	 * @param password
	 * @param remotePath
	 * @param fileName
	 * @return
	 */
	public boolean removeFile(String url, int port, String username, String password, String remotePath,
									  String fileName) {
		FTPClient ftp = new FTPClient();
		boolean falg = false;
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			// 登录
			ftp.login(username, password);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("FTP服务连接失败!");
				return falg;
			}
			//取消服务器获取自身Ip地址和提交的host进行匹配
			ftp.setRemoteVerificationEnabled(false);
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录

			//采用主动模式,出现假死状态。调用FTPClient.enterLocalPassiveMode();
			//这个方法的意思就是每次数据连接之前，ftp client告诉ftp server：数据连接的端口号已经告诉你了，你只需被动接受数据连接的请求就行
			ftp.enterLocalPassiveMode();
			falg = ftp.deleteFile(fileName);
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return falg;
	}

}
