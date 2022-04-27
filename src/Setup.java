import java.io.Serializable;

public class Setup implements Serializable {

    String id;
    String manufacturer = "Not Set";
    String model = "Not Set";
    Double poundage = 0.0;
    Double drawLength = 0.0;

    public Setup(String id){
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public void setModel(String mod){
        model = mod;
    }

    public void setPoundage(Double pounds){
        poundage = pounds;
    }

    public void setDrawLength(Double drawLength) {
        this.drawLength = drawLength;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Double getDrawLength() {
        return drawLength;
    }

    public Double getPoundage() {
        return poundage;
    }


}

