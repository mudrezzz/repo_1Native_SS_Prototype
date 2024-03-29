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

import com.repo_1native_ss_prototype.fn_service_db.AdvPaymentHistory;
import com.repo_1native_ss_prototype.fn_service_db.Advertiser;
import com.repo_1native_ss_prototype.fn_service_db.Campaign;
import com.repo_1native_ss_prototype.fn_service_db.PubPaymentHistory;
import com.repo_1native_ss_prototype.fn_service_db.Publisher;
import com.repo_1native_ss_prototype.fn_service_db.Sites;
import com.repo_1native_ss_prototype.fn_service_db.Tags;
import com.repo_1native_ss_prototype.fn_service_db.Users;

/**
 * Service object for domain model class {@link Publisher}.
 */
public interface PublisherService {

    /**
     * Creates a new Publisher. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Publisher if any.
     *
     * @param publisher Details of the Publisher to be created; value cannot be null.
     * @return The newly created Publisher.
     */
	Publisher create(Publisher publisher);


	/**
	 * Returns Publisher by given id if exists.
	 *
	 * @param publisherId The id of the Publisher to get; value cannot be null.
	 * @return Publisher associated with the given publisherId.
     * @throws EntityNotFoundException If no Publisher is found.
	 */
	Publisher getById(Integer publisherId) throws EntityNotFoundException;

    /**
	 * Find and return the Publisher by given id if exists, returns null otherwise.
	 *
	 * @param publisherId The id of the Publisher to get; value cannot be null.
	 * @return Publisher associated with the given publisherId.
	 */
	Publisher findById(Integer publisherId);


	/**
	 * Updates the details of an existing Publisher. It replaces all fields of the existing Publisher with the given publisher.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Publisher if any.
     *
	 * @param publisher The details of the Publisher to be updated; value cannot be null.
	 * @return The updated Publisher.
	 * @throws EntityNotFoundException if no Publisher is found with given input.
	 */
	Publisher update(Publisher publisher) throws EntityNotFoundException;

    /**
	 * Deletes an existing Publisher with the given id.
	 *
	 * @param publisherId The id of the Publisher to be deleted; value cannot be null.
	 * @return The deleted Publisher.
	 * @throws EntityNotFoundException if no Publisher found with the given id.
	 */
	Publisher delete(Integer publisherId) throws EntityNotFoundException;

	/**
	 * Find all Publishers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Publishers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Publisher> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Publishers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Publishers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Publisher> findAll(String query, Pageable pageable);

    /**
	 * Exports all Publishers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Publishers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Publisher.
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
     * Returns the associated advertisers for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Advertiser instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Advertiser> findAssociatedAdvertisers(Integer id, Pageable pageable);

    /*
     * Returns the associated advPaymentHistories for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AdvPaymentHistory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AdvPaymentHistory> findAssociatedAdvPaymentHistories(Integer id, Pageable pageable);

    /*
     * Returns the associated campaigns for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Campaign instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Campaign> findAssociatedCampaigns(Integer id, Pageable pageable);

    /*
     * Returns the associated pubPaymentHistories for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PubPaymentHistory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PubPaymentHistory> findAssociatedPubPaymentHistories(Integer id, Pageable pageable);

    /*
     * Returns the associated siteses for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Sites instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Sites> findAssociatedSiteses(Integer id, Pageable pageable);

    /*
     * Returns the associated tagses for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Tags instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Tags> findAssociatedTagses(Integer id, Pageable pageable);

    /*
     * Returns the associated userses for given Publisher id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Users instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Users> findAssociatedUserses(Integer id, Pageable pageable);

}

