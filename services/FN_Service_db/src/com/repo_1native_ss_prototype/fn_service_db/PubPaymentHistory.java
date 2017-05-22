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
 * PubPaymentHistory generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PUB_PAYMENT_HISTORY`")
public class PubPaymentHistory implements Serializable {

    private Integer id;
    private int publisherId;
    private String transactionName;
    private int type;
    private float summ;
    private float balanceBefore;
    private float balanceAfter;
    private float _1nComission;
    private String documentRef;
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

    @Column(name = "`publisher_id`", nullable = false, scale = 0, precision = 10)
    public int getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Column(name = "`transaction_name`", nullable = false, length = 255)
    public String getTransactionName() {
        return this.transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    @Column(name = "`type`", nullable = false, scale = 0, precision = 10)
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "`summ`", nullable = false, scale = 2, precision = 10)
    public float getSumm() {
        return this.summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    @Column(name = "`balance_before`", nullable = false, scale = 2, precision = 10)
    public float getBalanceBefore() {
        return this.balanceBefore;
    }

    public void setBalanceBefore(float balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    @Column(name = "`balance_after`", nullable = false, scale = 2, precision = 10)
    public float getBalanceAfter() {
        return this.balanceAfter;
    }

    public void setBalanceAfter(float balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    @Column(name = "`1n_comission`", nullable = false, scale = 2, precision = 10)
    public float get_1nComission() {
        return this._1nComission;
    }

    public void set_1nComission(float _1nComission) {
        this._1nComission = _1nComission;
    }

    @Column(name = "`document_ref`", nullable = false, length = 255)
    public String getDocumentRef() {
        return this.documentRef;
    }

    public void setDocumentRef(String documentRef) {
        this.documentRef = documentRef;
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
        if (!(o instanceof PubPaymentHistory)) return false;
        final PubPaymentHistory pubPaymentHistory = (PubPaymentHistory) o;
        return Objects.equals(getId(), pubPaymentHistory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

