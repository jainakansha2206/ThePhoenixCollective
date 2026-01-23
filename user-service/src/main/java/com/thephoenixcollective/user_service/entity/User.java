package com.thephoenixcollective.user_service.entity;

import com.thephoenixcollective.user_service.utility.AppConstants;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = AppConstants.USER_TABLE, schema = AppConstants.PHOENIX_SCHEMA)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 50)
    private Long id;

    private String name;
    @Column(name="phone_number")
    private String phoneNumber;
    private String email;

    @Column(name = "username")
    private String userName;
    private String password;
    private String role;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_by")
    private String createdBy;
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedDate;
}
