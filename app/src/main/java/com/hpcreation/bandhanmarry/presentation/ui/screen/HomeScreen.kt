package com.hpcreation.bandhanmarry.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.hpcreation.bandhanmarry.R
import com.hpcreation.bandhanmarry.domain.model.UserProfile
import com.hpcreation.bandhanmarry.presentation.ui.components.HeadlineText
import com.hpcreation.bandhanmarry.presentation.ui.components.ProfileCard
import com.hpcreation.bandhanmarry.presentation.ui.theme.PaleBlue
import com.hpcreation.bandhanmarry.presentation.ui.theme.SoftPink
import com.hpcreation.bandhanmarry.presentation.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {
    val profiles by viewModel.profiles.collectAsState()
    HomeScreenContent(profiles = profiles)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    profiles: List<UserProfile>,
    onViewProfile: () -> Unit = {},
    onInterest: () -> Unit = {},
    onIgnore: () -> Unit = {},
    onShortlist: () -> Unit = {},
    onReport: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(SoftPink, SoftPink, PaleBlue, PaleBlue)
                    )
                ),
                title = {
                    HeadlineText(
                        stringResource(R.string.app_name),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
            )
        }) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(contentPadding = innerPadding) {
                items(profiles) { profile ->
                    ProfileCard(
                        profile,
                        onViewProfile = onViewProfile,
                        onInterest = onInterest,
                        onIgnore = onIgnore,
                        onShortlist = onShortlist,
                        onReport = onReport
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreenContent(
        profiles = listOf(
            UserProfile(
                id = "1",
                memberId = "BM00001",
                name = "Harsh Joginbhai Patel",
                age = 27,
                birthYear = 1998,
                cast = "Kadva Patel",
                maritalStatus = "Unmarried",
                height = "5ft 5in - 164.00 cm",
                weight = "70.00kg",
                education = "BE - IT",
                occupation = "Software Professional",
                location = "Ahmedabad, GUJARAT, India",
                visaStatus = "No Specified",
                imageUrl = "https://lh3.googleusercontent.com/a/ACg8ocJ9l-pYf5P7S7ZqlekgI6HOt1gnKsXQOyatATJx9oc1vmezEQN0=s720-c-no"
            )
        )
    )
}