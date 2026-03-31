package com.benjamin.sokohub.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.benjamin.sokohub.R
@Composable
fun OnBoardingScreen(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.product),
            contentDescription = "product",
            modifier = Modifier.size(300.dp)

        )







    }



































}


@Preview(showBackground = true)
@Composable
fun OnBoardingPreview(){
    OnBoardingScreen()



}
