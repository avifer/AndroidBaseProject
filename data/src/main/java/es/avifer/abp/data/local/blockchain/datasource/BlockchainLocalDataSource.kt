package es.avifer.abp.data.local.blockchain.datasource

import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.Response

interface BlockchainLocalDataSource {

    suspend fun getLastDataOfCrypto(value: String): Response<CryptoBo?>

    suspend fun saveLastDataOfCrypto(value: CryptoBo): Response<List<Long>>

    suspend fun updateLastDataOfCrypto(value: CryptoBo): Response<Int>

}