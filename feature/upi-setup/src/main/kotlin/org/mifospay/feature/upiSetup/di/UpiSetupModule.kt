/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.feature.upiSetup.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.mifospay.feature.upiSetup.viewmodel.DebitCardViewModel
import org.mifospay.feature.upiSetup.viewmodel.SetUpUpiViewModal

val UpiSetupModule = module {

    viewModel {
        DebitCardViewModel()
    }

    viewModel {
        SetUpUpiViewModal()
    }
}
