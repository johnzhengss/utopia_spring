package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private UserRole userRole;
    private String givenName;
    private String familyName;
    private String username;
    private String email;
    private String password;
    private String phone;
}
