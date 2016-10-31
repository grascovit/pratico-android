package br.com.codinglab.pratico.services;

import java.util.List;

import br.com.codinglab.pratico.models.Skill;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SkillService {

    @GET("skills")
    Call<List<Skill>> getSkills();

    @GET("skills/{id}")
    Call<Skill> getSkill(@Path("id") int id);

    @POST("skills")
    Call<Skill> createSkill(@Body Skill skill);

    @PUT("skills/{id}")
    Call<Skill> updateSkill(@Path("id") int id, @Body Skill skill);

    @DELETE("skills/{id}")
    Call<Response> deleteSkill(@Path("id") int id);
}
