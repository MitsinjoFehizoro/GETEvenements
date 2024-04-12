package app.getevents.di

import app.getevents.data.api.GetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit (): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.36:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideGetApi(retrofit: Retrofit) : GetApi{
        return retrofit.create(GetApi::class.java)
    }
}