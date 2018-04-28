package com.kaishengit.tms.fileStore;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;

import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;


/**fastDfs操作
 *
 * @Author Reich
 * @Date: 2018/4/26 20:20
 */
@Component
public class FastDfsUtil {

    @Value("${fastdfs.tracker.server}")
    private String trackerServerAddr;

    /**文件上传 没属性
     *
     * @Author Reich
     * @Date: 2018/4/27 22:48
     */
    public String uploadFile(InputStream inputStream, String extName) {
        return upload(inputStream, extName,null);
    }

    /**文件上传
     *
     * @Author Reich
     * @Date: 2018/4/27 22:48
     */
    public String upload(InputStream inputStream, String exName, Map<String, String> param){
       try {
           StorageClient storageClient = getStorageClient();

            //添加照片信息
           NameValuePair[] nameValuePairs = null;
           if (param != null){
               nameValuePairs = new NameValuePair[param.size()];
               int i = 0;
               for (Map.Entry<String, String> entry : param.entrySet()){
                    NameValuePair nameValuePair = new NameValuePair();
                    nameValuePair.setName(entry.getKey());
                    nameValuePair.setValue(entry.getValue());
                    nameValuePairs[i] = nameValuePair;
                    i++;
               }
           }
            String[] strings = storageClient.upload_file(IOUtils.toByteArray(inputStream),exName,nameValuePairs);

            StringBuffer stringBuffer = new StringBuffer();
            for (String str : strings){
                stringBuffer.append(str).append("/");
            }
            return stringBuffer.toString().substring(0,stringBuffer.toString().lastIndexOf("/"));
       }catch (IOException | MyException e){
           throw new RuntimeException("上传文件异常", e);
       }

    }

    /**文件下载
     *
     * @Author Reich
     * @Date: 2018/4/27 22:48
     */
    public byte[] downloadFile(String fileId){

        try {

            StorageClient storageClient = getStorageClient();

            String groupName = fileId.substring(0,fileId.indexOf("/"));
            String filesPath = fileId.substring(fileId.indexOf("/")+1);

           /* FileInfo fileInfo = storageClient.get_file_info(groupName,filesPath);
            System.out.println(fileInfo.getFileSize());
            System.out.println(fileInfo.getCrc32());
            System.out.println(fileInfo.getCreateTimestamp());
            System.out.println(fileInfo.getSourceIpAddr());

            NameValuePair[] nameValuePairs = storageClient.get_metadata(groupName,filesPath);
           for(NameValuePair nameValuePair : nameValuePairs) {
               System.out.println(nameValuePair.getName() + " -> " + nameValuePair.getValue());
           }*/


            return storageClient.download_file(groupName, filesPath);


        }catch (IOException | MyException e){
            throw new RuntimeException("下载文件异常", e);
        }

    }

    private StorageClient getStorageClient() throws IOException, MyException {
        Properties properties = new Properties();
        //创建tracker服务器地址
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "192.168.142.12:22122");
        ClientGlobal.initByProperties(properties);

        //创建tracker客户端
        TrackerClient trackerClient = new TrackerClient();
        //根据tracker客户端创建tracker服务器对象
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer = null;
        return new StorageClient(trackerServer, storageServer);
    }

    /**删除文件
     *
     * @Author Reich
     * @Date: 2018/4/27 22:49
     */
    public void deleteFile(String fileId){
        try {
            StorageClient storageClient = getStorageClient();

            String groupName = fileId.substring(0,fileId.indexOf("/"));
            String fileName = fileId.substring(fileId.indexOf("/")+1);

            int i = storageClient.delete_file(groupName, fileName);
            System.out.println(i);
        }catch (IOException | MyException e){
            throw new RuntimeException("fastdfs删除文件异常");
        }

    }

 /*   public static void main(String[] args) throws IOException, MyException {

        FastDfsUtil fastDfsUtil = new FastDfsUtil();
        fastDfsUtil.deleteFile("group1/M00/00/00/wKiODFrh1QyEMqWYAAAAALKqofw945.jpg");*/

       /* FastDfsUtil fastDfsUtil = new FastDfsUtil();
        byte[] bytes = fastDfsUtil.downloadFile("group1/M00/00/00/wKiODFrh1QyEMqWYAAAAALKqofw945.jpg");

        FileOutputStream fileOutputStream = new FileOutputStream("G:/temp/xas.jpg");
        fileOutputStream.write(bytes);

        fileOutputStream.flush();
        fileOutputStream.close();*/

        //上传文件
       /* FastDfsUtil fastDfsUtil = new FastDfsUtil();
        InputStream inputStream = new FileInputStream("D:/temp/upload/1.jpg");

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("width","100");
        stringMap.put("high","300");
        stringMap.put("device","sony");

        String jpg = fastDfsUtil.upload(inputStream, "jpg",stringMap);
        System.out.println(jpg);*/


   // }
}
