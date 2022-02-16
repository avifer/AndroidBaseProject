package es.avifer.abp.domain.blockchain.repository

import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.Response

interface RepositoryBlockchain {

    suspend fun getDataOnlineOfCrypto(value: String): Response<CryptoBo?>

    suspend fun getDataOfflineOfCrypto(value: String): Response<CryptoBo?>

    suspend fun saveDataOfflineOfCrypto(value: CryptoBo): Response<List<Long>>

    suspend fun updateDataOfflineOfCrypto(value: CryptoBo): Response<Int>

}