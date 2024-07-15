package org.mywish.mywishserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mywish.mywishserver.entities.model.Price;
import org.mywish.mywishserver.entities.model.WishOwnerStatus;
import org.mywish.mywishserver.entities.model.WishUserStatus;

import java.util.List;

@Entity
@Table(name = "wishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(255) default 'NOT_PRESENTED'")
    private WishOwnerStatus wishOwnerStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(255) default 'NO_RESERVE'")
    private WishUserStatus wishUserStatus;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(nullable = false))
    })
    private Price price;

    @ManyToMany
    @JoinTable(
            name = "wishlist_wishes",
            joinColumns = @JoinColumn(name = "wish_id"),
            inverseJoinColumns = @JoinColumn(name = "wishlist_id")
    )
    private List<WishlistEntity> wishlists;

    private String productPhotoLink;
    private String description;
    private String productLink;
}