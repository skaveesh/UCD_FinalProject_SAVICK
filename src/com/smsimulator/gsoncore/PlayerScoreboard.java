package com.smsimulator.gsoncore;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerScoreboard {

@SerializedName("score")
@Expose
private List<Score> score = null;

public List<Score> getScore() {
return score;
}

public void setScore(List<Score> score) {
this.score = score;
}

}