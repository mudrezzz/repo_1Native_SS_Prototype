/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * OsDictionary generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`OS_DICTIONARY`")
public class OsDictionary implements Serializable {

    private Integer id;
    private String os;
    private List<StatsDays> statsDayses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`os`", nullable = false, length = 255)
    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "osDictionary")
    public List<StatsDays> getStatsDayses() {
        return this.statsDayses;
    }

    public void setStatsDayses(List<StatsDays> statsDayses) {
        this.statsDayses = statsDayses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OsDictionary)) return false;
        final OsDictionary osDictionary = (OsDictionary) o;
        return Objects.equals(getId(), osDictionary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

