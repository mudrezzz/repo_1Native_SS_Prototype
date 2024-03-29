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
import com.repo_1native_ss_prototype.fn_service_db.Tags;

/**
 * Service object for domain model class {@link Tags}.
 */
public interface TagsService {

    /**
     * Creates a new Tags. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Tags if any.
     *
     * @param tags Details of the Tags to be created; value cannot be null.
     * @return The newly created Tags.
     */
	Tags create(Tags tags);


	/**
	 * Returns Tags by given id if exists.
	 *
	 * @param tagsId The id of the Tags to get; value cannot be null.
	 * @return Tags associated with the given tagsId.
     * @throws EntityNotFoundException If no Tags is found.
	 */
	Tags getById(Integer tagsId) throws EntityNotFoundException;

    /**
	 * Find and return the Tags by given id if exists, returns null otherwise.
	 *
	 * @param tagsId The id of the Tags to get; value cannot be null.
	 * @return Tags associated with the given tagsId.
	 */
	Tags findById(Integer tagsId);


	/**
	 * Updates the details of an existing Tags. It replaces all fields of the existing Tags with the given tags.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Tags if any.
     *
	 * @param tags The details of the Tags to be updated; value cannot be null.
	 * @return The updated Tags.
	 * @throws EntityNotFoundException if no Tags is found with given input.
	 */
	Tags update(Tags tags) throws EntityNotFoundException;

    /**
	 * Deletes an existing Tags with the given id.
	 *
	 * @param tagsId The id of the Tags to be deleted; value cannot be null.
	 * @return The deleted Tags.
	 * @throws EntityNotFoundException if no Tags found with the given id.
	 */
	Tags delete(Integer tagsId) throws EntityNotFoundException;

	/**
	 * Find all Tags matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Tags.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Tags> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Tags matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Tags.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Tags> findAll(String query, Pageable pageable);

    /**
	 * Exports all Tags matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Tags in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Tags.
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

    /*
     * Returns the associated statsDayses for given Tags id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated StatsDays instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<StatsDays> findAssociatedStatsDayses(Integer id, Pageable pageable);

}

