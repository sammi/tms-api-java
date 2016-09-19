package com.hanyun.tms;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class InvoiceClient {

    public static void main(String[] args) {

        try {

            //sudo keytool -import -trustcacerts ./tms-qa-cert.pem -alias tms -keystore $JAVA_HOME/jre/lib/security/cacerts
            //Password is:   changeit

            System.setProperty("javax.net.ssl.trustStore", System.getProperty("java.home") + "/lib/security/cacerts");

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet get = new HttpGet("https://tms-qa.xinhuaunited.cn/integration/tms/invoice/"+214782);
            get.addHeader("Integration-Auth-Token", "Tv*BAwEBC0FjY2Vzc1Rva2VuAf*CAAEEAQdUb2tlbklkAQQAAQpFeHBpcnlUaW1lAf*EAAEKQWNjZXNzS2V5cwH-hgABBFNhbHQBDAAAABD-gwUBAQRUaW1lAf*EAAAAFP*FAgEBBltddWludAH-hgABBgAAJ-*CAf5OMgEPAQAAAA7RUQOAAAAAAP--AQEBAQpBTkdpZEtOeTNOAA..");
            CloseableHttpResponse response = httpclient.execute(get);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
