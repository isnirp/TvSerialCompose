package com.flimbis.tvserialcompose.data

import com.flimbis.tvserialcompose.model.Episodes
import com.flimbis.tvserialcompose.model.Shows
import com.flimbis.tvserialcompose.model.Season
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
* The following are a few endpoints to look at from the tv maze api http://www.tvmaze.com/api
* */
interface ApiService {
    /*
   * endpoint http://api.tvmaze.com/shows?page=1
   * paginated 250 items per page
   * */
    @GET("shows")
    suspend fun getAllShows(@Query("page") pageNumber: Int): List<Shows>

    /*
    * endpoint http://api.tvmaze.com/shows/1
    * */
    @GET("shows/{id}")
    suspend fun getShowById(@Path("id") id: Long): Shows

    /*
    * endpoint http://api.tvmaze.com/shows/1/episodes
    * */
    @GET("shows/{id}/episodes")
    suspend fun getAllEpisodesOfShow(@Path("id") id: Long): List<Episodes>

    /*
    * endpoint http://api.tvmaze.com/shows/1/episodebynumber?season=1&number=1
    * */
    @GET("shows/{id}/episodebynumber")
    suspend fun getEpisodeOfShow(@Path("id") id: Long, @Query("season") seasonNumber: String, @Query("number") episodeNumber: String): Episodes

    /*
    * endpoint http://api.tvmaze.com/shows/1/seasons
    * */
    @GET("shows/{id}/seasons")
    suspend fun getAllSeasonsOfShow(@Path("id") id: Long): List<Season>

    /*
    * endpoint http://api.tvmaze.com/seasons/1/episodes
    * */
    @GET("seasons/{id}/episodes")
    suspend fun getAllEpisodesOfSeasons(@Path("id") id: Long): List<Episodes>
}