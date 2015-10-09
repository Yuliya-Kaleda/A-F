package nyc.c4q.yuliyakaleda.af;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

public interface RetrofitService {
    @GET("http://www.abercrombie.com/anf/nativeapp/Feeds/promotions.json")
    Call<RetrofitResponse> retrofitItems();
}