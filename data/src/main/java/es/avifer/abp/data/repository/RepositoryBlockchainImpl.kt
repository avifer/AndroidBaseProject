package es.avifer.abp.data.repository

import es.avifer.abp.data.local.blockchain.datasource.BlockchainLocalDataSource
import es.avifer.abp.data.remote.blockchain.datasource.BlockchainRemoteDataSource
import es.avifer.abp.data.utils.BaseRepository
import es.avifer.abp.domain.blockchain.repository.RepositoryBlockchain
import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.Response


class RepositoryBlockchainImpl(
    private val blockchainRemoteDataSource: BlockchainRemoteDataSource,
    private val blockchainLocalDataSource: BlockchainLocalDataSource
) : RepositoryBlockchain, BaseRepository() {
    override suspend fun getDataOnlineOfCrypto(value: String): Response<CryptoBo?> {
        return blockchainRemoteDataSource.getDataOfCryptoOnline(value)
    }

    override suspend fun getDataOfflineOfCrypto(value: String): Response<CryptoBo?> {
        return blockchainLocalDataSource.getLastDataOfCrypto(value)
    }

    override suspend fun saveDataOfflineOfCrypto(value: CryptoBo): Response<List<Long>> {
        return blockchainLocalDataSource.saveLastDataOfCrypto(value)
    }

    override suspend fun updateDataOfflineOfCrypto(value: CryptoBo): Response<Int> {
        return blockchainLocalDataSource.updateLastDataOfCrypto(value)
    }
}