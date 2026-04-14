package com.benjamin.sokohub.ui.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.benjamin.sokohub.navigation.ROUT_HOME
import com.benjamin.sokohub.navigation.ROUT_INTENT
import com.benjamin.sokohub.navigation.ROUT_LOGIN
import com.benjamin.sokohub.ui.theme.OLdNavy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {



            CenterAlignedTopAppBar(
                title = { Text("Business Cards") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Gray)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Gray
                )
            )
        },
        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = OLdNavy
            ){
                var selectedIndex: Int? = null
                NavigationBarItem(icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                            tint = Color.Black
                        )
                    }, label = { Text("Home") }, selected = selectedIndex == 0, onClick = {
                        var selectedIndex = 0
                    navController.navigate(ROUT_HOME)
                    })
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites",tint = Color.Black) },
                    label = { Text("Intent") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_INTENT)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile",tint = Color.Black) },
                    label = { Text("Login") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_LOGIN)
                    }
                )



            }
        },
        content = { paddingValues ->
            // Use LazyColumn so you can scroll if you add more cards
            androidx.compose.foundation.lazy.LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    BusinessCard(
                        name = "John Smith",
                        job = "Business Consultant",
                        phone = "+1 356 3255 3654",
                        email = "johnsmith@mail.com",
                        bgColor = Color(0xFF2196F3)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    BusinessCard(
                        name = "Amanda Black",
                        job = "Dentist",
                        phone = "+1 356 3255 3654",
                        email = "amandablack@mail.com",
                        bgColor = Color(0xFFEF5350)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    BusinessCard(
                        name = "David Hill",
                        job = "Designer",
                        phone = "+1 356 3255 3054",
                        email = "davidhill@mail.com",
                        bgColor = Color(0xFFFFA726)
                    )
                }
            }
        }
    )
}

@Composable
fun BusinessCard(name: String, job: String, phone: String, email: String, bgColor: Color) {
    androidx.compose.material3.Card(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            androidx.compose.foundation.layout.Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = name, color = Color.White, fontSize = 22.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text(text = job, color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                }
                androidx.compose.foundation.layout.Row {
                    Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White.copy(alpha = 0.7f), modifier = Modifier.padding(end = 8.dp))
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = Color.White.copy(alpha = 0.7f))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.foundation.layout.Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Color.White, modifier = Modifier.padding(end = 8.dp))
                Text(text = phone, color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            androidx.compose.foundation.layout.Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White, modifier = Modifier.padding(end = 8.dp))
                Text(text = email, color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}