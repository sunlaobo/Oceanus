/**
 * Copyright 2011-2013 FoundationDB, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bj58.sql.parser;

import com.bj58.sql.StandardException;

public class AlterDropIndexNode extends TableElementNode
{
    private ExistenceCheck existenceCheck;

    @Override
    public void init(Object indexName,
                     Object ec)
    {
        super.init(indexName, ElementType.AT_DROP_INDEX);
        this.existenceCheck = (ExistenceCheck)ec;
    }

    public String getIndexName()
    {
        return name;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void copyFrom(QueryTreeNode node) throws StandardException 
    {
        super.copyFrom(node);

        AlterDropIndexNode other = (AlterDropIndexNode)node;
        this.existenceCheck = other.existenceCheck;
    }

    @Override
    public String toString()
    {
        return super.toString()
               + "\nexistenceCheck: " + existenceCheck;
    }

    public String statementToString()
    {
        return "ALTER TABLE DROP INDEX";
    }

    public ExistenceCheck getExistenceCheck()
    {
        return existenceCheck;
    }
}
