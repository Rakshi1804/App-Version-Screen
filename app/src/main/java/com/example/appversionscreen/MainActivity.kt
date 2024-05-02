package com.example.appversionscreen

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appversionscreen.ui.theme.AppVersionScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppVersionScreenTheme {
                Content()
            }
        }
    }
}


@Composable
fun Content() {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopRow()
        if (isPortrait) {
            Spacer(modifier = Modifier.height(30.dp))
            PortraitContent()
        } else {
            Spacer(modifier = Modifier.height(30.dp))
            LandscapeContent()
        }
    }
}

@Composable
fun PortraitContent() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        RemainingContent()
    }
}

@Composable
fun LandscapeContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        landscapeContent()
        Spacer(modifier = Modifier.weight(1f))
    }
}



@Composable
fun TopRow(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.backarrow),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = 17.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun RemainingContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.cloudname),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )

        Text(
            text = stringResource(id = R.string.version),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(150.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.asset_logo_about),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
        }

        Spacer(modifier = Modifier.height(140.dp))

        Text(
            text = "© 2013-2024 Synchronoss Technologies",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.W400,
            ),
            modifier = Modifier.padding(top = 15.dp, bottom = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun landscapeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.cloudname),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )

            Text(
                text = stringResource(id = R.string.version),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(bottom = 78.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.asset_logo_about),
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .aspectRatio(1f)
            )

        }

        Text(
            text = "© 2013-2024 Synchronoss Technologies",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.W400,
            ),
            modifier = Modifier.padding(top = 25.dp, bottom = 25.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun TopTextPreview() {
    Content()
}
