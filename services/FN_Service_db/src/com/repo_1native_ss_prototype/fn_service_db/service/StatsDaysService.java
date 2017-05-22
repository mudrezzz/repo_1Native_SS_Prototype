/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/
package com.repo_1native_ss_prototype.fn_service_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.repo_1native_ss_prototype.fn_service_db.StatsDays;

/**
 * Service object for domain model class {@link StatsDays}.
 */
public interface StatsDaysService {

    /**
     * Creates a new StatsDays. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on StatsDays if any.
     *
     * @param statsDays Details of the StatsDays to be created; value cannot be null.
     * @return The newly created StatsDays.
     */
	StatsDays create(StatsDays statsDays);


	/**
	 * Returns StatsDays by given id if exists.
	 *
	 * @param statsdaysId The id of the StatsDays to get; value cannot be null.
	 * @return StatsDays associated with the given statsdaysId.
     * @throws EntityNotFoundException If no StatsDays is found.
	 */
	StatsDays getById(Integer statsdaysId) throws EntityNotFoundException;

    /**
	 * Find and return the StatsDays by given id if exists, returns null otherwise.
	 *
	 * @param statsdaysId The id of the StatsDays to get; value cannot be null.
	 * @return StatsDays associated with the given statsdaysId.
	 */
	StatsDays findById(Integer statsdaysId);


	/**
	 * Updates the details of an existing StatsDays. It replaces all fields of the existing StatsDays with the given statsDays.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on StatsDays if any.
     *
	 * @param statsDays The details of the StatsDays to be updated; value cannot be null.
	 * @return The updated StatsDays.
	 * @throws EntityNotFoundException if no StatsDays is found with given input.
	 */
	StatsDays update(StatsDays statsDays) throws EntityNotFoundException;

    /**
	 * Deletes an existing StatsDays with the given id.
	 *
	 * @param statsdaysId The id of the StatsDays to be deleted; value cannot be null.
	 * @return The deleted StatsDays.
	 * @throws EntityNotFoundException if no StatsDays found with the given id.
	 */
	StatsDays delete(Integer statsdaysId) throws EntityNotFoundException;

	/**
	 * Find all StatsDays matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching StatsDays.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<StatsDays> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all StatsDays matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching StatsDays.
     *
     * @see Pageable
     * @see Page
	 */
    Page<StatsDays> findAll(String query, Pageable pageable);

    /**
	 * Exports all StatsDays matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the StatsDays in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the StatsDays.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

