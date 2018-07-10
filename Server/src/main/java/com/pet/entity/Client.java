package com.pet.entity;

import lombok.Getter;
import lombok.Setter;

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
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "Users.findByEmail", query = "SELECT u from Client u where u.email = :email"),
        @NamedQuery(name = "Users.findById", query = "SELECT u from Client u where u.userId = :userId")
})
@Getter
@Setter
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String EMAIL_PATTERN = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
            "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private static final String PHONE_NUMBER_PATTERN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;
    @NotNull
    @Column(name = "firstname")
    private String firstName;
    @NotNull
    @Column(name = "lastname")
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    private Date birthday;
    @NotNull
    @Pattern(regexp = EMAIL_PATTERN, message = "{invalid.email}")
    private String email;
    @Pattern(regexp = PHONE_NUMBER_PATTERN, message = "{invalid.phonenumber}")
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "passwordhash")
    private String passwordHash;
    @Column(name = "passwordsalt")
    private String passwordSalt;

    public Client() {
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

        if (!Objects.equals(userId, client.getUserId())) {
            return false;
        }
        if (!Objects.equals(firstName, client.getFirstName())) {
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
        int result = userId.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
