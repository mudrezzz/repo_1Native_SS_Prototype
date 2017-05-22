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
import com.repo_1native_ss_prototype.fn_service_db.StatsDays;
import com.repo_1native_ss_prototype.fn_service_db.service.AdsService;


/**
 * Controller object for domain model class Ads.
 * @see Ads
 */
@RestController("FN_Service_db.AdsController")
@Api(value = "AdsController", description = "Exposes APIs to work with Ads resource.")
@RequestMapping("/FN_Service_db/Ads")
public class AdsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdsController.class);

    @Autowired
	@Qualifier("FN_Service_db.AdsService")
	private AdsService adsService;

	@ApiOperation(value = "Creates a new Ads instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Ads createAds(@RequestBody Ads ads) {
		LOGGER.debug("Create Ads with information: {}" , ads);

		ads = adsService.create(ads);
		LOGGER.debug("Created Ads with information: {}" , ads);

	    return ads;
	}


    @ApiOperation(value = "Returns the Ads instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Ads getAds(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Ads with id: {}" , id);

        Ads foundAds = adsService.getById(id);
        LOGGER.debug("Ads details with id: {}" , foundAds);

        return foundAds;
    }

    @ApiOperation(value = "Updates the Ads instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Ads editAds(@PathVariable("id") Integer id, @RequestBody Ads ads) throws EntityNotFoundException {
        LOGGER.debug("Editing Ads with id: {}" , ads.getId());

        ads.setId(id);
        ads = adsService.update(ads);
        LOGGER.debug("Ads details with id: {}" , ads);

        return ads;
    }

    @ApiOperation(value = "Deletes the Ads instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAds(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Ads with id: {}" , id);

        Ads deletedAds = adsService.delete(id);

        return deletedAds != null;
    }

    /**
     * @deprecated Use {@link #findAds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Ads instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ads> searchAdsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Ads list");
        return adsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Ads instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ads> findAds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ads list");
        return adsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Ads instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ads> filterAds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ads list");
        return adsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return adsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Ads instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Ads");
		return adsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAdsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return adsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/statsDayses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the statsDayses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StatsDays> findAssociatedStatsDayses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated statsDayses");
        return adsService.findAssociatedStatsDayses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AdsService instance
	 */
	protected void setAdsService(AdsService service) {
		this.adsService = service;
	}

}
