package es.avifer.abp.data.local.blockchain.model

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.avifer.abp.data.local.DatabaseApp

@Entity(tableName = DatabaseApp.TABLE_CRYPTO_DBO)
data class CryptoDbo(
    @PrimaryKey
    @ColumnInfo(name = DatabaseApp.KEY_CRYPTO_CRYPTO_DBO)
    val keyCrypto: String,
    @ColumnInfo(name = DatabaseApp.LAST_PRICE_CRYPTO_DBO)
    val lastPrice: Double,
)
