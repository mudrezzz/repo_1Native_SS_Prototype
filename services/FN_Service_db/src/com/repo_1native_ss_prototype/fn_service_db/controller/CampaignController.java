/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.repo_1native_ss_prototype.fn_service_db.Ads;
import com.repo_1native_ss_prototype.fn_service_db.Campaign;
import com.repo_1native_ss_prototype.fn_service_db.StatsDays;
import com.repo_1native_ss_prototype.fn_service_db.service.CampaignService;


/**
 * Controller object for domain model class Campaign.
 * @see Campaign
 */
@RestController("FN_Service_db.CampaignController")
@Api(value = "CampaignController", description = "Exposes APIs to work with Campaign resource.")
@RequestMapping("/FN_Service_db/Campaign")
public class CampaignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
	@Qualifier("FN_Service_db.CampaignService")
	private CampaignService campaignService;

	@ApiOperation(value = "Creates a new Campaign instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Campaign createCampaign(@RequestBody Campaign campaign) {
		LOGGER.debug("Create Campaign with information: {}" , campaign);

		campaign = campaignService.create(campaign);
		LOGGER.debug("Created Campaign with information: {}" , campaign);

	    return campaign;
	}


    @ApiOperation(value = "Returns the Campaign instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Campaign getCampaign(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Campaign with id: {}" , id);

        Campaign foundCampaign = campaignService.getById(id);
        LOGGER.debug("Campaign details with id: {}" , foundCampaign);

        return foundCampaign;
    }

    @ApiOperation(value = "Updates the Campaign instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Campaign editCampaign(@PathVariable("id") Integer id, @RequestBody Campaign campaign) throws EntityNotFoundException {
        LOGGER.debug("Editing Campaign with id: {}" , campaign.getId());

        campaign.setId(id);
        campaign = campaignService.update(campaign);
        LOGGER.debug("Campaign details with id: {}" , campaign);

        return campaign;
    }

    @ApiOperation(value = "Deletes the Campaign instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCampaign(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Campaign with id: {}" , id);

        Campaign deletedCampaign = campaignService.delete(id);

        return deletedCampaign != null;
    }

    /**
     * @deprecated Use {@link #findCampaigns(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Campaign instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Campaign> searchCampaignsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Campaigns list");
        return campaignService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Campaign instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Campaign> findCampaigns(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Campaigns list");
        return campaignService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Campaign instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Campaign> filterCampaigns(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Campaigns list");
        return campaignService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCampaigns(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return campaignService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Campaign instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCampaigns( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Campaigns");
		return campaignService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCampaignAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return campaignService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/adses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the adses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ads> findAssociatedAdses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated adses");
        return campaignService.findAssociatedAdses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/statsDayses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the statsDayses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StatsDays> findAssociatedStatsDayses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated statsDayses");
        return campaignService.findAssociatedStatsDayses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CampaignService instance
	 */
	protected void setCampaignService(CampaignService service) {
		this.campaignService = service;
	}

}

