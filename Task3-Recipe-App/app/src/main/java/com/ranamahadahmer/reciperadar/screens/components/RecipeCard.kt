package com.ranamahadahmer.reciperadar.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ranamahadahmer.reciperadar.data.Recipe

@Composable
fun RecipeCard(item: Recipe, show: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
                .padding(10.dp)
                .height(250.dp)
                .clickable { show() }

    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Image(
            painter = rememberAsyncImagePainter(model = item.image),
            contentDescription = "Image of Meal",
        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            item.title,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(thickness = 1.dp)
    }


}