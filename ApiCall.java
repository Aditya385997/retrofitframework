package retrofitpractise;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiCall {
    @GET("/Posts")
    Call<List<Modal>> getModaldata();
}
