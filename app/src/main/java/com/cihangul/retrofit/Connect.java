package com.cihangul.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Cihan on 15.11.2016.
 */

//Bir interface oluşturuyoruz.
public interface Connect {
    //Bu kısımda php dosyamızın yolunu gösteriyoruz.
    @GET("/android/veri.php")
    Call<List<Item>> getItem();
}
