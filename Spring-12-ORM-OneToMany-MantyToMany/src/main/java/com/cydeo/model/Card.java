package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="carts")
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 @ManyToMany
 // you mark it is joinTable
 @JoinTable(name="card_item_relationship"
 ,joinColumns = @JoinColumn(name="c_id")
 ,inverseJoinColumns = @JoinColumn(name="i_id"))
    private List<Item> itemList; // card is ownership
}
