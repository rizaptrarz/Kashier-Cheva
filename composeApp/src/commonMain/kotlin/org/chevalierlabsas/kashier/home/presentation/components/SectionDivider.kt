package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun SectionDivider(
    title: String,
    isContentVisible: Boolean,
    onToggleVisibility: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onToggleVisibility)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Icon(
            imageVector = if (isContentVisible) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
            contentDescription = "Toggle Visibility for $title",
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
private fun SectionDividerPreviewVisible() {
    MaterialTheme {
        SectionDivider(
            title = "Semua barang",
            isContentVisible = true,
            onToggleVisibility = {}
        )
    }
}

@Preview
@Composable
private fun SectionDividerPreviewHidden() {
    MaterialTheme {
        SectionDivider(
            title = "Semua barang",
            isContentVisible = false,
            onToggleVisibility = {}
        )
    }
}