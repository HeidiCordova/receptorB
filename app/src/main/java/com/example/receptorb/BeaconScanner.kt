package com.example.receptorb

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.*
import android.content.Context
import android.os.ParcelUuid
import android.util.Log
import androidx.annotation.RequiresPermission

class BeaconScanner(
    private val context: Context,
    private val viewModel: BeaconViewModel
) {
    private var scanner: BluetoothLeScanner? = null

    @RequiresPermission(Manifest.permission.BLUETOOTH_SCAN)
    fun startScan() {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val adapter = bluetoothManager.adapter

        if (!adapter.isEnabled) return
        scanner = adapter.bluetoothLeScanner

        val filter = ScanFilter.Builder().setManufacturerData(76, byteArrayOf()).build()
        val settings = ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build()

        scanner?.startScan(listOf(filter), settings, callback)
    }

    @RequiresPermission(Manifest.permission.BLUETOOTH_SCAN)
    fun stopScan() {
        scanner?.stopScan(callback)
    }

    private val callback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            result?.let {
                val data = it.scanRecord?.getManufacturerSpecificData(76)
                if (data != null && data.size >= 23) {
                    val temperature = data[20].toInt() and 0xFF
                    val humidity = data[21].toInt() and 0xFF
                    val address = result.device.address
                    val rssi = result.rssi

                    viewModel.updateBeacon(address, temperature, humidity, rssi)
                }
            }
        }
    }
}
