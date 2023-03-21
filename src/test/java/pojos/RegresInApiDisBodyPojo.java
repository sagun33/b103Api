package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresInApiDisBodyPojo {
    private RegresInApiDataPojo data;
    private RegresInApiSupportPojo support;

    public RegresInApiDisBodyPojo() {
    }

    public RegresInApiDisBodyPojo(RegresInApiDataPojo data, RegresInApiSupportPojo support) {
        this.data = data;
        this.support = support;
    }

    public RegresInApiDataPojo getData() {
        return data;
    }

    public void setData(RegresInApiDataPojo data) {
        this.data = data;
    }

    public RegresInApiSupportPojo getSupport() {
        return support;
    }

    public void setSupport(RegresInApiSupportPojo support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "RegresInApiDisBodyPojo{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
/*
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 */