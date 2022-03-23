package Weather;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "parts"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecasts {

    @JsonProperty("date")
    private String date;
    @JsonProperty("parts")
    private Parts parts;

    public void setDate(String date) {
        this.date = date;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public String getDate() {                   //0123456789
        String str = this.date;                 //2022-03-22
        String year = str.substring(0,4);
        String monts = str.substring(5,7);
        String day = str.substring(8,10);
        str = (day + "-" + monts + "-" + year);
        return str;
    }

    public Parts getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Forecasts{" +
                "date='" + date + '\'' +
                ", parts=" + parts +
                '}';
    }
}
