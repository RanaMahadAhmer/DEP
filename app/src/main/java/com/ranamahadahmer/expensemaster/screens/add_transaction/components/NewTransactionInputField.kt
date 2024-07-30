package com.ranamahadahmer.expensemaster.screens.add_transaction.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

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