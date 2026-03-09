package org.chevalierlabsas.kashier.home.presentation

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kashier.composeapp.generated.resources.*
import org.chevalierlabsas.kashier.home.data.DummyDataSource
import org.chevalierlabsas.kashier.home.presentation.components.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {

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
                    totalPrice = state.totalPrice
                )
            }
            item {
                SaveButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSave = { TODO("Save data.") },
                    enabled = state.selectedItems.isNotEmpty() && state.totalPrice > 0.00
                )
            }
            item {
                HomeSeparator(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.selected_item_label),
                    visible = state.showSelectedItem,
                    onAction = { visible ->
                        onEvent(HomeEvent.OnSelectedItemVisibilityChange(visible))
                    }
                )
            }
            item {
                AnimatedVisibility(
                    visible = state.showSelectedItem,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    FlowRow(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            state.selectedItems.map { item ->
                                SelectedItemChip(
                                    onRemove = {
                                        onEvent(HomeEvent.OnRemoveItem(item))
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
                HomeSeparator(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.all_item_label),
                    visible = state.showAllItem,
                    onAction = { visible ->
                        onEvent(HomeEvent.OnAllItemVisibilityChange(visible))
                    }
                )
            }

            item {
                SearchBar(
                    modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                    value = state.searchQuery,
                    onValueChange = { onEvent(HomeEvent.OnSearchQueryChange(it)) }
                )
            }

            items(DummyDataSource().getData()) { item ->
                AnimatedVisibility(
                    visible = state.showAllItem,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    ItemCard(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        item = item,
                        onEdit = { },
                        onAdd = {
                            onEvent(HomeEvent.OnAddItem(item))
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
    HomeScreen(
        state = HomeState(),
        onEvent = {  }
    )
}