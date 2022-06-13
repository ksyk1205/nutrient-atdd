package com.example.nutrient.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Combination {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private CombinationTitle title;

    @Embedded
    private CombinationContent content;

    @Enumerated(EnumType.STRING)
    private Gender recommendedGender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "health_status_id",
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_combination_to_health_status")
    )
    private HealthStatus healthStatus;

    @Embedded
    private CombinationLineItems combinationLineItems;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title.getTitle();
    }

    public String getContent() {
        return content.getContent();
    }

    public Gender getRecommendedGender() {
        return recommendedGender;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public List<CombinationLineItem> getCombinationLineItems() {
        return combinationLineItems.getCombinationLineItems();
    }


    public void changeTitle(CombinationTitle title) {
        this.title = title;
    }

    public void changeContent(CombinationContent content) {
        this.content = content;
    }

    public void changeRecommendedTarget(Gender gender, HealthStatus healthStatus) {
        this.recommendedGender = gender;
        this.healthStatus = healthStatus;
    }

    public void changeCombinationLineItems(CombinationLineItems combinationLineItems) {
        this.combinationLineItems = combinationLineItems;
    }
}
