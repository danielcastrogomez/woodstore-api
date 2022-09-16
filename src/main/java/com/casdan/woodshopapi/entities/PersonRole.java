package com.casdan.woodshopapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person_role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_role_id")
    private Long userRoleId;

    @Column(name="person_id", nullable=false, insertable=false, updatable = false)
    private Long userId;

    @Column(name="role_id", nullable=false, insertable=false, updatable = false)
    private Long roleId;

    @Column(name="user_since", nullable=false)
    private Date userSince;

    @Column(name="user_until", nullable=false)
    private Date userUntil;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;



}
