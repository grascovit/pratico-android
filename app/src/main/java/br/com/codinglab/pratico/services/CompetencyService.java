package br.com.codinglab.pratico.services;

import java.util.List;

import br.com.codinglab.pratico.models.Competency;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CompetencyService {

    @GET("competencies")
    Call<List<Competency>> getCompetencies();

    @GET("competencies/{id}")
    Call<Competency> getCompetency(@Path("id") int id);

    @GET("users/{id}/competencies")
    Call<List<Competency>> getUserCompetencies(@Path("id") int id);

    @POST("competencies")
    Call<Competency> createCompetency(@Body Competency competency);

    @PUT("competencies/{id}")
    Call<Competency> updateCompetency(@Path("id") int id, @Body Competency competency);

    @DELETE("competencies/{id}")
    Call<Response> deleteCompetency(@Path("id") int id);
}
