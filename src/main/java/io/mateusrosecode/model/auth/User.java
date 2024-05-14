package io.mateusrosecode.model.auth;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * The User class represents a user in the authentication system.
 * It extends PanacheEntity, which means it automatically has an ID field that is managed by Hibernate ORM.
 * It is annotated with @UserDefinition, which means it is used by Quarkus Security to authenticate users.
 */
@Entity
@Table(name = "app_users")
@UserDefinition
public class User extends PanacheEntity {
    /**
     * The username field represents the username of the user.
     * It is annotated with @Username, which means it is used by Quarkus Security as the username of the user.
     */
    @Username
    public String username;

    /**
     * The password field represents the password of the user.
     * It is annotated with @Password, which means it is used by Quarkus Security as the password of the user.
     */
    @Password
    public String password;

    /**
     * The role field represents the role of the user.
     * It is annotated with @Roles, which means it is used by Quarkus Security to authorize the user.
     */
    @Roles
    public String role;

    /**
     * The add method creates a new User entity and persists it to the database.
     * It hashes the password using Bcrypt before storing it.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @param role The role of the new user.
     */
    public static void add(String username, String password, String role) {
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
    }
}