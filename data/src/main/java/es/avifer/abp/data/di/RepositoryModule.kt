package es.avifer.abp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.avifer.abp.data.local.blockchain.dao.BlockchainDao
import es.avifer.abp.data.local.blockchain.datasource.BlockchainLocalDataSource
import es.avifer.abp.data.local.blockchain.datasource.BlockchainLocalDataSourceImpl
import es.avifer.abp.data.remote.blockchain.api.ExchangeApi
import es.avifer.abp.data.remote.blockchain.datasource.BlockchainRemoteDataSource
import es.avifer.abp.data.remote.blockchain.datasource.BlockchainRemoteDataSourceImpl
import es.avifer.abp.data.repository.RepositoryBlockchainImpl
import es.avifer.abp.domain.blockchain.repository.RepositoryBlockchain
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getBlockchainRemoteDataSource(exchangeApi: ExchangeApi): BlockchainRemoteDataSource {
        return BlockchainRemoteDataSourceImpl(exchangeApi)
    }

    @Provides
    fun getBlockchainLocalDataSource(blockchainDao: BlockchainDao): BlockchainLocalDataSource {
        return BlockchainLocalDataSourceImpl(blockchainDao)
    }

    @Singleton
    @Provides
    fun getRepositoryBlockchainImpl(
        blockchainRemoteDataSource: BlockchainRemoteDataSource,
        blockchainLocalDataSource: BlockchainLocalDataSource
    ): RepositoryBlockchain {
        return RepositoryBlockchainImpl(blockchainRemoteDataSource, blockchainLocalDataSource)
    }

}