package com.example.nutrient.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.example.nutrient.application.dto.supplement.SupplementCreateResponse.CategoryResponse;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Supplement extends BaseTimeEntity implements Persistable {

    @Id
    @Column(name = "id", columnDefinition = "varbinary(16)")
    private UUID id;

    @Embedded
    private SupplementTitle title;

    @Embedded
    private SupplementContent content;

    //private Category category;
    @Override
    public boolean isNew() {
        return this.getCreatedAt() == null;
    }


}
