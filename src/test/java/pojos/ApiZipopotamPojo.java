package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiZipopotamPojo {
   private String postCode;
   private String country;
   private String countryAbbreviation;
   private ApiZipopotamPlacesPojo places;

    public ApiZipopotamPojo() {
    }

    public ApiZipopotamPojo(String postCode, String country, String countryAbbreviation, ApiZipopotamPlacesPojo places) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.places = places;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public ApiZipopotamPlacesPojo getPlaces() {
        return places;
    }

    public void setPlaces(ApiZipopotamPlacesPojo places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "ApiZippatomPojo{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", places=" + places +
                '}';
    }
}
/*
 {
    "post code": "01001",
    "country": "Spain",
    "country abbreviation": "ES",
    "places": [
        {
            "place name": "Vitoria-Gasteiz",
            "longitude": "-2.6667",
            "state": "Pais Vasco",
            "state abbreviation": "PV",
            "latitude": "42.85"
        }
    ]
}
 */
