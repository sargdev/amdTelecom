package com.sarg.assessment4;

import java.net.http.HttpClient;

public final class ClientSingleton {

    private static ClientSingleton clientSingleton;

    public HttpClient client ;

    private ClientSingleton() {}

    public static ClientSingleton getInstance(){
        if(clientSingleton == null) {
            clientSingleton = new ClientSingleton();
            clientSingleton.client = HttpClient.newHttpClient();
        }

        return clientSingleton;
    }


}
