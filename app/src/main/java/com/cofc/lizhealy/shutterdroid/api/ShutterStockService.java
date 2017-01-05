package com.cofc.lizhealy.shutterdroid.api;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by lizhealy on 1/4/17.
 */

public interface ShutterStockService {
    @GET("/images/search")
    public void search(@Query("query") String query);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date);
}
