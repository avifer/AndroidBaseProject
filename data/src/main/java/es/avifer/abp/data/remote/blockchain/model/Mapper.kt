package es.avifer.abp.data.remote.blockchain.model

import es.avifer.abp.domain.entities.blockchain.CryptoBo

fun CryptoTickersDto.toBo() = CryptoBo(
    symbol ?: "NO_DATA",
    lastTradePrice ?: 0.0,
)