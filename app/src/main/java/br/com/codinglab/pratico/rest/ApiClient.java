package br.com.codinglab.pratico.rest;

import com.google.gson.GsonBuilder;

import br.com.codinglab.pratico.models.Competency;
import br.com.codinglab.pratico.models.Skill;
import br.com.codinglab.pratico.models.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String API_URL = "http://192.168.25.227:3000/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder()
                            .registerTypeAdapter(Competency.class, new Serializer<>())
                            .registerTypeAdapter(Skill.class, new Serializer<>())
                            .registerTypeAdapter(User.class, new Serializer<>())
                            .create()))
            .build();

    public static <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
