package com.hpcreation.bandhanmarry.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.hpcreation.bandhanmarry.domain.model.UserProfile

@Composable
fun ProfileCard(
    profile: UserProfile, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.scrim)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Image top half
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(profile.imageUrl),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red.copy(alpha = 0.3f)),
                    contentScale = ContentScale.Crop
                )

                // Name + Member ID overlay
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(12.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    HeadlineText(
                        text = profile.name,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    TitleText(
                        text = "Member ID: ${profile.memberId}",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            // Details
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                ProfileInfoRow(label = "Age", value = "${profile.age} Years")
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Birth Year", value = profile.birthYear.toString())
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Cast", value = profile.cast)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Marital Status", value = profile.maritalStatus)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Height", value = profile.height)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Weight", value = profile.weight)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Education", value = profile.education)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Occupation", value = profile.occupation)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Location", value = profile.location)
                Spacer(modifier = Modifier.height(5.dp))
                ProfileInfoRow(label = "Visa Status", value = profile.visaStatus)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TitleText(
            text = "$label : ", fontWeight = FontWeight.SemiBold, fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier
                .width(5.dp)
        )
        DescriptionText(
            text = value,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileCardPreview() {
    ProfileCard(
        profile = UserProfile(
            id = "1",
            memberId = "BM99092",
            name = "Khushi Joshi",
            age = 24,
            birthYear = 2001,
            cast = "Brahmin - Audichya",
            maritalStatus = "Unmarried",
            height = "5ft 1in - 154.00 cm",
            weight = "40.00kg",
            education = "BE - IT",
            occupation = "Software Professional",
            location = "Ahmedabad, GUJARAT, India",
            visaStatus = "No Specified",
            imageUrl = "https://thumbs.dreamstime.com/b/vector-illustration-avatar-dummy-logo-collection-image-icon-stock-isolated-object-set-symbol-web-137160339.jpg"
        )
    )
}