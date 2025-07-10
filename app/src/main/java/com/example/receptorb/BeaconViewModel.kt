package com.example.receptorb

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class BeaconData(
    val deviceAddress: String,
    val temperature: Int,
    val humidity: Int,
    val rssi: Int,
)

class BeaconViewModel : ViewModel() {
    private val _beacons = MutableStateFlow<List<BeaconData>>(emptyList())
    val beacons: StateFlow<List<BeaconData>> = _beacons

    private val _selectedBeacon = MutableStateFlow<BeaconData?>(null)
    val selectedBeacon: StateFlow<BeaconData?> = _selectedBeacon

    fun updateBeacon(deviceAddress: String, temperature: Int, humidity: Int, rssi: Int) {
        _beacons.update { currentList ->
            val updatedList = currentList
                .filterNot { it.deviceAddress == deviceAddress }
                .toMutableList()
            updatedList.add(BeaconData(deviceAddress, temperature, humidity, rssi))
            updatedList
        }
    }

    fun selectBeacon(beacon: BeaconData) {
        _selectedBeacon.value = beacon
    }
}
