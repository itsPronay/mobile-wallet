/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.feature.profile.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.mifospay.feature.profile.ProfileViewModel
import org.mifospay.feature.profile.edit.EditProfileViewModel

val ProfileModule = module {
    viewModel {
        ProfileViewModel(
            mUseCaseHandler = get(),
            fetchClientImageUseCase = get(),
            localRepository = get(),
            mPreferencesHelper = get(),
        )
    }

    viewModel {
        EditProfileViewModel(
            mUseCaseHandler = get(),
            mPreferencesHelper = get(),
            updateUserUseCase = get(),
            updateClientUseCase = get(),
        )
    }
}
