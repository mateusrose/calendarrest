package io.mateusrosecode.model.auth;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_users")
@UserDefinition
public class User extends PanacheEntity {
    @Username
    public String username;

    @Password
    public String password;

    @Roles
    public String role;

    //make method add user according to https://quarkus.io/guides/security-getting-started-tutorial

}
