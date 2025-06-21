package com.hpcreation.bandhanmarry.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.hpcreation.bandhanmarry.R
import com.hpcreation.bandhanmarry.domain.model.ProfileItem
import com.hpcreation.bandhanmarry.domain.model.UserProfile
import com.hpcreation.bandhanmarry.presentation.ui.theme.BluePrimary
import com.hpcreation.bandhanmarry.presentation.ui.theme.OrangeSecondary

@Composable
fun ProfileCard(
    profile: UserProfile,
    modifier: Modifier = Modifier,
    onViewProfile: () -> Unit = {},
    onInterestClicked: () -> Unit = {},
    onIgnoreClicked: () -> Unit = {},
    onShortlistClicked: () -> Unit = {},
    onReportClicked: () -> Unit = {}
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFFBDBDBD))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(profile.imageUrl)
                        .diskCachePolicy(CachePolicy.ENABLED) // Ensures disk cache is used
                        .memoryCachePolicy(CachePolicy.ENABLED).build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(top = 5.dp, start = 5.dp, end = 5.dp)
                        .shadow(
                            5.dp, shape = RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 12.dp,
                                bottomEnd = 8.dp,
                                bottomStart = 8.dp
                            ), clip = true
                        )
                )
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorite",
                    tint = OrangeSecondary,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .size(28.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(4.dp)
                        .clickable(true) {
                            onShortlistClicked
                        })

                // Name + Member ID overlay
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(12.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(5.dp)
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
            Spacer(modifier = Modifier.height(12.dp))

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                profileItems.chunked(2).forEach { rowItems ->
                    if (rowItems.size == 1 || rowItems.any {
                            it.label.equals(
                                "Location", ignoreCase = true
                            )
                        }) {
                        // Single full-width item (long text)
                        rowItems.forEach { field ->
                            ProfileInfoRow(
                                icon = field.icon,
                                label = field.label,
                                value = field.value,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            )
                        }
                    } else {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            rowItems.forEach { field ->
                                ProfileInfoRow(
                                    icon = field.icon,
                                    label = field.label,
                                    value = field.value,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(vertical = 4.dp)
                                )
                            }
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlineButton(
                text = "View Profile",
                cornerRadius = 10.dp,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                onViewProfile()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionIconLabel(
                    R.drawable.interest, "Interest", tint = MaterialTheme.colorScheme.primary
                ) { onInterestClicked }
                ActionIconLabel(
                    R.drawable.ignore, "Ignore", tint = MaterialTheme.colorScheme.primary
                ) { onIgnoreClicked }
                ActionIconLabel(
                    R.drawable.report, "Report", tint = MaterialTheme.colorScheme.primary
                ) { onReportClicked }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun ActionIconLabel(
    icon: Int, label: String, tint: Color, onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .sizeIn(minWidth = 56.dp)
    ) {
        IconButton(onClick = onClick) {
            Icon(painter = painterResource(icon), contentDescription = label, tint = tint)
        }
        Text(label, fontSize = 12.sp)
    }
}

val profileItems = listOf(
    ProfileItem(R.drawable.age, "Age", "27 yrs"),
    ProfileItem(R.drawable.birthyear, "Birth Year", "1998"),
    ProfileItem(R.drawable.caste, "Caste", "Kadva Patel"),
    ProfileItem(R.drawable.ignore, "Unmarried", "Unmarried"),
    ProfileItem(R.drawable.height, "Height", "5'5\" (164 cm)"),
    ProfileItem(R.drawable.weight, "Weight", "70 KG"),
    ProfileItem(R.drawable.education, "Education", "IT Engineer"),
    ProfileItem(R.drawable.occupation, "Occupation", "Software Professional"),
    ProfileItem(R.drawable.visa, "Visa Status", "Not Specified"),
    ProfileItem(R.drawable.address, "Location", "Ahmedabad, Gujarat")
)

@Composable
fun ProfileInfoRow(icon: Int, label: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke((0.5).dp, MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 72.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = label,
                tint = BluePrimary,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 5.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = label,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = value,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.End,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
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