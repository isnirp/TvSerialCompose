package com.flimbis.tvserialcompose.data

import com.flimbis.tvserialcompose.model.Shows
import javax.inject.Inject

interface ShowsDataSource {
    suspend fun getAll(pageNumber: Int): List<Shows>

    suspend fun get(id: Long): Shows
}

class ShowsDataSourceImpl @Inject constructor(private val apiService: ApiService) : ShowsDataSource {
    override suspend fun getAll(pageNumber: Int): List<Shows> {
        return apiService.getAllShows(pageNumber)
    }

    override suspend fun get(id: Long): Shows {
        return apiService.getShowById(id)
    }

}