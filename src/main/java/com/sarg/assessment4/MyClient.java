package com.sarg.assessment4;

import java.net.http.HttpClient;

public final class MyClient {

    private static MyClient clientSingleton;

    public HttpClient client ;

    private MyClient() {}

    public static MyClient getInstance(){
        if(clientSingleton == null) {
            clientSingleton = new MyClient();
            clientSingleton.client = HttpClient.newHttpClient();
        }

        return clientSingleton;
    }


}
