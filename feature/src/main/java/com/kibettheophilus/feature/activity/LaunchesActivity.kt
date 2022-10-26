package com.kibettheophilus.feature.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kibettheophilus.feature.ui.theme.GraphQlDemoTheme
import com.kibettheophilus.feature.viewmodel.LaunchListViewModel
import com.kibettheophilus.feature.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchesActivity : ComponentActivity() {
    private val viewModel: LaunchListViewModel by viewModel()
    private val loginviewModel: LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    Log.d("DATAGRQU", "${viewModel.launchList.value}")
                    Log.d("DATAGRQU", "${loginviewModel.token.value}")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GraphQlDemoTheme {
        Greeting("Android")
    }
}