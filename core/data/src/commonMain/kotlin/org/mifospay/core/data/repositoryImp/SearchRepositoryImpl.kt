/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.core.data.repositoryImp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.mifospay.core.common.Result
import org.mifospay.core.common.asResult
import org.mifospay.core.data.repository.SearchRepository
import org.mifospay.core.model.entity.SearchedEntity
import org.mifospay.core.network.FineractApiManager

class SearchRepositoryImpl(
    private val apiManager: FineractApiManager,
    private val ioDispatcher: CoroutineDispatcher,
) : SearchRepository {
    override suspend fun searchResources(
        query: String,
        resources: String,
        exactMatch: Boolean,
    ): Flow<Result<List<SearchedEntity>>> {
        return apiManager.searchApi
            .searchResources(query, resources, exactMatch)
            .asResult().flowOn(ioDispatcher)
    }
}