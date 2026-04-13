package com.benjamin.sokohub.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.benjamin.sokohub.R
import com.benjamin.sokohub.navigation.ROUT_ONBOARDING
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){


    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        delay(2000)
        navController.navigate(ROUT_ONBOARDING)



    }
    Column(
        Modifier
            .background(color = Color.Black)
            .fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(R.drawable.sokohub),
            contentDescription = "img",
            modifier = Modifier.size(300.dp))


    }


}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}