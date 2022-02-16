package es.avifer.abp.data.local.blockchain.model

import es.avifer.abp.domain.entities.blockchain.CryptoBo

fun CryptoDbo.toBo() = CryptoBo(
    keyCrypto,
    0.0,
    lastPrice
)

fun CryptoBo.toDbo() = CryptoDbo(
    name,
    priceOnline ?: 0.0
)