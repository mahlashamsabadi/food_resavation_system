package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQuery(
        name = Reservation.FIND_ALL_BY_USER_ID,
        query = "SELECT r FROM Reservation r WHERE r.user.id = :userId "
)
public class Reservation {
    public static final String FIND_ALL_BY_USER_ID = "Reservation.FIND_ALL_BY_USER_ID";
    private long id;
    private AppUser user;
    private Meal meal;
    private Date reservationDate;
    private String status;
    private int quantity;
    private Long totalPrice;
    private Date creationDate;
    private Date modificationDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "MEAL_ID", nullable = false)
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Basic
    @Column(name = "RESERVATION_DATE", nullable = false)
    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "TOTAL_PRICE")
    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date createdAt) {
        this.creationDate = createdAt;
    }

    @Basic
    @Column(name = "MODIFICATION_DATE", nullable = true)
    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date updatedAt) {
        this.modificationDate = updatedAt;
    }

}
