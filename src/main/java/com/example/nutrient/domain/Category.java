package com.example.nutrient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Category extends BaseTimeEntity implements Persistable {

    @Id
    @Column(name = "id", columnDefinition = "varbinary(16)")
    private UUID id;

    @Embedded
    private CategoryTitle title;

    @Embedded
    private CategoryContent content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id",
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_category_to_parent"))
    private Category parentCategory;

    @Override
    public boolean isNew() {
        return this.getCreatedAt() == null;
    }

    public void updateTitle(String name) {
        this.title = new CategoryTitle(name);
    }

    public void updateContent(Integer depth) {
        this.content = new CategoryContent(depth);
    }

    public String getName() {
        return this.getTitle().getName();
    }

    public int getDepth() {
        return this.getContent().getDepth();
    }
}
