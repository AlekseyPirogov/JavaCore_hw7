package Info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    @JsonProperty("url")    // ссылка
    private String url;
    @JsonProperty("lat")    // широта
    private double lat;
    @JsonProperty("lon")    // долгота
    private double lon;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "Info{" +
                "url='" + url + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}