import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;


public class Practice implements Serializable {

    String title;
    String location;
    Date date;
    int numEnds;
    int arrowsPerEnd;
    Integer[][] ends;
    Setup setup;

    public Practice(String title, int ends, int arrowsPerEnd){
        this.title = title;
        this.numEnds = ends;
        this.arrowsPerEnd = arrowsPerEnd;

        this.ends = new Integer[this.numEnds][this.arrowsPerEnd];

    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getTitle(){
        return this.title;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public Setup getSetup() {
        return setup;
    }

    public void addEnd(int endNumber, Integer[] arrows){
        for(int i = 0; i < arrowsPerEnd; i++)
            this.ends[endNumber - 1][i] = arrows[i];

        System.out.println(String.format("End %d added", endNumber));
    }

    public HashMap<String, Double> endStats(int endNumber){
        HashMap<String, Double> details = new HashMap<>();
        //Sum end total and store in HashMap
        Double sum = 0.0;
        Double average;
        for(int i = 0; i < this.arrowsPerEnd; i++){
            sum += this.ends[endNumber - 1][i];
        }

        average = sum/this.arrowsPerEnd;

        details.put("Sum", sum);
        details.put("Average", average);

        return details;
    }





}
