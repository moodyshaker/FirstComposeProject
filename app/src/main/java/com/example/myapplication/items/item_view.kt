package com.example.myapplication

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Travel

import java.text.SimpleDateFormat
import java.util.*


@Composable
fun ItemView(context: Context, item: Travel) {
    val dateFormat = SimpleDateFormat("yyyy MMM dd")
    MaterialTheme() {
        val typography = MaterialTheme.typography
        Card(
            modifier = Modifier.padding(12.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomEnd = 8.dp,
                bottomStart = 8.dp
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        Toast
                            .makeText(context, item.place, Toast.LENGTH_SHORT)
                            .show()
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)) {
                    Text(
                        text = item.place,
                        style = typography.h6,
                    )
                    Text(
                        text = item.message,
                        style = typography.body2
                    )
                    Text(
                        text = dateFormat.format(Date()),
                        style = typography.body2
                    )
                }
            }
        }
    }
}