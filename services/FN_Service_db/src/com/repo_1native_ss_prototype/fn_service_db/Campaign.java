/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
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
 * Campaign generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CAMPAIGN`")
public class Campaign implements Serializable {

    private Integer id;
    private String name;
    private int status;
    private Date dateFrom;
    private Date dateTo;
    private Integer freqPerHour;
    private Integer freqPerDay;
    private Integer freqPerWeek;
    private String keywordsJson;
    private String browsersJson;
    private String osJson;
    private String daysJson;
    private String hoursJson;
    private float budget;
    private float price;
    private int priceType;
    private String geoJson;
    private int publisherId;
    private Integer advId;
    private Publisher publisher;
    private List<Ads> adses;
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

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`status`", nullable = false, scale = 0, precision = 10)
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "`date_from`", nullable = false)
    public Date getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Column(name = "`date_to`", nullable = false)
    public Date getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Column(name = "`freq_per_hour`", nullable = true, scale = 0, precision = 10)
    public Integer getFreqPerHour() {
        return this.freqPerHour;
    }

    public void setFreqPerHour(Integer freqPerHour) {
        this.freqPerHour = freqPerHour;
    }

    @Column(name = "`freq_per_day`", nullable = true, scale = 0, precision = 10)
    public Integer getFreqPerDay() {
        return this.freqPerDay;
    }

    public void setFreqPerDay(Integer freqPerDay) {
        this.freqPerDay = freqPerDay;
    }

    @Column(name = "`freq_per_week`", nullable = true, scale = 0, precision = 10)
    public Integer getFreqPerWeek() {
        return this.freqPerWeek;
    }

    public void setFreqPerWeek(Integer freqPerWeek) {
        this.freqPerWeek = freqPerWeek;
    }

    @Column(name = "`keywords_json`", nullable = true, length = 255)
    public String getKeywordsJson() {
        return this.keywordsJson;
    }

    public void setKeywordsJson(String keywordsJson) {
        this.keywordsJson = keywordsJson;
    }

    @Column(name = "`browsers_json`", nullable = true, length = 255)
    public String getBrowsersJson() {
        return this.browsersJson;
    }

    public void setBrowsersJson(String browsersJson) {
        this.browsersJson = browsersJson;
    }

    @Column(name = "`os_json`", nullable = true, length = 255)
    public String getOsJson() {
        return this.osJson;
    }

    public void setOsJson(String osJson) {
        this.osJson = osJson;
    }

    @Column(name = "`days_json`", nullable = true, length = 255)
    public String getDaysJson() {
        return this.daysJson;
    }

    public void setDaysJson(String daysJson) {
        this.daysJson = daysJson;
    }

    @Column(name = "`hours_json`", nullable = true, length = 255)
    public String getHoursJson() {
        return this.hoursJson;
    }

    public void setHoursJson(String hoursJson) {
        this.hoursJson = hoursJson;
    }

    @Column(name = "`budget`", nullable = false, scale = 2, precision = 10)
    public float getBudget() {
        return this.budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Column(name = "`price`", nullable = false, scale = 1, precision = 10)
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "`price_type`", nullable = false, scale = 0, precision = 10)
    public int getPriceType() {
        return this.priceType;
    }

    public void setPriceType(int priceType) {
        this.priceType = priceType;
    }

    @Column(name = "`geo_json`", nullable = true, length = 255)
    public String getGeoJson() {
        return this.geoJson;
    }

    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    @Column(name = "`publisher_id`", nullable = false, scale = 0, precision = 10)
    public int getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Column(name = "`adv_id`", nullable = true, scale = 0, precision = 10)
    public Integer getAdvId() {
        return this.advId;
    }

    public void setAdvId(Integer advId) {
        this.advId = advId;
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

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "campaign")
    public List<Ads> getAdses() {
        return this.adses;
    }

    public void setAdses(List<Ads> adses) {
        this.adses = adses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "campaign")
    public List<StatsDays> getStatsDayses() {
        return this.statsDayses;
    }

    public void setStatsDayses(List<StatsDays> statsDayses) {
        this.statsDayses = statsDayses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;
        final Campaign campaign = (Campaign) o;
        return Objects.equals(getId(), campaign.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
