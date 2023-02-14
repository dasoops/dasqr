package com.dasoops.ocr;

import com.dasoops.common.entity.result.Result;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.GeneralAccurateOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.GeneralAccurateOCRResponse;
import com.tencentcloudapi.ocr.v20181119.models.TextDetection;

import java.util.Arrays;

/**
 * @title: OcrService
 * @classPath com.dasoops.ocr.OcrService
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/08
 * @version 1.0.0
 * @description ocr工具类
 */
public class OcrTemplate {

    private final OcrProperties ocrProperties;

    public OcrTemplate(OcrProperties ocrProperties) {
        this.ocrProperties = ocrProperties;
    }

    /**
     * 使用腾讯sdk
     *
     * @param url url
     * @return {@link String}
     */
    public Result<String> forTencent(String url) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(ocrProperties.getSecretId(), ocrProperties.getSecretKey());
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint(ocrProperties.getEndPoint());
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            OcrClient client = new OcrClient(cred, ocrProperties.getRegion(), clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            GeneralAccurateOCRRequest req = new GeneralAccurateOCRRequest();
            req.setImageUrl(url);
            // 返回的resp是一个GeneralAccurateOCRResponse的实例，与请求对象对应
            GeneralAccurateOCRResponse resp = client.GeneralAccurateOCR(req);
            // 输出json格式的字符串回包
            TextDetection[] textDetections = resp.getTextDetections();
            StringBuilder sb = new StringBuilder();
            Arrays.stream(textDetections).forEach(res -> sb.append(res.getDetectedText()));
            return Result.success(sb.toString());
        } catch (TencentCloudSDKException e) {
            return Result.fail("[" + e.getErrorCode() + "]" + e.getMessage());
        }
    }

}
