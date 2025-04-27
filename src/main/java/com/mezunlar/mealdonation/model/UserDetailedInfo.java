package com.mezunlar.mealdonation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailedInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the main User entity
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_Id", nullable = false)
    private User user;

    // Fields specific to a student (if role == STUDENT)
    private String studentDocumentPath;
    private LocalDate approvedUntilDate;

    // Fields specific to a merchant (if role == MERCHANT)
    private String restaurantName;
    private String merchantAddress;

    // Additional fields can be added, depending on your design
    private String phoneNumber;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
