package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.webserver.projects.Project;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_user")
    private Long idUser;

    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "last_name")
    private String lastName;

    private String login;

    private Boolean accepted; //Зарегестрирован или нет?

    //@Column(name = "user_type")
    private String userType;

    private String password;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "id_project")
    private Project project;


    public User() {

    }

    public User(String firstName, String lastName, String login, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.userType = userType;
        this.password = password;
    }

    public User(String firstName, String lastName, String login, String password, String userType,Project project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.userType = userType;
        this.password = password;
        this.project = project;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser.equals(user.idUser) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && login.equals(user.login) && Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, firstName, lastName, login, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
