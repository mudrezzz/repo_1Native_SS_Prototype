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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Tags generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TAGS`")
public class Tags implements Serializable {

    private Integer id;
    private String type;
    private int status;
    private float price;
    private String testUrl;
    private Integer publisherId;
    private Integer siteId;
    private Publisher publisher;
    private Sites sites;
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

    @Column(name = "`type`", nullable = false, length = 255)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`status`", nullable = false, scale = 0, precision = 10)
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "`price`", nullable = false, scale = 2, precision = 10)
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "`test_url`", nullable = true, length = 255)
    public String getTestUrl() {
        return this.testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }

    @Column(name = "`publisher_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    @Column(name = "`site_id`", nullable = true, scale = 0, precision = 10)
    public Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`site_id`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public Sites getSites() {
        return this.sites;
    }

    public void setSites(Sites sites) {
        if(sites != null) {
            this.siteId = sites.getId();
        }

        this.sites = sites;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tags")
    public List<StatsDays> getStatsDayses() {
        return this.statsDayses;
    }

    public void setStatsDayses(List<StatsDays> statsDayses) {
        this.statsDayses = statsDayses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tags)) return false;
        final Tags tags = (Tags) o;
        return Objects.equals(getId(), tags.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
