package org.chevalierlabsas.kashier.home.data

import org.chevalierlabsas.kashier.home.domain.Item

class DummyDataSOurce {
    fun getData(): List<Item> = listOf(
        Item(
            id = 1,
            userId = 1,
            name = "Item 1",
            price = 100000.0
        ),
        Item(
            id = 2,
            userId = 1,
            name = "Item 2",
            price = 200000.0
        ),
        Item(
            id = 3,
            userId = 1,
            name = "Item 3",
            price = 300000.0
        ),
    )
}