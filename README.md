# Android Lifecycle Observer Example

A simple Android application demonstrating Android Activity Lifecycle and LifecycleObserver implementation with Jetpack Compose.

## Overview

This project showcases how to implement and observe Android Activity lifecycle events using both traditional Activity lifecycle callbacks and the modern `LifecycleObserver` pattern. The app displays lifecycle events in the Logcat, making it easy to understand when each lifecycle method is called.

## Features

* **Activity Lifecycle Callbacks**: Demonstrates all Activity lifecycle methods (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`)
* **LifecycleObserver Pattern**: Custom observer implementing `DefaultLifecycleObserver` to track lifecycle events
* **Jetpack Compose UI**: Modern declarative UI using Compose
* **Material Design 3**: Uses Material3 components for a modern look
* **Logging**: All lifecycle events are logged to Logcat for easy observation

## Project Structure

```
app/src/main/java/demo/amjadkhan/newlifecycle/
├── MainActivity.kt              # Main activity with lifecycle callbacks
├── observer/
│   └── MyObserver.kt           # Custom LifecycleObserver implementation
└── ui/theme/                   # Compose theme configuration
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

## How It Works

1. **Activity Lifecycle**: `MainActivity` overrides all lifecycle methods and logs each event
2. **LifecycleObserver**: A custom `MyObserver` class implements `DefaultLifecycleObserver` and logs lifecycle events
3. **Observer Registration**: The observer is registered in `onCreate()` using `lifecycle.addObserver()`
4. **Logging**: Both Activity callbacks and Observer methods log to Logcat with their respective tags

### Key Code Snippet

```kotlin
// Registering the observer
myLifecycleOwner = this
myLifecycleOwner.lifecycle.addObserver(MyObserver())

// Custom Observer
class MyObserver : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MyObserver", "onCreate")
    }
    // ... other lifecycle methods
}
```

## Requirements

* **Minimum SDK**: 24 (Android 7.0)
* **Target SDK**: 36
* **Compile SDK**: 36
* **Kotlin**: 2.0.21
* **Java**: 11

## Dependencies

* AndroidX Core KTX
* Lifecycle Runtime KTX
* Jetpack Compose (BOM 2024.09.00)
* Material Design 3
* Activity Compose

## Building the Project

1. Clone or download this repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

## Usage

1. Launch the app
2. Open Logcat in Android Studio
3. Filter by tags: `MainActivity` or `MyObserver`
4. Interact with the app (minimize, restore, rotate device, etc.)
5. Observe the lifecycle events being logged

### Expected Logcat Output

When you launch the app, you should see:
```
MainActivity: onCreate
MyObserver: onCreate
MainActivity: onStart
MyObserver: onStart
MainActivity: onResume
MyObserver: onResume
```

When you minimize the app:
```
MainActivity: onPause
MyObserver: onPause
MainActivity: onStop
MyObserver: onStop
```

## Architecture

This is a simple example demonstrating lifecycle concepts. For production apps, consider:

* Using ViewModel to hold business logic
* Implementing proper lifecycle-aware components
* Using StateFlow/Flow for reactive data streams
* Following MVVM or MVI architecture patterns
* Properly handling configuration changes

## Lifecycle Events Explained

* **onCreate**: Called when the activity is first created
* **onStart**: Called when the activity becomes visible to the user
* **onResume**: Called when the activity starts interacting with the user
* **onPause**: Called when the activity loses focus but is still visible
* **onStop**: Called when the activity is no longer visible to the user
* **onRestart**: Called when the activity is restarting after being stopped
* **onDestroy**: Called when the activity is being destroyed

## License

This is a simple example project for educational purposes.

## Author

Amjad Khan

