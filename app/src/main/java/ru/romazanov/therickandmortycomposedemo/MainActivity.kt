package ru.romazanov.therickandmortycomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Navigation
import ru.romazanov.therickandmortycomposedemo.ui.theme.TheRickAndMortyComposeDemoTheme

class MainActivity : ComponentActivity() {



    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheRickAndMortyComposeDemoTheme {
                val navHostController = rememberNavController()
                Navigation(navHostController = navHostController, viewModel)
            }
        }
    }
}

