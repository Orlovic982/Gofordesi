package com.orlandus.gofordesicompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.orlandus.gofordesicompose.ui.theme.GoForDesiComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.tabs.observe(this) { tabs ->
            Toast.makeText(this,"Uspeli smo da prebacimo listu tabova",Toast.LENGTH_SHORT).show()
            tabs?.forEach {
                    tab ->

                Log.d("Milan","\n"+tab.pattern+"\n"+tab.title+"\n"+tab.visit+"\n"+"-------------------------------")

            }
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isloading.value
            }


        }

        setContent {
                Text(text = "Milan")
            }
        }




}


