package com.cihangul.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        getItem();

    }

    public void getItem() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cihangul.com")
                .addConverterFactory(GsonConverterFactory.create())// aldığımız Json verisini Gson a çevirmiş oluyoruz.
                .build();

        //Oluşturduğumuz interface
        Connect connect = retrofit.create(Connect.class);
        Call<List<Item>> call = connect.getItem();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                //Bu kısımda artık response adında bir Item listemiz var
                //Bunu istediğimz gibi kullanabliriz. Ben Custom listview ile listelemek istiyorum

                List<Item> itemList = response.body();
                ItemAdapter itemAdpter = new ItemAdapter(itemList, MainActivity.this);
                listView.setAdapter(itemAdpter);
                itemAdpter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }
}
