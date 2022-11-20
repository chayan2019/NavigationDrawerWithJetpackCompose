package com.withjetpack.navigationdrawerwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.withjetpack.navigationdrawerwithjetpackcompose.screen.CreateDrawer
import com.withjetpack.navigationdrawerwithjetpackcompose.ui.theme.NavigationDrawerWithJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerWithJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()
                    Scaffold(scaffoldState = scaffoldState, drawerContent = {
                        Row(
                            modifier = Modifier
                                .background(color = Color.Green)
                                .wrapContentSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.images),
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth(),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.padding(10.dp))
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(start = 4.dp),
                                text = "Chayan chowdhury"
                            )
                        }
                        Column() {
                            IconButton(onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }) {
                                Column() {
                                    repeat(10){
                                        Text(text = "data $it", modifier = Modifier.padding(10.dp))
                                    }
                                }
                            }
                        }
                    }, drawerGesturesEnabled = false) {
                        CreateDrawer(scaffoldState)
                    }
                }
            }
        }
    }
}
