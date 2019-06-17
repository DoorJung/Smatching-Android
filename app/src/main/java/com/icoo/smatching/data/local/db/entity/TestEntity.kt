package com.icoo.smatching.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestEntity(
    @PrimaryKey val idx: Int
)