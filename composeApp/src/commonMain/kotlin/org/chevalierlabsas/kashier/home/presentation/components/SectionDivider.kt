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

// Hilangkan 'class SectionDivider {}' yang kosong, ganti dengan fungsi Composable

@Composable
fun SectionDivider(
    title: String,
    isContentVisible: Boolean, // Status apakah konten di bawah divider terlihat
    onToggleVisibility: () -> Unit, // Lambda untuk aksi tampilkan/sembunyikan
    modifier: Modifier = Modifier
) {
    // Row sebagai container utama untuk divider
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onToggleVisibility) // Seluruh divider bisa diklik untuk toggle
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween, // Pisahkan Judul dan Icon
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Teks Judul (e.g., "Semua barang")
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            // Menggunakan warna onSurface sesuai rekomendasi tugas
            color = MaterialTheme.colorScheme.onSurface
        )

        // Icon Panah (menunjukkan status tampil/sembunyi)
        Icon(
            imageVector = if (isContentVisible) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
            contentDescription = "Toggle Visibility for $title",
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }
}

// Tambahkan Preview untuk melihat hasilnya
@Preview
@Composable
private fun SectionDividerPreviewVisible() {
    MaterialTheme {
        SectionDivider(
            title = "Semua barang",
            isContentVisible = true, // Tampilkan panah ke atas
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
            isContentVisible = false, // Tampilkan panah ke bawah
            onToggleVisibility = {}
        )
    }
}