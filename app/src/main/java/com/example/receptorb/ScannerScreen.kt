package com.example.receptorb

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScannerScreen(viewModel: BeaconViewModel) {
    val beacons by viewModel.beacons.collectAsState()
    val selectedBeacon by viewModel.selectedBeacon.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Beacons detectados:", style = MaterialTheme.typography.titleMedium)

            LazyColumn(modifier = Modifier.height(200.dp)) {
                items(beacons) { beacon ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.selectBeacon(beacon) }
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "MAC: ${beacon.deviceAddress}", fontSize = 14.sp)
                            Text(text = "RSSI: ${beacon.rssi} dBm", fontSize = 12.sp)
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text("T: ${beacon.temperature}°C", fontSize = 14.sp)
                            Text("H: ${beacon.humidity}%", fontSize = 14.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            selectedBeacon?.let {
                Text("Emisor seleccionado:", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("MAC: ${it.deviceAddress}")
                Text("Temperatura: ${it.temperature}°C", fontSize = 20.sp)
                Text("Humedad: ${it.humidity}%", fontSize = 20.sp)
            } ?: Text("Selecciona un beacon para ver detalles")
        }
    }
}
