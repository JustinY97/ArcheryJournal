import java.io.Serializable;
import java.util.*;

public class Competition implements Serializable {

    String title;
    String location = "Not Set";
    Date date = null;
    Integer standing;
    Integer score = 0;
    int numEnds;
    int arrowsPerEnd;
    Integer[][] ends;
    HashMap<String, Integer> competitorsScores = new HashMap<>();

    public Competition(String title, int numEnds, int arrowsPerEnd){
        this.title = title;
        this.numEnds = numEnds;
        this.arrowsPerEnd = arrowsPerEnd;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStanding(Integer standing){
        this.standing = standing;
    }

    public String getTitle() {
        return title;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getStanding() {
        return standing;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation(){
        if(this.location != null)
            return this.location;
        else
            return "Location NOT Set";
    }
    public void addEnd(Integer endNumber, Integer[] arrows){
        for(int i = 0; i < this.arrowsPerEnd; i++)
            ends[endNumber-1][i] = arrows[i];
    }

    public void calculateScore(){
        Integer score = 0;
        for(int i = 0; i < ends.length; i++){
            for(int j = 0; j < ends[i].length; j++){
                score += ends[i][j];
            }
        }
        this.score = score;
        competitorsScores.put("Me", this.score);
    }

    public void printRanks(){
        // Create array of rankings and initialize to 0's
        Integer[] scores = new Integer[competitorsScores.size()];
        scores = competitorsScores.values().toArray(new Integer[0]);
        for(int i = 0; i < scores.length - 1; i++){
            for(int j = 0; j < scores.length - i - 1; j++){
                if (scores[j] > scores[j+1]){
                    int temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < scores.length; i++){
            System.out.printf("%i. %i", i, scores[i]);
        }
    }

    public void printDetails(){
        System.out.println(String.format("Event Title: %s", this.title));
        if(this.date != null)
            System.out.println(String.format("Event Date: %s", String.valueOf(date)));
        if(this.standing!= null)
            System.out.println(String.format("Event Standing: %i", this.standing));
        if(this.score != null)
            System.out.println(String.format("Event Score: %d", this.score));
        return;
    }

    public void addCompetitorInfo(String name, Integer score){
        this.competitorsScores.put(name, score);
    }
}

