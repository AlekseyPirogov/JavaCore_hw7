package Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

    @JsonProperty("temp_min")
    private Integer tempMin;
    @JsonProperty("temp_avg")
    private Integer tempAvg;
    @JsonProperty("temp_max")
    private Integer tempMax;
    @JsonProperty("condition")
    private String condition;

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempAvg(Integer tempAvg) {
        this.tempAvg = tempAvg;
    }

    public Integer getTempAvg() {
        return tempAvg;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public Day(){}

    @Override
    public String toString() {
        return "Day{" +
                "tempMin=" + tempMin +
                ", tempAvg=" + tempAvg +
                ", tempMax=" + tempMax +
                ", condition='" + condition + '\'' +
                '}';
    }
}
