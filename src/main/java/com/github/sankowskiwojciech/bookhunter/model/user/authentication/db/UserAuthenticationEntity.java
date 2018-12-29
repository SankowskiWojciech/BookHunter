package com.github.sankowskiwojciech.bookhunter.model.user.authentication.db;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_AUTHENTICATION")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(of = {"userName", "emailAddress"})
public class UserAuthenticationEntity {

    @Id
    @Column(name = "USER_NAME", unique = true, nullable = false, length = 20)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, length = 60)
    private String password;

    @Column(name = "EMAIL_ADDRESS", unique = true, nullable = false, length = 30)
    private String emailAddress;
}
