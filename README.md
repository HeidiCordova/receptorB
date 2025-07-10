
## Integrantes del Proyecto

- **Cordova Silva, Heidi**
- **Hancco Condori, Bryan**


## Actividades Realizadas

### 1. Configuración del Proyecto
- **Responsable**: Heidi
- **Descripción**: Configuración inicial del proyecto Android con Kotlin y Jetpack Compose
- **Archivos**: 
  - build.gradle (configuración de dependencias)
  - settings.gradle (configuración de repositorios)
  - AndroidManifest.xml (permisos y configuración de la aplicación)

### 2. Implementación del Escaneo BLE
- **Responsable**: Bryan
- **Descripción**: Desarrollo del sistema de escaneo de beacons Bluetooth Low Energy
- **Clase**: BeaconScanner
- **Funcionalidades**:
  - Escaneo automático de dispositivos BLE
  - Filtrado por ID de fabricante (76)
  - Extracción de datos de sensores

### 3. Gestión de Estados y UI
- **Responsable**: Heidi
- **Descripción**: Implementación del manejo de estados en la UI con Jetpack Compose
- **Clase**: BeaconViewModel
- **Funcionalidades**:
  - StateFlow para estados reactivos
  - Gestión de lista de beacons detectados
  - Selección y visualización de beacon específico
  - Actualización en tiempo real de datos

### 4. Implementación de la Interfaz de Usuario
- **Responsable**: Heidi & Bryan
- **Descripción**: Desarrollo de la interfaz con Jetpack Compose
- **Clase**: ScannerScreen
- **Características**:
  - Lista scrolleable de beacons detectados
  - Visualización de datos de temperatura y humedad
  - Interfaz intuitiva para selección de dispositivos
  - Indicadores de intensidad de señal RSSI

### 5. Gestión de Permisos
- **Responsable**: Bryan
- **Descripción**: Configuración y manejo de permisos necesarios para BLE
- **Clase**: PermissionHandler
- **Permisos implementados**:
  - BLUETOOTH_SCAN - Para escaneo de dispositivos
  - BLUETOOTH_CONNECT - Para conexión con dispositivos
  - ACCESS_FINE_LOCATION - Requerido para BLE
  - Compatibilidad con Android 12+ y versiones anteriores



## Arquitectura del Proyecto

### Componentes Principales

```
com.example.receptorb/
├── MainActivity.kt          # Actividad principal
├── BeaconScanner.kt        # Lógica de escaneo BLE
├── BeaconViewModel.kt      # Gestión de estado
├── ScannerScreen.kt        # Interfaz de usuario
└── PermissionHandler.kt    # Gestión de permisos
```

