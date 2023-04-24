package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
public class Item { // there is manyToMany between cart and item, you need helper table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @ManyToMany(mappedBy = "itemList")// card can
    private List<Card> card;// use Set in some occasition
    // items_card will be created and we call this join table
    // who is ownership, you can pick it up yourself
}
