/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifospay.feature.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.mifospay.core.designsystem.theme.MifosBlue

@Composable
fun ProfileDetailsCard(name : String, email : String, vpa : String, mobile : String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            ProfileItem(label = stringResource(id = R.string.feature_profile_username), value = name,)
            Spacer(modifier = Modifier.height(10.dp))
            ProfileItem(label = stringResource(id = R.string.feature_profile_email), value = email)
            Spacer(modifier = Modifier.height(10.dp))
            ProfileItem(label = stringResource(id = R.string.feature_profile_vpa), value = vpa)
            Spacer(modifier = Modifier.height(10.dp))
            ProfileItem(label = stringResource(id = R.string.feature_profile_mobile), value = mobile)
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = label, color = MifosBlue,)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = value, color = MaterialTheme.colorScheme.onSurface)
        Spacer(modifier = Modifier.height(4.dp))
        HorizontalDivider(thickness = 0.2.dp)
    }
}



