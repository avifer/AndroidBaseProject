package es.avifer.abp.data.remote.blockchain.datasource

import es.avifer.abp.data.remote.blockchain.api.ExchangeApi
import es.avifer.abp.data.remote.blockchain.model.toBo
import es.avifer.abp.data.utils.BaseRepository
import es.avifer.abp.data.utils.safeRemoteCall
import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.Response

class BlockchainRemoteDataSourceImpl(private val exchangeApi: ExchangeApi) :
    BlockchainRemoteDataSource, BaseRepository() {

    override suspend fun getDataOfCryptoOnline(value: String): Response<CryptoBo?> {
        return safeRemoteCall { exchangeApi.getData(value).toBo() }
    }

}