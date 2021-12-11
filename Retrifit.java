package retrofitpractise;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Retrifit {
    Retrofit retrofit;
    public Retrifit()
    {
                 retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public void fetchData()
    {
        ApiCall apiCall = retrofit.create(ApiCall.class);
        Call<List<Modal>> call = apiCall.getModaldata();
        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
                System.out.println(new Gson().toJson(response.body()));

            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
