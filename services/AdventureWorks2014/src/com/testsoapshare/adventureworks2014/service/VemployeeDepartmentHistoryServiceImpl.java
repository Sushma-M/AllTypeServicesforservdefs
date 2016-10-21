/*Copyright (c) 2016-2017 vcstest1.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest1.com*/
package com.testsoapshare.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


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
import com.wavemaker.runtime.file.model.Downloadable;

import com.testsoapshare.adventureworks2014.VemployeeDepartmentHistory;
import com.testsoapshare.adventureworks2014.VemployeeDepartmentHistoryId;


/**
 * ServiceImpl object for domain model class VemployeeDepartmentHistory.
 *
 * @see VemployeeDepartmentHistory
 */
@Service("AdventureWorks2014.VemployeeDepartmentHistoryService")
public class VemployeeDepartmentHistoryServiceImpl implements VemployeeDepartmentHistoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VemployeeDepartmentHistoryServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.VemployeeDepartmentHistoryDao")
    private WMGenericDao<VemployeeDepartmentHistory, VemployeeDepartmentHistoryId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VemployeeDepartmentHistory, VemployeeDepartmentHistoryId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartmentHistory getById(VemployeeDepartmentHistoryId vemployeedepartmenthistoryId) throws EntityNotFoundException {
        LOGGER.debug("Finding VemployeeDepartmentHistory by id: {}", vemployeedepartmenthistoryId);
        VemployeeDepartmentHistory vemployeeDepartmentHistory = this.wmGenericDao.findById(vemployeedepartmenthistoryId);
        if (vemployeeDepartmentHistory == null){
            LOGGER.debug("No VemployeeDepartmentHistory found with id: {}", vemployeedepartmenthistoryId);
            throw new EntityNotFoundException(String.valueOf(vemployeedepartmenthistoryId));
        }
        return vemployeeDepartmentHistory;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartmentHistory findById(VemployeeDepartmentHistoryId vemployeedepartmenthistoryId) {
        LOGGER.debug("Finding VemployeeDepartmentHistory by id: {}", vemployeedepartmenthistoryId);
        return this.wmGenericDao.findById(vemployeedepartmenthistoryId);
    }


	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<VemployeeDepartmentHistory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VemployeeDepartmentHistories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<VemployeeDepartmentHistory> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VemployeeDepartmentHistories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table VemployeeDepartmentHistory to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

