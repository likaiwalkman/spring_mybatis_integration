package org.victor.jetty;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws Exception {
        final PrintStream p = new PrintStream(new FileOutputStream("/Users/victor/git/out.o"));
        System.setOut(p);
        HttpClient httpClient = new HttpClient();
        httpClient.setExecutor(Executors.newFixedThreadPool(20));
        httpClient.start();
        for (int i = 0; i < 10000; i++) {
            httpClient.newRequest("http://www.baidu.com").send(new BufferingResponseListener(8*1024*1024) {
                @Override
                public void onComplete(Result result) {
                    String mediaType = getMediaType();
                    int    status    = result.getResponse().getStatus();
                    System.out.println(status+": "+mediaType);
                }
            });

        }

        Thread.sleep(1000);
        //System.out.println(httpClient.isRunning());
        Thread.sleep(10000);
        //System.out.println();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                p.close();
            }
        }));

    }
}
