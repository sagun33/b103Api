package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestPojo {

    private Object mata;
    private GoRestDataPojo data;

    public GoRestPojo() {
    }

    public GoRestPojo(Object mata, GoRestDataPojo data) {
        this.mata = mata;
        this.data = data;
    }

    public Object getMata() {
        return mata;
    }

    public void setMata(Object mata) {
        this.mata = mata;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestPojo{" +
                "mata=" + mata +
                ", data=" + data +
                '}';
    }
}
