package com.ranamahadahmer.expensemaster.screens.add_transaction.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
                }
            )
        }
    }
}