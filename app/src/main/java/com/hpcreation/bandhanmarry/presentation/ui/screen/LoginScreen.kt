package com.hpcreation.bandhanmarry.presentation.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hpcreation.bandhanmarry.R
import com.hpcreation.bandhanmarry.presentation.navigation.Routes
import com.hpcreation.bandhanmarry.presentation.ui.components.DescriptionText
import com.hpcreation.bandhanmarry.presentation.ui.components.HeadlineText
import com.hpcreation.bandhanmarry.presentation.ui.components.OutlineButton
import com.hpcreation.bandhanmarry.presentation.ui.components.OutlinePasswordTextbox
import com.hpcreation.bandhanmarry.presentation.ui.components.OutlinedTextBox
import com.hpcreation.bandhanmarry.presentation.ui.components.RoundedButton
import com.hpcreation.bandhanmarry.presentation.ui.components.SmallClickableText
import com.hpcreation.bandhanmarry.presentation.ui.components.TitleText
import com.hpcreation.bandhanmarry.presentation.ui.theme.BluePrimary
import com.hpcreation.bandhanmarry.presentation.ui.theme.OrangeSecondary
import com.hpcreation.bandhanmarry.presentation.ui.theme.PaleBlue
import com.hpcreation.bandhanmarry.presentation.ui.theme.SoftPink
import com.hpcreation.bandhanmarry.presentation.viewmodel.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = koinViewModel()) {

    val context = LocalContext.current
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val usernameError by viewModel.usernameError.collectAsState()
    val passwordError by viewModel.passwordError.collectAsState()

    var rememberMe by rememberSaveable { mutableStateOf(false) }
    var showForgotPasswordDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(SoftPink, SoftPink, PaleBlue, PaleBlue)
                )
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(R.drawable.app_logo),
                contentDescription = stringResource(R.string.app_logo),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, OrangeSecondary, CircleShape)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, BluePrimary)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeadlineText(
                        text = stringResource(R.string.login_to_account),
                        style = MaterialTheme.typography.displayLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    DescriptionText(text = stringResource(R.string.login_description))

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextBox(
                        value = username,
                        onValueChange = viewModel::onUsernameChanged,
                        label = stringResource(R.string.username),
                        maxLines = 1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                        isError = usernameError != null,
                        helperText = usernameError
                    )


                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinePasswordTextbox(
                        value = password,
                        onValueChange = viewModel::onPasswordChanged,
                        label = stringResource(R.string.password),
                        singleLine = true,
                        maxLines = 1,
                        isError = passwordError != null,
                        helperText = passwordError,
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it },
                            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF03506F))
                        )
                        TitleText(text = stringResource(R.string.remember_me))

                        Spacer(modifier = Modifier.weight(1f))

                        SmallClickableText(
                            text = stringResource(R.string.forgot_password), underline = true
                        ) {
                            showForgotPasswordDialog = true
                        }
                    }
                    if (showForgotPasswordDialog) {
                        AlertDialog(
                            icon = {
                            Image(
                                painter = painterResource(R.drawable.app_logo),
                                contentDescription = stringResource(R.string.app_logo),
                                modifier = Modifier.size(48.dp)
                            )
                        },
                            onDismissRequest = { showForgotPasswordDialog = false },
                            title = { TitleText(text = "Forgot Password!", fontSize = 20.sp) },
                            text = {
                                DescriptionText(
                                    text = "Please contact our team to reset your password.",
                                    textAlign = TextAlign.Start
                                )
                            },
                            confirmButton = {
                                OutlineButton(text = "OK") {
                                    showForgotPasswordDialog = false
                                }
                            })
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    RoundedButton(text = stringResource(R.string.login), onClick = {
                        viewModel.login()
                        if (viewModel.loginError.value != null) {
                            Toast.makeText(context, viewModel.loginError.value, Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            navController.navigate(Routes.Home.route) {
                                popUpTo(Routes.Login.route) { inclusive = true }
                            }
                        }
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                TitleText(text = stringResource(R.string.dont_have_account))
                Spacer(modifier = Modifier.width(5.dp))
                SmallClickableText(
                    text = stringResource(R.string.signup)
                ) {
                    navController.navigate(Routes.Register.route)
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}