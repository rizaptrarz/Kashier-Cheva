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

// Hilangkan 'class ItemCard {}' yang kosong, ganti dengan fungsi Composable

@Composable
fun ItemCard(
    item: Item,
    onAddClick: (Item) -> Unit, // Lambda untuk aksi tambah (+)
    onEditClick: (Item) -> Unit, // Lambda untuk aksi edit (pensil)
    modifier: Modifier = Modifier
) {
    // Row sebagai container, menggunakan warna secondaryContainer
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Kolom untuk Nama dan Harga
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Nama Barang
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Harga Barang
            Text(
                // Catatan: Format harga harus disesuaikan untuk tampilan mata uang yang benar
                text = "Rp. ${item.price}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        // --- Tombol Edit ---
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

        // --- Tombol Tambah ---
        IconButton(
            onClick = { onAddClick(item) },
            // Menggunakan warna sekunder untuk latar belakang tombol
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary, MaterialTheme.shapes.small)
                .size(32.dp) // Ukuran tombol kecil
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Item",
                tint = MaterialTheme.colorScheme.onSecondary // Warna ikon di atas warna secondary
            )
        }
    }
}

// Tambahkan Preview untuk melihat hasilnya
@Preview
@Composable
private fun ItemCardPreview() {
    val dummyItem = org.chevalierlabsas.kashier.home.domain.Item( // Gunakan Item dengan Package Penuh
        id = 1,
        userId = 101,
        name = "Telur 0.5 KG",
        price = 12000.00
    )
    MaterialTheme {
        ItemCard(
            item = dummyItem,
            onAddClick = { /* Do nothing */ },
            onEditClick = { /* Do nothing */ }
        )
    }
}