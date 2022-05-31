package com.example.nutrient.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
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

    public CombinationLineItem(Supplement supplement) {
        this.supplement = supplement;
    }
}
