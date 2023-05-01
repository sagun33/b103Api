package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponsePojo {
    private String meta;
    private GoRestRequest data;

    public GoRestResponsePojo() {
    }

    public GoRestResponsePojo(String meta, GoRestRequest data) {
        this.meta = meta;
        this.data = data;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public GoRestRequest getData() {
        return data;
    }

    public void setData(GoRestRequest data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestResponsePojo{" +
                "meta='" + meta + '\'' +
                ", data=" + data +
                '}';
    }
}
