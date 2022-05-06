package com.example.nutrient.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CombinationLineItem {
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long seq;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "supplement_id",
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_combination_line_item_to_supplement")
    )
    private Supplement supplement;
}
