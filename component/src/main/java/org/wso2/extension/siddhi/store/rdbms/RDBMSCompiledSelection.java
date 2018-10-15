/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.extension.siddhi.store.rdbms;

import org.wso2.siddhi.core.util.collection.operator.CompiledSelection;

/**
 * Implementation class of {@link CompiledSelection} corresponding to the RDBMS Event Table.
 * Maintains the compiled select, group by, having etc. clauses.
 */
public class RDBMSCompiledSelection implements CompiledSelection {

    private RDBMSCompiledCondition compiledSelectClause;
    private RDBMSCompiledCondition compiledGroupByClause;
    private RDBMSCompiledCondition compiledHavingClause;
    private RDBMSCompiledCondition compiledOrderByClause;
    private Long limit;

    public RDBMSCompiledSelection (RDBMSCompiledCondition compiledSelectClause,
                                   RDBMSCompiledCondition compiledGroupByClause,
                                   RDBMSCompiledCondition compiledHavingClause,
                                   RDBMSCompiledCondition compiledOrderByClause, Long limit) {
        this.compiledSelectClause = compiledSelectClause;
        this.compiledGroupByClause = compiledGroupByClause;
        this.compiledHavingClause = compiledHavingClause;
        this.compiledOrderByClause = compiledOrderByClause;
        this.limit = limit;
    }

    @Override
    public CompiledSelection cloneCompilation(String s) {
        return new RDBMSCompiledSelection(compiledSelectClause, compiledGroupByClause, compiledHavingClause,
                compiledOrderByClause, limit);
    }

    public RDBMSCompiledCondition getCompiledSelectClause() {
        return compiledSelectClause;
    }

    public RDBMSCompiledCondition getCompiledGroupByClause() {
        return compiledGroupByClause;
    }

    public RDBMSCompiledCondition getCompiledHavingClause() {
        return compiledHavingClause;
    }

    public RDBMSCompiledCondition getCompiledOrderByClause() {
        return compiledOrderByClause;
    }

    public Long getLimit() {
        return limit;
    }
}


