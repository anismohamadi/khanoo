package com.kurdestan.khanoo.city;

import com.kurdestan.khanoo.common.BaseEntity;
import com.kurdestan.khanoo.region.Region;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_city")
@Audited
public class City extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
    private  List<Region> regions;

}
