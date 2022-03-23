package Info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @JsonProperty("name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (this.name == null)
            return "N/A";
        else
            return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
