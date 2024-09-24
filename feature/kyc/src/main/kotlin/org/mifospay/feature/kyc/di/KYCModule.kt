/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.feature.kyc.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.mifospay.feature.kyc.KYCDescriptionViewModel
import org.mifospay.feature.kyc.KYCLevel1ViewModel
import org.mifospay.feature.kyc.KYCLevel2ViewModel
import org.mifospay.feature.kyc.KYCLevel3ViewModel

val KYCModule = module {
    viewModel {
        KYCDescriptionViewModel(
            mUseCaseHandler = get(),
            mLocalRepository = get(),
            fetchKYCLevel1DetailsUseCase = get(),
        )
    }

    viewModel {
        KYCLevel1ViewModel(
            mUseCaseHandler = get(),
            mLocalRepository = get(),
            uploadKYCLevel1DetailsUseCase = get(),
        )
    }

    viewModel {
        KYCLevel2ViewModel(
            mUseCaseHandler = get(),
            preferencesHelper = get(),
            uploadKYCDocsUseCase = get(),
        )
    }

    viewModel {
        KYCLevel3ViewModel(
            mUseCaseHandler = get(),
            mLocalRepository = get(),
        )
    }
}
