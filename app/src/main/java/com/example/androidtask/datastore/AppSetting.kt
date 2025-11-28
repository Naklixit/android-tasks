package com.example.androidtask.datastore

import kotlinx.coroutines.flow.Flow

interface AppSetting {
    val appSettingFlow: Flow<AppSettingData>
    suspend fun setNotification(isNotificationOn: Boolean)
    suspend fun getNotificationOn(): Boolean
}
