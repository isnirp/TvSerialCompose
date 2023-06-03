package com.flimbis.tvserialcompose.data.repo

import com.flimbis.tvserialcompose.data.ShowsDataSource
import com.flimbis.tvserialcompose.model.Shows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface ShowsRepository {
    suspend fun getAll(pageNumber: Int): List<Shows>

    suspend fun get(id: Long): Shows?
}

class ShowsRepositoryImpl @Inject constructor(private val dataSource: ShowsDataSource) : ShowsRepository {
    override suspend fun getAll(pageNumber: Int): List<Shows> {
        return withContext(Dispatchers.IO) /*switch context; makes coroutine cancelable by default*/{
            dataSource.getAll(pageNumber)
        }
    }

    override suspend fun get(id: Long): Shows? {
       return withContext(Dispatchers.IO) {
           dataSource.get(id)
       }
    }

}