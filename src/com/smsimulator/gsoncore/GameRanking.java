package com.smsimulator.gsoncore;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameRanking {

@SerializedName("rank")
@Expose
private List<Rank> rank = null;

public List<Rank> getRank() {
return rank;
}

public void setRank(List<Rank> rank) {
this.rank = rank;
}

}