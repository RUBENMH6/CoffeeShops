package com.example.coffeeshops

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeshops.ui.theme.FontCoffee
import com.example.coffeeshops.ui.theme.Pink80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeShop(navController: NavController, viewModel: CoffeeShopsViewModel) {
    val selectedEstablishment = viewModel.selectedEstablishment
    Column {
        TopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(Pink80),
            title = {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "CoffeeShops", color = Color.White, fontSize = 22.sp)
            },
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_menu_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            actions = {
                MyDropDownMenuForItem()
            }
        )
        Row() {
            Spacer(modifier = Modifier.weight(0.2f))
            Text(
                text = selectedEstablishment.toString(),
                fontFamily = FontCoffee,
                fontSize = 38.sp,
                color = Color.Black,
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.weight(0.2f))
        }



    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate("CoffeeShops")
            },
            shape = RoundedCornerShape(30.dp),
            containerColor = Pink80,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MyDropDownMenuForItem() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val items = listOf<String>("Compartir", "Guardar")
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Spacer(modifier = Modifier.weight(0.9f))
        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
    Row(
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach {
                DropdownMenuItem(
                    leadingIcon = {
                        if (it == "Compartir") {
                            Icon(painter = painterResource(R.drawable.baseline_share_24),
                                contentDescription = null,
                                tint = Color.Black)
                        } else {
                            Icon(painter = painterResource(id = R.drawable.baseline_save_24),
                                contentDescription = null,
                                tint = Color.Black)
                        }
                    },
                    text = { Text(text = it, color = Color.Black , fontSize = 16.sp)},
                    onClick = {
                        selectedText = it
                    }
                )
            }
        }

    }
}