/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package com.mifospay.core.model.entity.client

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    @SerializedName("code")
    var code: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("decimalPlaces")
    var decimalPlaces: Int? = null,

    @SerializedName("displaySymbol")
    var displaySymbol: String? = null,

    @SerializedName("nameCode")
    var nameCode: String? = null,

    @SerializedName("displayLabel")
    var displayLabel: String? = null,
) : Parcelable {
    constructor() : this(null, null, null, null, null, null)
}