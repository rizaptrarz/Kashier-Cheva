package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionDivider(
    modifier: Modifier = Modifier,
    title: String,
    visible: Boolean,
    onAction: (visibility: Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(MaterialTheme.colorScheme.onBackground)
        )
        Spacer(modifier = Modifier.width(4.dp))
        IconButton(
            onClick = { onAction(!visible) }
        ) {
            Icon(
                imageVector = if (visible) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = if (visible) "Collapse" else "Expand"
            )
        }
    }
}

@Preview
@Composable
fun SectionDividerPreview() {
    Surface {
        SectionDivider(
            modifier = Modifier.padding(start = 16.dp, end = 4.dp),
            title = "Barang Terpilih",
            visible = false,
            onAction = { _ -> }
        )
    }
}
