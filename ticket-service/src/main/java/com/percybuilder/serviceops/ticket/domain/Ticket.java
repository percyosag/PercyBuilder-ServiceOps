package com.percybuilder.serviceops.ticket.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

    @Entity
    @Table(name = "tickets")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 150)
        private String title;

        @Column(nullable = false, columnDefinition = "text")
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 20)
        private TicketStatus status = TicketStatus.OPEN;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 20)
        private TicketPriority priority;

        @Column(name = "reported_by_user_id", nullable = false)
        private Long reportedByUserId;

        @Column(name = "assigned_to_user_id")
        private Long assignedToUserId;

        @CreationTimestamp
        @Column(name = "created_at", nullable = false, updatable = false)
        private Instant createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private Instant updatedAt;

        public Ticket(String title, String description,
                      TicketPriority priority, Long reportedByUserId) {
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.reportedByUserId = reportedByUserId;
        }
    }