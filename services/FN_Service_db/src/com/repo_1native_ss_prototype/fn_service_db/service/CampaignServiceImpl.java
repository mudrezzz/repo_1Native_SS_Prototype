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

import com.repo_1native_ss_prototype.fn_service_db.Ads;
import com.repo_1native_ss_prototype.fn_service_db.Campaign;
import com.repo_1native_ss_prototype.fn_service_db.StatsDays;


/**
 * ServiceImpl object for domain model class Campaign.
 *
 * @see Campaign
 */
@Service("FN_Service_db.CampaignService")
public class CampaignServiceImpl implements CampaignService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignServiceImpl.class);

    @Autowired
	@Qualifier("FN_Service_db.AdsService")
	private AdsService adsService;

    @Autowired
	@Qualifier("FN_Service_db.StatsDaysService")
	private StatsDaysService statsDaysService;

    @Autowired
    @Qualifier("FN_Service_db.CampaignDao")
    private WMGenericDao<Campaign, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Campaign, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "FN_Service_dbTransactionManager")
    @Override
	public Campaign create(Campaign campaign) {
        LOGGER.debug("Creating a new Campaign with information: {}", campaign);
        Campaign campaignCreated = this.wmGenericDao.create(campaign);
        if(campaignCreated.getAdses() != null) {
            for(Ads adse : campaignCreated.getAdses()) {
                adse.setCampaign(campaignCreated);
                LOGGER.debug("Creating a new child Ads with information: {}", adse);
                adsService.create(adse);
            }
        }

        if(campaignCreated.getStatsDayses() != null) {
            for(StatsDays statsDayse : campaignCreated.getStatsDayses()) {
                statsDayse.setCampaign(campaignCreated);
                LOGGER.debug("Creating a new child StatsDays with information: {}", statsDayse);
                statsDaysService.create(statsDayse);
            }
        }
        return campaignCreated;
    }

	@Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Campaign getById(Integer campaignId) throws EntityNotFoundException {
        LOGGER.debug("Finding Campaign by id: {}", campaignId);
        Campaign campaign = this.wmGenericDao.findById(campaignId);
        if (campaign == null){
            LOGGER.debug("No Campaign found with id: {}", campaignId);
            throw new EntityNotFoundException(String.valueOf(campaignId));
        }
        return campaign;
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Campaign findById(Integer campaignId) {
        LOGGER.debug("Finding Campaign by id: {}", campaignId);
        return this.wmGenericDao.findById(campaignId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "FN_Service_dbTransactionManager")
	@Override
	public Campaign update(Campaign campaign) throws EntityNotFoundException {
        LOGGER.debug("Updating Campaign with information: {}", campaign);
        this.wmGenericDao.update(campaign);

        Integer campaignId = campaign.getId();

        return this.wmGenericDao.findById(campaignId);
    }

    @Transactional(value = "FN_Service_dbTransactionManager")
	@Override
	public Campaign delete(Integer campaignId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Campaign with id: {}", campaignId);
        Campaign deleted = this.wmGenericDao.findById(campaignId);
        if (deleted == null) {
            LOGGER.debug("No Campaign found with id: {}", campaignId);
            throw new EntityNotFoundException(String.valueOf(campaignId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
	@Override
	public Page<Campaign> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Campaigns");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Page<Campaign> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Campaigns");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service FN_Service_db for table Campaign to {} format", exportType);
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

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Page<Ads> findAssociatedAdses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated adses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("campaign.id = '" + id + "'");

        return adsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "FN_Service_dbTransactionManager")
    @Override
    public Page<StatsDays> findAssociatedStatsDayses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated statsDayses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("campaign.id = '" + id + "'");

        return statsDaysService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AdsService instance
	 */
	protected void setAdsService(AdsService service) {
        this.adsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service StatsDaysService instance
	 */
	protected void setStatsDaysService(StatsDaysService service) {
        this.statsDaysService = service;
    }

}

