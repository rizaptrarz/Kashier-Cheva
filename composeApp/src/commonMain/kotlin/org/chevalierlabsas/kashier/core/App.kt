package org.chevalierlabsas.kashier.core

// Import Data Class dan Komponen Tugas
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.chevalierlabsas.kashier.home.presentation.components.ItemCard
import org.chevalierlabsas.kashier.home.presentation.components.SectionDivider
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        // State untuk mengontrol tampil/sembunyi konten
        var isListVisible by remember { mutableStateOf(true) }

        // Data Dummy untuk List Item
        val dummyItems = remember {
            listOf(
                Item(id = 1, userId = 1, name = "Telur 0.5 KG", price = 12000.00),
                Item(id = 2, userId = 1, name = "Jeruk Mandarin 1 KG", price = 30000.00),
                Item(id = 3, userId = 1, name = "Alpukat 250 GR", price = 50000.00),
                Item(id = 4, userId = 1, name = "Teh Celup 25 PCS", price = 15500.00),
                Item(id = 5, userId = 1, name = "Kepiting Laut 2 KG", price = 120000.00),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding() // Tetap gunakan safeContentPadding
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Kashier Home (Testing UI)", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            // 1. Uji Komponen SectionDivider
            SectionDivider(
                title = "Semua barang",
                isContentVisible = isListVisible,
                onToggleVisibility = {
                    // Logika untuk mengubah state visibility
                    isListVisible = !isListVisible
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            // 2. Uji Komponen ItemCard di dalam LazyColumn (daftar)
            AnimatedVisibility(visible = isListVisible) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(dummyItems) { item ->
                        ItemCard(
                            item = item,
                            onAddClick = { addedItem -> println("Ditambahkan: ${addedItem.name}") },
                            onEditClick = { editedItem -> println("Edit: ${editedItem.name}") }
                        )
                    }
                }
            }
        }
    }
}