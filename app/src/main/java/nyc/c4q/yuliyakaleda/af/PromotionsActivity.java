package nyc.c4q.yuliyakaleda.af;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class PromotionsActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://www.abercrombie.com/anf/nativeapp/Feeds/promotions.json";
    private static final String SHARED_PREFERENCE = "preferences";
    private static final String IS_DATA_CACHED = "isDataCached";
    private static final String TAG = "nyc.c4q.yuliyakaleda.af";
    private static final String CACHE_FOLDER = "responses";
    private static final String PROMOTION = "promotion";
    private SharedPreferences preferences;
    private TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);
        preferences = getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);
        boolean isDataCached = preferences.getBoolean(IS_DATA_CACHED, false);
        table = (TableLayout) findViewById(R.id.table_promotions);

        //It sets the default image of the sliding panel when there is no network connectivity.
        if (!isNetworkConnected() && !isDataCached) {
            table.setBackgroundResource(R.drawable.abercrombie);
        }

        //It generates an implementation of the RetrofitService class.
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(enableCache())
            .build();

        RetrofitService abercrombieData = retrofit.create(RetrofitService.class);
        Call<RetrofitResponse> call = abercrombieData.retrofitItems();
        call.enqueue(new retrofit.Callback<RetrofitResponse>() {
            @Override
            public void onResponse(Response<RetrofitResponse> response) {
                //When response is not null, it return the list of promotions.
                if (response != null) {
                    List<Promotion> promotionList = response.body().getPromotions();
                    for (final Promotion promotion : promotionList) {
                        //It initializes the views.
                        TableRow row = (TableRow) LayoutInflater.from(PromotionsActivity.this).inflate(R.layout.row, null);
                        ImageView promotionImage = (ImageView) row.findViewById(R.id.image);
                        TextView promotionTitle = (TextView) row.findViewById(R.id.title);

                        //it sets the data to the views.
                        promotionTitle.setText(promotion.getTitle());
                        Picasso.with(PromotionsActivity.this).load(promotion.getImage()).into(promotionImage);
                        table.addView(row);
                        preferences.edit().putBoolean(IS_DATA_CACHED, true).apply();

                        //It sets every row onClickListener.
                        row.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //It sends info about the selected promotion to the CardActivity.
                                Intent showPromotionCard = new Intent(PromotionsActivity.this, CardActivity.class);
                                showPromotionCard.putExtra(PROMOTION, promotion);
                                startActivity(showPromotionCard);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "Retrofit: " + t.getMessage());
            }
        });
    }

    //It enables caching the data.
    private OkHttpClient enableCache() {
        File httpCacheDirectory = new File(getCacheDir(), CACHE_FOLDER);
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setCache(cache);
        return okHttpClient;
    }

    //It checks network connectivity.
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null);
    }
}
