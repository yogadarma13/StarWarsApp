package com.yogadarma.starwars.network;

public class UtilsApi {
    public static NetworkApi getApiService() {
        return NetworkClient.getRetrofit().create(NetworkApi.class);
    }
}
