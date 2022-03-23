package Info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo_object {

    @JsonProperty("district")
    private District district;
    @JsonProperty("locality")
    private Locality locality;
    @JsonProperty("province")
    private Province province;
    @JsonProperty("country")
    private Country country;

    public void setDistrict(District district) {
        this.district = district;
    }

    public District getDistrict() {
        return district;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Geo_object{" +
                "district=" + district +
                ", locality=" + locality +
                ", province=" + province +
                ", country=" + country +
                '}';
    }

    public Geo_object(){}
}
