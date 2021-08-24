package kmpleague.com.company;

public class Summoner {

    private String id; //    Encrypted summoner ID. Max length 63 characters.
    private String accountId; //	Encrypted account ID. Max length 56 characters.
    private String puuid; //     Encrypted PUUID. Exact length of 78 characters.
    private String name; // 	Summoner name.
    private String profileIconId; //	ID of the summoner icon associated with the summoner.
    private String revisionDate; //     Date summoner was last modified specified as epoch milliseconds
    private String summonerLevel; // 	Summoner level associated with the summoner.

    private RankedQueue flex;
    private RankedQueue fiveVFive;



    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public RankedQueue getFlex() {
        return flex;
    }

    public void setFlex(RankedQueue flex) {
        this.flex = flex;
    }

    public RankedQueue getFiveVFive() {
        return fiveVFive;
    }

    public void setFiveVFive(RankedQueue fiveVFive) {
        this.fiveVFive = fiveVFive;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(String profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(String summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

}
