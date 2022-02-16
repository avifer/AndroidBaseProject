package es.avifer.abp.data.remote.blockchain.datasource

import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.Response

interface BlockchainRemoteDataSource {

    suspend fun getDataOfCryptoOnline(value: String): Response<CryptoBo?>

}