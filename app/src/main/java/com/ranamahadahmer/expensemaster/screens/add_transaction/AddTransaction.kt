package com.ranamahadahmer.expensemaster.screens.add_transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddTransaction() {
    val x = Brush.verticalGradient(colors = listOf(Color.Yellow.copy(alpha = 0.3f),
        Color.Cyan.copy(alpha = 0.06f),
        Color.Magenta.copy(green = 0.3f, alpha = 0.2f)), startY = 0.0f, endY = 2500f)


    val title = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val categoryExpanded = remember { mutableStateOf(false) }
    val categorySelected = remember { mutableStateOf("Category") }
    val typeExpanded = remember { mutableStateOf(false) }
    val typeSelected = remember { mutableStateOf("Type") }
    Scaffold(
        modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
        topBar = {
            Row(modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text("Add Transaction", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent,
                modifier = Modifier.height(60.dp)
            ) {
                Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
            }
        }

    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                    .fillMaxSize()
                    .background(x)
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp)) {
            NewTransactionInputField(
                text = "Amount",
                value = amount,
                onValueChange = { amount.value = (it.toIntOrNull() ?: "").toString() },
                keyboard = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(12.dp))
            NewTransactionInputField(
                text = "Title",
                value = title,
                onValueChange = { title.value = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {

                NewTransactionDropDown(modifier = Modifier
                        .weight(1.0f)
                        .clickable {
                            categoryExpanded.value = !categoryExpanded.value
                        },
                    options = listOf("Cash", "Online"),
                    itemSelected = categorySelected,
                    menuExpanded = categoryExpanded
                )
                Spacer(modifier = Modifier
                        .width(0.dp)
                        .weight(0.5f))


                NewTransactionDropDown(modifier = Modifier
                        .weight(1.0f)
                        .clickable {
                            typeExpanded.value = !typeExpanded.value
                        },
                    options = listOf("Expense", "Income"),
                    itemSelected = typeSelected,
                    menuExpanded = typeExpanded
                )
            }
        }
    }
}

@Composable
fun NewTransactionInputField(text: String,
                             value: MutableState<String>,
                             onValueChange: (String) -> Unit,
                             keyboard: KeyboardOptions = KeyboardOptions.Default) {
    OutlinedTextField(
        placeholder = { Text(text) },
        maxLines = 1,
        value = value.value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboard
    )
}

@Composable
fun NewTransactionDropDown(
    modifier: Modifier,
    options: List<String>,
    itemSelected: MutableState<String>,
    menuExpanded: MutableState<Boolean>
) {
    Box {
        Surface(shape = RoundedCornerShape(24), modifier = modifier) {
            Text(itemSelected.value,
                modifier = Modifier.padding(horizontal = 22.dp, vertical = 12.dp))
        }
        DropdownMenu(expanded = menuExpanded.value,
            onDismissRequest = { menuExpanded.value = false }) {
            DropdownMenuItem(text = { Text(options[0]) },
                onClick = {
                    menuExpanded.value = false
                    itemSelected.value = options[0]
                })
            DropdownMenuItem(text = { Text(options[1]) },
                onClick = {
                    menuExpanded.value = false
                    itemSelected.value = options[1]
                })
        }
    }
}

@Preview
@Composable
fun AddTransactionPreview() {
    AddTransaction()
}

//data class Transaction(val id: Int,
//                       val title: String,
//                       val amount: Double,
//                       val date: LocalDate,
//                       val category: String,
//                       val type: String)

//Transaction(1, "Salary", 25000.0, LocalDate.now(), "Online", "Income")