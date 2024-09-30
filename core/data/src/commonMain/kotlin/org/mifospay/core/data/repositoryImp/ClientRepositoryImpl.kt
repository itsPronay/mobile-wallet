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
import kotlinx.coroutines.flow.map
import org.mifospay.core.common.Result
import org.mifospay.core.common.asResult
import org.mifospay.core.data.mapper.toModel
import org.mifospay.core.data.repository.ClientRepository
import org.mifospay.core.model.domain.client.Client
import org.mifospay.core.model.domain.client.NewClient
import org.mifospay.core.model.entity.Page
import org.mifospay.core.model.entity.client.ClientAccounts
import org.mifospay.core.network.FineractApiManager

class ClientRepositoryImpl(
    private val apiManager: FineractApiManager,
    private val ioDispatcher: CoroutineDispatcher,
) : ClientRepository {
    override suspend fun getClients(): Flow<Result<Page<Client>>> {
        return apiManager.clientsApi.clients().map { it.toModel() }.asResult().flowOn(ioDispatcher)
    }

    override suspend fun getClient(clientId: Long): Flow<Result<Client>> {
        return apiManager.clientsApi
            .getClientForId(clientId)
            .map { it.toModel() }
            .asResult().flowOn(ioDispatcher)
    }

    override suspend fun updateClient(clientId: Long, client: Client): Flow<Result<Unit>> {
        return apiManager.clientsApi
            .updateClient(clientId, client)
            .asResult().flowOn(ioDispatcher)
    }

    override suspend fun getClientImage(clientId: Long): Flow<Result<String>> {
        return apiManager.clientsApi.getClientImage(clientId).asResult().flowOn(ioDispatcher)
    }

    override suspend fun updateClientImage(clientId: Long, image: String): Flow<Result<Unit>> {
        return apiManager.clientsApi
            .updateClientImage(clientId, image)
            .asResult().flowOn(ioDispatcher)
    }

    override suspend fun getClientAccounts(clientId: Long): Flow<Result<ClientAccounts>> {
        return apiManager.clientsApi
            .getClientAccounts(clientId)
            .asResult().flowOn(ioDispatcher)
    }

    override suspend fun getAccounts(
        clientId: Long,
        accountType: String,
    ): Flow<Result<ClientAccounts>> {
        return apiManager.clientsApi
            .getAccounts(clientId, accountType)
            .asResult().flowOn(ioDispatcher)
    }

    override suspend fun createClient(newClient: NewClient): Flow<Result<Client>> {
        return apiManager.clientsApi
            .createClient(newClient)
            .map { it.toModel() }
            .asResult().flowOn(ioDispatcher)
    }
}