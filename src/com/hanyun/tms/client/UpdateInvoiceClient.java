package com.hanyun.tms.client;

import com.google.gson.Gson;
import com.hanyun.tms.model.ImageModel;
import com.hanyun.tms.model.UpdateInvoiceModel;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.hanyun.tms.utils.ImageUtils.imageToBase64;
import static com.hanyun.tms.utils.SslUtils.createSSLInsecureClient;

public class UpdateInvoiceClient extends AbstractClient {
    private static final String PATH = "/integration/tms/invoice";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        // update invoice status
//        updateStatus();
        // update invoice status & upload images
        updateStatusAndUploadImages();
    }

    private static void updateStatus() {
        UpdateInvoiceModel updateInvoiceModel = new UpdateInvoiceModel();
        updateInvoiceModel.setInvoiceId(220967L);
        updateInvoiceModel.setNormalStatusId(3); // detail in doc
        // only update invoice status(when normal status!=4)
        doPut(updateInvoiceModel);
    }

    private static void updateStatusAndUploadImages() {
        // only update invoice status(when normal status!=4)
        UpdateInvoiceModel updateInvoiceModel = new UpdateInvoiceModel();
        updateInvoiceModel.setInvoiceId(220967L);
        updateInvoiceModel.setNormalStatusId(4); // detail in doc
        updateInvoiceModel.setReceivedDate("2016-09-20");
        List<ImageModel> list = new ArrayList<>();
        ImageModel imageModel1 = new ImageModel();
        imageModel1.setFileName("image1.jpg");
        ImageModel imageModel2 = new ImageModel();
        imageModel2.setFileName("image2.jpg");
        try {
            String filePath = UpdateInvoiceClient.class.getResource("/").getPath() + "/com/hanyun/tms/client/";
            imageModel1.setContent(imageToBase64(filePath+"image1.jpg"));
            imageModel2.setContent(imageToBase64(filePath+"image2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.add(imageModel1);
        list.add(imageModel2);
        updateInvoiceModel.setImageArray(list);
        doPut(updateInvoiceModel);
    }

    private static void doPut(UpdateInvoiceModel model) {
        CloseableHttpClient httpClient = createSSLInsecureClient();
        HttpPut put = new HttpPut(DOMAIN + PATH);
        put.addHeader("Content-Type", "application/json");
        put.addHeader("Integration-Auth-Token", INTEGRATION_TOKEN);
        try {
            StringEntity entity = new StringEntity(gson.toJson(model));
            put.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(put);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
