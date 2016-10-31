package br.com.codinglab.pratico.models;

import com.google.gson.annotations.SerializedName;

public class Competency {

    private Integer id;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("skill_id")
    private Integer skillId;

    public Competency(Integer id, Integer userId, Integer skillId) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}
