/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.repo_1native_ss_prototype.fn_service_db.Advertiser;


/**
 * ServiceImpl object for domain model class Advertiser.
 *
 * @see Advertiser
 */
@Service("FN_Service_db.AdvertiserService")
public class AdvertiserServiceImpl implements AdvertiserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdvertiserServiceImpl.class);


    @Autowired
    @Qualifier("FN_Service_db.AdvertiserDao")
    private WMGenericDao<Advertiser, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Advertiser, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "FN_Service_dbTransactionManager")
    @Override
	public Advertiser create(Advertiser advertiser) {
        LOGGER.debug("Creating a new Advertiser with information: {}", advertiser);
        Advertiser advertiserCreated = this.wmGenericDao.create(advertiser);
        return advertiserCreated;
    }

	@Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Advertiser getById(Integer advertiserId) throws EntityNotFoundException {
        LOGGER.debug("Finding Advertiser by id: {}", advertiserId);
        Advertiser advertiser = this.wmGenericDao.findById(advertiserId);
        if (advertiser == null){
            LOGGER.debug("No Advertiser found with id: {}", advertiserId);
            throw new EntityNotFoundException(String.valueOf(advertiserId));
        }
        return advertiser;
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Advertiser findById(Integer advertiserId) {
        LOGGER.debug("Finding Advertiser by id: {}", advertiserId);
        return this.wmGenericDao.findById(advertiserId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "FN_Service_dbTransactionManager")
	@Override
	public Advertiser update(Advertiser advertiser) throws EntityNotFoundException {
        LOGGER.debug("Updating Advertiser with information: {}", advertiser);
        this.wmGenericDao.update(advertiser);

        Integer advertiserId = advertiser.getId();

        return this.wmGenericDao.findById(advertiserId);
    }

    @Transactional(value = "FN_Service_dbTransactionManager")
	@Override
	public Advertiser delete(Integer advertiserId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Advertiser with id: {}", advertiserId);
        Advertiser deleted = this.wmGenericDao.findById(advertiserId);
        if (deleted == null) {
            LOGGER.debug("No Advertiser found with id: {}", advertiserId);
            throw new EntityNotFoundException(String.valueOf(advertiserId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Page<Advertiser> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Advertisers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Page<Advertiser> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Advertisers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service FN_Service_db for table Advertiser to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

