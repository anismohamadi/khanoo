package com.kurdestan.khanoo.image;

import com.kurdestan.khanoo.common.BaseEntity;
import com.kurdestan.khanoo.house.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.*;



@Entity
@Data
@Audited
@Table(name = "tbl_image")
public class Image extends BaseEntity {

    @NotNull
    @Column(name = "image")
    private  String image;



    @ManyToOne
    @JoinColumn(name = "house_id", unique = true)
    private  House house;



}
