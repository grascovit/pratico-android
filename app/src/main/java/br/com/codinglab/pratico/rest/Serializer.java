package br.com.codinglab.pratico.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import br.com.codinglab.pratico.models.Competency;
import br.com.codinglab.pratico.models.Skill;
import br.com.codinglab.pratico.models.User;

public class Serializer<T> implements JsonSerializer<T> {

    private static final Map<Type, String> MODEL_TYPES;
    private static final String SKILL = "skill";
    private static final String USER = "user";
    private static final String COMPETENCY = "competency";

    static {
        MODEL_TYPES = new HashMap<>();
        MODEL_TYPES.put(Competency.class, COMPETENCY);
        MODEL_TYPES.put(Skill.class, SKILL);
        MODEL_TYPES.put(User.class, USER);
    }

    @Override
    public JsonElement serialize(T model, Type modelType, JsonSerializationContext context) {
        Gson gson = new Gson();
        JsonObject rootObject = new JsonObject();

        rootObject.add(MODEL_TYPES.get(modelType), gson.toJsonTree(model));

        return rootObject;
    }
}
