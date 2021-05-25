package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import com.example.myapplication.model.Travel
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.*

class MainActivity : ComponentActivity() {
    val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NewStory()
                }
            }
        }
    }

    @Composable
    fun NewStory() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Places") },
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { Log.e("TAG", "NewStory: HI") },
                    backgroundColor = Color.Blue
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                locations.forEach { i ->
                    ItemView(context = context, item = i)
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewNewStory() {
        NewStory()
    }
}

val locations = mutableListOf<Travel>(
    Travel(
        "California, United states",
        "Good day to take pictures"
    ),
    Travel(
        "Cairo, Egypt",
        "Sunny day in the park"
    ),
    Travel(
        "Paris, France",
        "Rainy"
    ),
    Travel(
        "London, United Kingdom",
        "Good day to running"
    ),
)

