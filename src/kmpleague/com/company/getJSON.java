package kmpleague.com.company;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class getJSON {



    public static String getSummonerInfo(String name, String token) {
        StringBuilder jsonInfo = new StringBuilder();

        try {
            jsonInfo.append(connResult(new URL("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                    + name.toLowerCase().trim()
                    + "?api_key=" + token)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Summoner summoner = null;
        try {
            summoner = objectMapper.readValue(jsonInfo.toString(), Summoner.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        summoner.setFiveVFive(new RankedQueue());
        summoner.setFlex(new RankedQueue());

        summoner.getFlex().setQueueType("RANKED_FLEX_SR");
        summoner.getFiveVFive().setQueueType("RANKED_SOLO_5x5");
        //summoner object created. Now we will populate ranked queues
        jsonInfo.setLength(0);
        try {
            jsonInfo.append(connResult(new URL("https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"
                    + summoner.getId()+ "?api_key=" + token)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        objectMapper = new ObjectMapper();
        List<RankedQueue> queues = new ArrayList<RankedQueue>();
        //put ranked queues in an iterable list to apply to our summoners
        try {
             queues = objectMapper.readValue(jsonInfo.toString(), new TypeReference<List<RankedQueue>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(RankedQueue queue : queues)
            if(queue.getQueueType().equalsIgnoreCase("RANKED_FLEX_SR"))
                summoner.setFlex(queue);
            else
                summoner.setFiveVFive(queue);

        //Now its time to get top 3 champions
        jsonInfo.setLength(0);

        try {
            jsonInfo.append(connResult(new URL("https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
                    + summoner.getId()+"?api_key=" + token)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return summoner.getName() +" -> Flex: "+summoner.getFlex().getTier() + " " +summoner.getFlex().getRank() + "\tSolo/Duo: " + summoner.getFiveVFive().getTier()+" " +summoner.getFiveVFive().getRank();


    }

    public static String connResult(URL url){
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        int code = 0;

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            code = conn.getResponseCode();

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        if(code != 200)
            return "" + code;
        try( Reader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                Charset.forName(StandardCharsets.UTF_8.name())))) {

            int c = 0;
            while((c = reader.read()) != -1)
                result.append((char)c);

        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.disconnect();
        return result.toString();
    }

}
