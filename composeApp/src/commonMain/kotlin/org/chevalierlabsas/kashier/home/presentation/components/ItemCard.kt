package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    item: Item,
    onEdit: (item: Item) -> Unit,
    onAdd: (item: Item) -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Rp. ${item.price.toInt()}",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            IconButton(onClick = { onEdit(item) }) {
                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = "Edit Item"
                )
            }
            IconButton(onClick = { onAdd(item) }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Item"
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemCardPreview() {
    MaterialTheme {
        ItemCard(
            item = Item(
                id = 1,
                userId = 1,
                name = "Telur 0.5 KG",
                price = 12000.0
            ),
            onEdit = { },
            onAdd = { }
        )
    }
}