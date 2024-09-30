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

import io.ktor.http.content.PartData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.mifospay.core.common.Result
import org.mifospay.core.common.asResult
import org.mifospay.core.data.repository.DocumentRepository
import org.mifospay.core.model.entity.noncore.Document
import org.mifospay.core.network.FineractApiManager

class DocumentRepositoryImpl(
    private val apiManager: FineractApiManager,
    private val ioDispatcher: CoroutineDispatcher,
) : DocumentRepository {
    override fun getDocuments(entityType: String, entityId: Int): Flow<Result<List<Document>>> {
        return apiManager.documentApi
            .getDocuments(entityType, entityId)
            .asResult().flowOn(ioDispatcher)
    }

    override fun createDocument(
        entityType: String,
        entityId: Int,
        name: String,
        description: String,
        fileName: PartData.FileItem,
    ): Flow<Result<Unit>> {
        return apiManager.documentApi
            .createDocument(entityType, entityId, name, description, fileName)
            .asResult().flowOn(ioDispatcher)
    }

    override fun downloadDocument(
        entityType: String,
        entityId: Int,
        documentId: Int,
    ): Flow<Result<Document>> {
        return apiManager.documentApi
            .downloadDocument(entityType, entityId, documentId)
            .asResult().flowOn(ioDispatcher)
    }

    override fun deleteDocument(
        entityType: String,
        entityId: Int,
        documentId: Int,
    ): Flow<Result<Unit>> {
        return apiManager.documentApi
            .removeDocument(entityType, entityId, documentId)
            .asResult().flowOn(ioDispatcher)
    }

    override fun updateDocument(
        entityType: String,
        entityId: Int,
        documentId: Int,
        name: String,
        description: String,
        fileName: PartData.FileItem,
    ): Flow<Result<Unit>> {
        return apiManager.documentApi
            .updateDocument(entityType, entityId, documentId, name, description, fileName)
            .asResult()
            .flowOn(ioDispatcher)
    }
}