package com.cofc.lizhealy.shutterdroid.api;

import android.util.Base64;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by lizhealy on 1/4/17.
 */

public class ShutterStock {
    private static final RestAdapter ADAPTER = new RestAdapter.Builder()
            .setEndpoint("https://api.shutterstock.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "b678586fd5643d4d3136:c46748cd0859898b0dbae059f219f98a57d6343e";
                    String auth = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                }

            })
            .build();
}
