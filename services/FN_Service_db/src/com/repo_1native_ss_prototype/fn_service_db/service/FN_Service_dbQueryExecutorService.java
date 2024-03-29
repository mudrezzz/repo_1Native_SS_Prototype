/*Copyright (c) 2017-2018 auditorius.ru All Rights Reserved.
 This software is the confidential and proprietary information of auditorius.ru You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with auditorius.ru*/

package com.repo_1native_ss_prototype.fn_service_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.repo_1native_ss_prototype.fn_service_db.models.query.*;

public interface FN_Service_dbQueryExecutorService {

    Page<StatsByDaysResponse> executeStats_by_days(Integer period, Pageable pageable);

    Downloadable exportStats_by_days(ExportType exportType, Integer period, Pageable pageable);

}


