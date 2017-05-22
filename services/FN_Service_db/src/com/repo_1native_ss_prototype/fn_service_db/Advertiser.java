/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Advertiser generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ADVERTISER`")
public class Advertiser implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private int balance;
    private Integer publisherId;
    private Publisher publisher;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`balance`", nullable = false, scale = 0, precision = 10)
    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column(name = "`publisher_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`publisher_id`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        if(publisher != null) {
            this.publisherId = publisher.getId();
        }

        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advertiser)) return false;
        final Advertiser advertiser = (Advertiser) o;
        return Objects.equals(getId(), advertiser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
