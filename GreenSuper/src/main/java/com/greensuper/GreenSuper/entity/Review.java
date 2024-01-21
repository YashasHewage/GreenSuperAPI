/*
package com.greensuper.GreenSuper.entity;


import com.greensuper.GreenSuper.dto.ReviewDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rating;

    @Lob
    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public ReviewDto getDto() {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(id);
        reviewDto.setRating(rating);
        reviewDto.setDescription(description);
        reviewDto.setProductId(product.getId());
        reviewDto.setUserId(user.getId());
        reviewDto.setUserName(user.getFirstName());
        reviewDto.setUserName(user.getLastName());

        return reviewDto;
    }
}
*/
