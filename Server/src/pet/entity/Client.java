package pet.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Client entity
 */
@Entity
@NamedQuery(name = "Users.findByEmail", query = "SELECT u from Client u where u.email = :email")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String EMAIL_PATTERN = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
            "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private static final String PHONE_NUMBER_PATTERN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String fistName;
    @NotNull
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    private Date birthday;
    @NotNull
    @Pattern(regexp = EMAIL_PATTERN, message = "{invalid.email}")
    private String email;
    @Pattern(regexp = PHONE_NUMBER_PATTERN, message = "{invalid.phonenumber}")
    private String phoneNumber;
    private String passwordHash;
    private String passwordSalt;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public static String getEmailPattern() {
        return EMAIL_PATTERN;
    }

    public static String getPhoneNumberPattern() {
        return PHONE_NUMBER_PATTERN;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object entity) {
        if (this == entity) {
            return true;
        }
        if (Objects.isNull(entity) || getClass() != entity.getClass()) {
            return false;
        }

        Client client = (Client) entity;

        if (!Objects.equals(id, client.getId())) {
            return false;
        }
        if (!Objects.equals(fistName, client.getFistName())) {
            return false;
        }

        if (!Objects.equals(lastName, client.getLastName())) {
            return false;
        }
        if (Objects.isNull(birthday) || Objects.equals(birthday, client.getBirthday())) {
            return false;
        }
        if (!Objects.equals(email, client.getEmail())) {
            return false;
        }
        return Objects.nonNull(phoneNumber) && Objects.equals(phoneNumber, client.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + fistName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
