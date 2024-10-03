/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.core.data.domain.usecase.account

import android.util.Log
import com.mifospay.core.model.domain.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.mifospay.core.data.base.UseCase
import org.mifospay.core.data.fineract.entity.mapper.TransactionMapper
import org.mifospay.core.data.fineract.repository.FineractRepository
import org.mifospay.core.data.util.Constants

class FetchAccountTransactions(
    private val fineractRepository: FineractRepository,
    private val transactionMapper: TransactionMapper,
) : UseCase<FetchAccountTransactions.RequestValues, FetchAccountTransactions.ResponseValue?>() {

    override fun executeUseCase(requestValues: RequestValues) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val api = fineractRepository.getSelfAccountTransactions(requestValues.accountId)
                withContext(Dispatchers.Main) {
                    Log.d("FetchTransactions@@@@", "$api")
                    useCaseCallback.onSuccess(
                        ResponseValue(
                            transactionMapper.transformTransactionList(api),
                        ),
                    )
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("FetchTransactions@@@@", "${e.message}")
                    useCaseCallback.onError(
                        Constants.ERROR_FETCHING_REMOTE_ACCOUNT_TRANSACTIONS,
                    )
                }
            }
        }
    }

    data class RequestValues(var accountId: Long) : UseCase.RequestValues
    data class ResponseValue(val transactions: List<Transaction>) : UseCase.ResponseValue
}