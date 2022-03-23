package Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Yesterday {

    @JsonProperty("temp")
    private Integer temp;

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getTemp() {
        return temp;
    }

    public Yesterday(Integer temp){
        this.temp = temp;
    }

    public Yesterday(){

    }

    @Override
    public String toString() {
        return "Yesterday{" +
                "temp=" + temp +
                '}';
    }
}
