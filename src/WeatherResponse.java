import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import Info.Geo_object;
import Info.Info;
import Weather.Forecasts;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("now")
    private Integer now;
    @JsonProperty("now_dt")
    private String now_dt;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("geo_object")
    private Geo_object geo_object;
    @JsonProperty("forecasts")
    private List<Forecasts> forecasts;

    public Integer getNow() {
        return now;
    }

    public String getNow_dt() {
        return now_dt;
    }

    public Info getInfo() {
        return info;
    }

    public Geo_object getGeo_object() {
        return geo_object;
    }

    public List<Forecasts> getForecasts() {
        return forecasts;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "now=" + now +
                ", now_dt='" + now_dt + '\'' +
                ", info=" + info +
                ", geo_object=" + geo_object +
                ", forecast=" + forecasts +
                '}';
    }
}
