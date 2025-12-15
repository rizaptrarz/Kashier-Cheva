package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectedItemChip(
    modifier: Modifier = Modifier,
    onRemove: () -> Unit,
    text: String = ""
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row {
            Text(text = text, style = MaterialTheme.typography.bodyLarge)
            IconButton(
                onClick = { onRemove() },
                content = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = text
                    )
                }
            )
        }
    }
}