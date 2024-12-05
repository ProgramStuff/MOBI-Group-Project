package com.example.jobscout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.jobscout.pages.HomeScreen


@Composable
fun WelcomeScreen(modifier: Modifier= Modifier){
//    The bottom nav bar items and icons
    val navItemList = listOf(
        NavItem(name = "Home", Icons.Default.Home),
    )
//    Selected option for current page choice
    var selectedOption by remember { mutableStateOf(value = 0)}
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar={
            // Nav bar containing the text and icons
            // Updates the selectedOption from index
            NavigationBar {
                navItemList.forEachIndexed{index, navItem ->
                    NavigationBarItem(selected = selectedOption==index,
                        onClick = {selectedOption = index},
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label ={
                            Text(text = navItem.name)
                        }
                    )
                }
            }
        }
    ){innerPadding ->
        DesignScreen(modifier = Modifier.padding(innerPadding), selectedOption)
    }
}

@Composable
fun DesignScreen(modifier: Modifier, selectedOption: Int) {
    when(selectedOption){
        // When selectedOption is changed change the activity
        0-> HomeScreen()
    }
}
