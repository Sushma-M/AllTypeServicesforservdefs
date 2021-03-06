/*Copyright (c) 2016-2017 vcstest1.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest1.com*/
package com.testsoapshare.adventureworks2014;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TableName generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`table_name`")
public class TableName implements Serializable {

    private Integer column1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`column_1`", nullable = false, scale = 0, precision = 10)
    public Integer getColumn1() {
        return this.column1;
    }

    public void setColumn1(Integer column1) {
        this.column1 = column1;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableName)) return false;
        final TableName tableName = (TableName) o;
        return Objects.equals(getColumn1(), tableName.getColumn1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn1());
    }
}

