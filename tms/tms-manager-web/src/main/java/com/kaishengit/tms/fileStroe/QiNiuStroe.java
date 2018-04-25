package com.kaishengit.tms.fileStroe;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**七牛云存储类
 *
 * @Author Reich
 * @Date: 2018/4/20 14:10*/

@Component
public class QiNiuStroe {

    @Value("${qiniu.ak}")
    private String accessKey;
    @Value("${qiniu.sk}")
    private String secreKey;
    @Value("${qiniu.bucket}")
    private String bucket;

    public String getUploadToken(){
        Auth auth = Auth.create(accessKey,secreKey);
        return auth.uploadToken(bucket);
    }

}
