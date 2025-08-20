package co.edu.javeriana.ejemplojpa.dto;

public class PersonDTO {
    private Long id;
    private String cedula;
    private String firstName;
    private String lastName;


    
    public PersonDTO() {
    }

    public PersonDTO(String cedula, String firstName, String lastName) {
        this.cedula = cedula;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
