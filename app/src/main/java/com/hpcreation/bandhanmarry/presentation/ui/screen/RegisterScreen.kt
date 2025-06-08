package com.hpcreation.bandhanmarry.presentation.ui.screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hpcreation.bandhanmarry.R
import com.hpcreation.bandhanmarry.presentation.navigation.Routes
import com.hpcreation.bandhanmarry.presentation.ui.theme.BluePrimary
import com.hpcreation.bandhanmarry.presentation.ui.theme.OrangeSecondary
import com.hpcreation.bandhanmarry.presentation.ui.theme.PaleBlue
import com.hpcreation.bandhanmarry.presentation.ui.theme.SoftPink

@Composable
fun RegisterScreen(navController: NavController) {
    var dob by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("India") }
    var phoneCode by remember { mutableStateOf("+91") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreedToPolicy by remember { mutableStateOf(false) }
    var receiveEmail by remember { mutableStateOf(false) }
    var receiveSMS by remember { mutableStateOf(false) }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(SoftPink, PaleBlue))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            // Logo
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "Create an account",
                style = MaterialTheme.typography.headlineMedium.copy(color = BluePrimary),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Please provide your valid informations to register!",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, BluePrimary)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(
                        value = dob,
                        onValueChange = { dob = it },
                        label = { Text("Date Of Birth (DD-MM-YYYY) *") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text("Username *") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 6.dp),
                            shape = RoundedCornerShape(8.dp)
                        )
                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = { Text("First Name *") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 6.dp),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = middleName,
                            onValueChange = { middleName = it },
                            label = { Text("Middle Name *") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 6.dp),
                            shape = RoundedCornerShape(8.dp)
                        )
                        OutlinedTextField(
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = { Text("Last Name *") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 6.dp),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("E-Mail Address *") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Country Row (Dropdown simulated with plain input)
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = country,
                            onValueChange = { country = it },
                            label = { Text("Country") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = phoneCode,
                        onValueChange = { phoneCode = it },
                        label = { Text("Phone Code") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password *") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val iconRes =
                                if (passwordVisible) R.drawable.ic_visible else R.drawable.ic_visible_off
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                                )
                            }
                        })

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password *") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val iconRes =
                                if (confirmPasswordVisible) R.drawable.ic_visible else R.drawable.ic_visible_off
                            IconButton(onClick = {
                                confirmPasswordVisible = !confirmPasswordVisible
                            }) {
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password"
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Checkboxes
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = agreedToPolicy,
                                onCheckedChange = { agreedToPolicy = it },
                                colors = CheckboxDefaults.colors(checkedColor = Color.Red)
                            )
                            Text(
                                text = "I agree with ", style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Privacy Policy, Terms and Conditions",
                                color = Color.Red,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = receiveEmail,
                                onCheckedChange = { receiveEmail = it },
                                colors = CheckboxDefaults.colors(checkedColor = BluePrimary)
                            )
                            Text("Receive email from Bandhanmarry.com")
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = receiveSMS,
                                onCheckedChange = { receiveSMS = it },
                                colors = CheckboxDefaults.colors(checkedColor = BluePrimary)
                            )
                            Text("Receive SMS from Bandhanmarry.com")
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            // Handle register logic
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
                    ) {
                        Text("Register")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Have an account? ")
                        Text(
                            text = "Login",
                            color = OrangeSecondary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable {
                                navController.navigate(Routes.Login.route)
                            })
                    }
                }
            }
        }
    }
}

