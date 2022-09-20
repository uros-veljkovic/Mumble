package com.example.mumble.data.repository.impl

import com.example.mumble.domain.model.User
import com.example.mumble.domain.repository.IChatRepository
import com.example.mumble.domain.repository.source.IChatLocalDataSource
import com.example.mumble.utils.OtherUsersOnline
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val localDataSource: IChatLocalDataSource
) : IChatRepository {

    override fun getCurrentUser(): Flow<User> {
        return localDataSource.getCurrentUser()
    }

    override suspend fun updateCurrentUser(user: User) {
        localDataSource.updateCurrentUser(user)
    }

    override suspend fun setCurrentUsersNickname(newNickname: String) {
        localDataSource.setCurrentUsersNickname(newNickname)
    }

    override suspend fun setCurrentUserOnline(isOnline: Boolean) {
        localDataSource.setCurrentUserOnline(isOnline)
    }

    override suspend fun createUser(user: User) {
        localDataSource.createNewUser(user)
    }

    override fun getAllUsers(): Flow<OtherUsersOnline> {
        return localDataSource.getAllUsers()
    }

    override fun deleteUser(nickname: String) {
        localDataSource.deleteUser(nickname)
    }
}
