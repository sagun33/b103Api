package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresInApiDataPojo {

    private Integer id;
    private String email;
    private String first_Name;
    private String last_Name;
    private String avatar;

    public RegresInApiDataPojo() {
    }

    public RegresInApiDataPojo(Integer id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.first_Name = firstName;
        this.last_Name = lastName;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String firstName) {
        this.first_Name = firstName;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String lastName) {
        this.last_Name = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "RegresInApiIcDataPjo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + first_Name + '\'' +
                ", lastName='" + last_Name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
/*
 "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
 */