package org.chevalierlabsas.kashier.home.presentation

import SelectedItemChip
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kashier.composeapp.generated.resources.*
import org.chevalierlabsas.kashier.home.data.DummyDataSOurce
import org.chevalierlabsas.kashier.home.domain.Item
import org.chevalierlabsas.kashier.home.presentation.components.ItemCard
import org.chevalierlabsas.kashier.home.presentation.components.SaveButton
import org.chevalierlabsas.kashier.home.presentation.components.SectionDivider
import org.chevalierlabsas.kashier.home.presentation.components.TotalPriceHeader
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var totalPrice by remember { mutableStateOf(0.00) }
    val selectedItems = remember { mutableStateListOf<Item>() }
    var showSelectedItem by remember { mutableStateOf(true) }
    var showAllItem by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(Res.string.app_name))
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { TODO("Add Item.") },
                containerColor = MaterialTheme.colorScheme.tertiary,
                text = { Text(text = stringResource(Res.string.add_item_fab_label)) },
                icon = { Icon(Icons.Filled.Add, contentDescription = stringResource(Res.string.add_item_fab_label)) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
        ) {
            item {
                TotalPriceHeader(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    totalPrice = totalPrice
                )
            }
            item {
                SaveButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSave = { TODO("Save data.") },
                    enabled = selectedItems.isNotEmpty() && totalPrice > 0.00
                )
            }

            item {
                SectionDivider(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.selected_item_label),
                    isContentVisible = showSelectedItem,
                    onAction = { isContentVisible ->
                        showSelectedItem = isContentVisible
                    }
                )
            }
            item {
                AnimatedVisibility(
                    visible = showSelectedItem,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    FlowRow(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            selectedItems.map { item ->
                                SelectedItemChip(
                                    onRemove = {
                                        selectedItems.remove(item)
                                        totalPrice = item.price
                                    },
                                    item = item,
                                    modifier = Modifier.padding(horizontal = 4.dp)
                                )
                            }
                        }
                    )
                }
            }
            item {
                SectionDivider(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.all_item_label),
                    isContentVisible = showAllItem,
                    onAction = { isContentVisible ->
                        showAllItem = isContentVisible
                    }
                )
            }

            items(DummyDataSOurce().getData()) { item -> // Barang individu
                AnimatedVisibility(
                    visible = showAllItem,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    // Gunakan ItemCard milik kalian
                    // Dibawah adalah contoh ItemCard
                    ItemCard(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        item = item,
                        onEdit = { },
                        onAdd = {
                            selectedItems.add(item)
                            totalPrice += item.price
                        }
                    )
                }
            }

        }

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}