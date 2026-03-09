package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemFormBottomSheet(
    item: Item? = null,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onSave: (nama: String, harga: Double) -> Unit
) {
    var namaBarang by remember(item) { mutableStateOf(item?.name ?: "") }
    var hargaBarang by remember(item) { mutableStateOf(item?.price?.toString() ?: "") }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = if (item == null) "Tambah Barang" else "Edit Barang",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(text = "Nama barang", style = MaterialTheme.typography.labelLarge)
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = namaBarang,
                onValueChange = { namaBarang = it },
                placeholder = { Text("Beri nama barang") },
                leadingIcon = { Icon(Icons.Default.TextFields, contentDescription = null) },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )

            Text(text = "Harga barang", style = MaterialTheme.typography.labelLarge)
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = hargaBarang,
                onValueChange = { hargaBarang = it },
                placeholder = { Text("Rp. 000,00") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            SaveButton(
                modifier = Modifier.fillMaxWidth(),
                onSave = {
                    onSave(namaBarang, hargaBarang.toDoubleOrNull() ?: 0.0)
                },
                enabled = namaBarang.isNotBlank() && hargaBarang.isNotBlank()
            )
        }
    }
}