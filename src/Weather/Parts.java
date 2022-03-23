package Weather;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "day_short",
        "night",
        "night_short"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parts {

    @JsonProperty("day")
    private Day day;
    @JsonProperty("day_short")
    private DayShort dayShort;
    @JsonProperty("night")
    private Night night;
    @JsonProperty("night_short")
    private NightShort nightShort;

//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public void setDay(Day day) {
        this.day = day;
    }

    public void setDayShort(DayShort dayShort) {
        this.dayShort = dayShort;
    }

    public void setNight(Night night) {
        this.night = night;
    }

    public void setNightShort(NightShort nightShort) {
        this.nightShort = nightShort;
    }

    public Day getDay() {
        return day;
    }

    public DayShort getDayShort() {
        return dayShort;
    }

    public Night getNight() {
        return night;
    }

    public NightShort getNightShort() {
        return nightShort;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "day=" + day +
                ", dayShort=" + dayShort +
                ", night=" + night +
                ", nightShort=" + nightShort +
                '}';
    }
}