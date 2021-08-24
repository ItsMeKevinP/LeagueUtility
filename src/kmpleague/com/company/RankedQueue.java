package kmpleague.com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"leagueId", "summonerId", "leaguePoints", "veteran", "inactive", "freshBlood", "hotStreak"})
public class RankedQueue {

    private String leagueId;
    private String summonerId;
    private String leaguePoints;
    private String veteran;
    private String inactive;
    private String freshBlood;
    private String hotStreak;
    private String queueType;
    private String tier = "N/A";
    private String rank = "N/A";
    private String summonerName;
    private int wins;
    private int losses;

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(String leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public String getVeteran() {
        return veteran;
    }

    public void setVeteran(String veteran) {
        this.veteran = veteran;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(String freshBlood) {
        this.freshBlood = freshBlood;
    }

    public String getHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(String hotStreak) {
        this.hotStreak = hotStreak;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

}
