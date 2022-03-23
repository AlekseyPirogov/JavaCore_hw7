package Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayShort {

    @JsonProperty("temp")
    private Integer temp;
    @JsonProperty("condition")
    private String condition;

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        String returnString = null;
        switch (this.condition) {
            case "clear": returnString = "ясно"; break;
            case "partly-cloudy": returnString = "малооблачно"; break;
            case "cloudy": returnString = "облачно с прояснениями"; break;
            case "overcast": returnString = "пасмурно"; break;
            case "drizzle": returnString = "морось"; break;
            case "light-rain": returnString = "небольшой дождь"; break;
            case "rain": returnString = "дождь"; break;
            case "moderate-rain": returnString = "умеренно сильный дождь"; break;
            case "heavy-rain": returnString = "сильный дождь"; break;
            case "continuous-heavy-rain": returnString = "длительный сильный дождь"; break;
            case "showers": returnString = "ливень"; break;
            case "wet-snow": returnString = "дождь со снегом"; break;
            case "light-snow": returnString = "небольшой снег"; break;
            case "snow": returnString = "снег"; break;
            case "snow-showers": returnString = "снегопад"; break;
            case "hail": returnString = "град"; break;
            case "thunderstorm": returnString = "гроза"; break;
            case "thunderstorm-with-rain": returnString = "дождь с грозой"; break;
            case "thunderstorm-with-hail": returnString = "гроза с градом"; break;
        }
        return returnString;
    }

    @Override
    public String toString() {
        return "DayShort{" +
                "temp=" + temp +
                ", condition='" + condition + '\'' +
                '}';
    }
}

