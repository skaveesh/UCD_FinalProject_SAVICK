package com.smsimulator.gsoncore;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyserRecommendation {

@SerializedName("recommendations")
@Expose
private List<String> recommendations = new ArrayList<>();

public List<String> getRecommendations() {
return recommendations;
}

public void setRecommendations(List<String> recommendations) {
this.recommendations = recommendations;
}

public void addToRecommendations(String recommendation){
    recommendations.add(recommendation);
}

}