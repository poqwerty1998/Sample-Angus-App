package com.example.sampleangusapp.ui.base

import androidx.lifecycle.ViewModel
import com.example.sampleangusapp.data.repository.AppRepository

abstract class AppViewModel(
    private val appRepository: AppRepository
) : ViewModel() {
    val equipmentId = 1100000005
}