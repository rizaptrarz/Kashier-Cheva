package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ItemCard(
    item: Item,
    onAddClick: (Item) -> Unit,
    onEditClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Rp. ${item.price}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        IconButton(
            onClick = { onEditClick(item) }
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Item",
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = { onAddClick(item) },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary, MaterialTheme.shapes.small)
                .size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Item",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Preview
@Composable
private fun ItemCardPreview() {
    val dummyItem = org.chevalierlabsas.kashier.home.domain.Item(
        id = 1,
        userId = 101,
        name = "Telur 0.5 KG",
        price = 12000.00
    )
    MaterialTheme {
        ItemCard(
            item = dummyItem,
            onAddClick = {  },
            onEditClick = {  }
        )
    }
}