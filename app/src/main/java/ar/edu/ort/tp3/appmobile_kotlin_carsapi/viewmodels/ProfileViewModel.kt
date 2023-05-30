package ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _profileName = MutableLiveData<String>()
    val profileName: LiveData<String>
        get() = _profileName

    private val _profilePhotoUrl = MutableLiveData<String>()
    val profilePhotoUrl: LiveData<String>
        get() = _profilePhotoUrl

    fun updateProfileInfo(name: String, photoUrl: String) {
        _profileName.value = name
        _profilePhotoUrl.value = photoUrl
    }
}