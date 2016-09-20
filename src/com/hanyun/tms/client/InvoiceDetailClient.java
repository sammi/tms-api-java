package com.hanyun.tms.client;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.MessageFormat;

import static com.hanyun.tms.utils.SslUtils.createSSLInsecureClient;

public class InvoiceDetailClient extends AbstractClient {
    public static void main(String[] args) {
        try {
            final String invoiceId = "220967";
            final String path = "/integration/tms/invoice/{0}";
            CloseableHttpClient httpClient = createSSLInsecureClient();
            HttpGet get = new HttpGet(DOMAIN + MessageFormat.format(path, invoiceId));
            get.addHeader("Integration-Auth-Token", INTEGRATION_TOKEN);
            CloseableHttpResponse response = httpClient.execute(get);
            // view invoice detail
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
