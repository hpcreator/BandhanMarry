# 💍 BandhanMarry

BandhanMarry is a modern matchmaking Android application built with [Kotlin](https://kotlinlang.org/) and [Jetpack Compose](https://developer.android.com/jetpack/compose).  
It’s designed for fast, secure, and delightful user experiences, following the latest Android best practices.

---

## 🚀 Features

- User registration and login with validation
- Profile creation and management (coming soon)
- Smart matchmaking algorithm (coming soon)
- Real-time chat and notifications (coming soon)
- Privacy-focused controls (coming soon)
- Modern, responsive UI with Material 3
- **Built with:**
  - Jetpack Compose (Material 3)
  - MVVM architecture with ViewModel
  - Dependency injection (Koin)
  - Compose Navigation
  - Kotlin Coroutines & Flow

---

## 🛠️ Getting Started

### Prerequisites

- [Android Studio Hedgehog or newer](https://developer.android.com/studio)
- [Kotlin 1.9+](https://kotlinlang.org/)
- Android device or emulator (API 24+)

### Installation

```bash
git clone https://github.com/hpcreator/BandhanMarry.git
cd BandhanMarry
./gradlew assembleDebug
```

Open in Android Studio and run on your device/emulator.

---

## 🌟 Architecture

- **MVVM (Model-View-ViewModel)**: Business logic in ViewModels, UI state via StateFlow.
- **Jetpack Compose**: Declarative, modern UI framework.
- **Koin**: Dependency injection for ViewModels and repositories.
- **Navigation-Compose**: In-app navigation.
- **Material 3**: Latest Material theming and components.

---

## 📦 Project Structure

```
app/
 └── src/
      └── main/
           ├── java/com/hpcreation/bandhanmarry/
           │    ├── presentation/         # UI Screens & Components
           │    ├── viewmodel/            # ViewModels for state and logic
           │    ├── di/                   # Koin modules (DI)
           │    └── ...                   # Other layers (data, domain, etc.)
           └── res/                       # Resources (layouts, strings, drawables)
```

---

## ✨ Contributing

Contributions are welcome! Please open an issue or submit a pull request for improvements, bug fixes, or features.

---

## 🤝 Contact

Questions or suggestions?  
Reach out via [GitHub Issues](https://github.com/hpcreator/BandhanMarry/issues) or contact the maintainer at [hpcreator](https://github.com/hpcreator).
