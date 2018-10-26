package com.pygrow.xblog.myblog.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
* @author E先生
* @version 创建时间：2018年10月23日 下午5:08:17
* @ClassName UploadController
* @Description 文件上传控制器
*/

@Controller
public class UploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile photo) {
		String upload_file ="";
		// 如果要想进行上传则一定需要获取到文件的扩展名称
		String fileExtName = photo.getContentType().substring(
				photo.getContentType().lastIndexOf("/") + 1);
		// 通过ClassPath路径获取要使用的配置文件
		ClassPathResource classPathResource = new ClassPathResource(
				"fastdfs_client.conf");
		// 进行客户端访问的整体配置，需要知道配置文件的完整路径
		try {
			ClientGlobal.init(classPathResource.getClassLoader()
					.getResource("fastdfs_client.conf").getPath());
			// FastDFS的核心操作在于tracker处理上，所以此时需要定义Tracker客户端
			TrackerClient trackerClient = new TrackerClient();
			// 定义TrackerServer的配置信息
			TrackerServer trackerServer = trackerClient.getConnection();
			// 在整个FastDFS之中真正负责干活的就是Storage
			StorageServer storageServer = null;
			StorageClient1 storageClient = new StorageClient1(
					trackerServer, storageServer);
			// 定义上传文件的元数据
			NameValuePair[] metaList = new NameValuePair[3];
			metaList[0] = new NameValuePair("fileName",
					photo.getOriginalFilename());
			metaList[1] = new NameValuePair("fileExtName", fileExtName);
			metaList[2] = new NameValuePair("fileLength",
					String.valueOf(photo.getSize()));
			// 如果要上传则使用trackerClient对象完成
			upload_file = storageClient.upload_file1(
					photo.getBytes(), fileExtName, metaList);
			
			trackerServer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("上传文件的返回路径："+upload_file);
		return upload_file;
	}
	
//	public String 
}
