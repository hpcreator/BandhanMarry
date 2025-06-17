package com.hpcreation.bandhanmarry.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.hpcreation.bandhanmarry.domain.model.UserProfile

@Composable
fun ProfileCard(
    profile: UserProfile,
    modifier: Modifier = Modifier,
    onViewProfile: () -> Unit = {},
    onInterest: () -> Unit = {},
    onIgnore: () -> Unit = {},
    onShortlist: () -> Unit = {},
    onReport: () -> Unit = {}
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFBDBDBD))
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Image top half
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                /*Image(
                    painter = rememberAsyncImagePainter(profile.imageUrl),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red.copy(alpha = 0.3f)),
                    contentScale = ContentScale.Crop
                )*/
                AsyncImage(
                    model = ImageRequest.Builder(context).data(profile.imageUrl)
                        .diskCachePolicy(CachePolicy.ENABLED) // Ensures disk cache is used
                        .memoryCachePolicy(CachePolicy.ENABLED).build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 12.dp,
                                bottomEnd = 8.dp,
                                bottomStart = 8.dp
                            )
                        )
                )
                IconButton(
                    onClick = { onShortlist() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(18.dp)
                        .size(36.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.5f), shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Shortlist",
                        tint = Color(0xFFFFA000)
                    )
                }


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


                Button(
                    onClick = onViewProfile,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "View Full Profile",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(MaterialTheme.colorScheme.secondary.toArgb())
                )

                // Action Row
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ActionIconLabel(Icons.Filled.Favorite, "Interest", onInterest, Color.Red)
                    ActionIconLabel(Icons.Filled.Person, "Ignore", onIgnore, Color.Red)
                    ActionIconLabel(Icons.Filled.Info, "Report", onReport, Color.Gray)
                }
            }
        }
    }
}

@Composable
private fun ActionIconLabel(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
    tint: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .sizeIn(minWidth = 56.dp)
    ) {
        IconButton(onClick = onClick) {
            Icon(icon, contentDescription = label, tint = tint)
        }
        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TitleText(
            text = "$label : ", fontWeight = FontWeight.SemiBold, fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier.width(5.dp)
        )
        DescriptionText(
            text = value, color = MaterialTheme.colorScheme.primary
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