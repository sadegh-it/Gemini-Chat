# 🤖 Gemini Chat

A modern Android AI chat application built with **Kotlin** and **Jetpack Compose**.  
This project demonstrates how to integrate the **Google Gemini API** into an Android application using a clean and scalable architecture.

---

## 🚀 Overview

Gemini Chat is a simple AI-powered chat application that connects to the **Google Gemini API**.

This project showcases:

- Clean Architecture with MVVM pattern
- Dependency Injection with Hilt
- Networking with Retrofit
- Professional Git workflow using Git Flow
 

It serves as a practical reference for developers who want to integrate AI APIs into Android applications.

---

## 🧱 Architecture

The project follows Clean Architecture with MVVM:

### 🔹 Presentation
- Compose UI
- ViewModel
- UI State management
- Separation of concerns  
- Scalability  
- Maintainability  

### 🔹 Data
- Repository Implementation
- Remote Data Source
- Retrofit Service
- Hilt Modules


---

## 🛠 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **Clean Architecture**
- **Hilt (Dependency Injection)**
- **Retrofit (Networking)**
- **Google Gemini API**
- **Git Flow**

All dependencies are centrally managed in the [libs.versions.toml](https://github.com/sadegh-it/Gemini-Chat/blob/main/gradle/libs.versions.toml) file.

[![Networking](https://img.shields.io/badge/Networking-Retrofit-grey?style=flat&logo=framework&color=lightblue)](https://developer.android.com/training/dependency-injection/hilt-android)
[![DI](https://img.shields.io/badge/DI-Hilt-grey?style=flat&logo=devpost&color=red)](https://developer.android.com/training/dependency-injection/hilt-android)
[![Room](https://img.shields.io/badge/Database-ROOM-grey?style=flat&logo=sqlite&logoColor=%23cbcbcb&color=lightgrey)](https://developer.android.com/jetpack/androidx/releases/room)
[![Navigation](https://img.shields.io/badge/Navigation-Component-grey?style=flat&logo=jetpackcompose&logoColor=%2397c900&color=yellowgreen)](https://developer.android.com/guide/navigation)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-brightgreen)](https://developer.android.com/compose)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean-blue)](https://developer.android.com/topic/libraries/architecture/viewmodel)
 
---
## 🔑 Getting Your Gemini API Key

To use **Gemini Chat**, you need a personal API key from **Google AI Studio**.  
Follow these steps to get your key:

### 1. Sign in to Google AI Studio
- Go to [Google AI Studio](https://aistudio.google.com/).  
- Sign in with your Google account.

### 2. Navigate to API Credentials
- Click on **"API & Services"** in the menu.  
- Select **"Credentials"**.

### 3. Create a New API Key
- Click **"Create API Key"**.  
- Name your key (e.g., `Gemini Chat Key`).  
- Copy the generated key securely.

### 4. Keep Your Key Private
- **Important:** Never share or commit your API key to GitHub.  
- Store it securely in your local environment, such as `local.properties` or environment variables.

### 5. Ready to Use
Once you have your API key, you can configure your project to use it.  

> ⚠️ **Security Tip:** Always treat your API key like a password. Avoid including it in source files or public repositories.

---

## 🔑 Gemini API Key Setup

To run this project, you must provide your own Gemini API key.

1. Obtain your API key from **Google AI Studio**.
2. Open: [ChatRepository.kt](https://github.com/sadegh-it/Gemini-Chat/blob/develop/app/src/main/java/io/github/sadeghi/geminichat/data/repository/ChatRepository.kt#L17)

```
app/src/main/java/io/github/sadeghi/geminichat/data/repository/ChatRepository.kt
```

3. Find the placeholder (around line 17):

```kotlin
val apiKey = "YOUR_API_KEY_HERE"
```

4. Replace it with your actual API key.

> ⚠️ Important:  
> Never commit your API key to GitHub.  
> Use a secure configuration approach such as `local.properties` or environment variables in production apps.

---

## 🔒 Secure API Key Setup

To safely run **Gemini Chat**, you need to store your **Gemini API Key** securely.  
Never commit your API key to GitHub. Follow these steps:
##

### 1️⃣ Add API Key to `local.properties`

1. Open your project in Android Studio.  
2. Locate the `local.properties` file in the root directory.  
   - If it doesn't exist, create a new file named `local.properties`.  
3. Add your API key like this:

```properties
apikey=your_api_key_here
```
> ⚠️ Important:  
> local.properties is automatically ignored by Git.  
> Your key will never be pushed to the remote repository.
 

#### 2️⃣ Expose API Key via BuildConfig

Open your app/build.gradle.kts (or app/build.gradle) file.

Inside the android add:
```kotlin
import java.io.FileInputStream
import java.util.Properties

android {
    namespace = "io.github"
    compileSdk = 36

    //thie
    val file =rootProject.file("local.properties")
    val properties = Properties()
    properties.load(FileInputStream(file))

    defaultConfig {
        .
        .
        //this
        buildConfigField("String","GEMINI_API_KEY","\"${properties.getProperty("apikey")}\"")

    }
buildFeatures {
        compose = true
        buildConfig = true  //this
    }
}
```
Sync the project with Gradle files.

This generates a constant: BuildConfig.GEMINI_API_KEY that you can use anywhere in your code.

#### 3️⃣ Use the API Key in Code

Anywhere you need the API key (e.g., repository or network layer), use:

```kotlin
val apiKey = BuildConfig.GEMINI_API_KEY
if (apiKey.isBlank()) throw IllegalStateException("Add GEMINI_API_KEY to local.properties!")
```
or 

```kotlin
val apikey = BuildConfig.GEMINI_API_KEY
```

BuildConfig.GEMINI_API_KEY fetches the key securely from local.properties.

The check ensures that if the key is missing, your app throws a clear error instead of silently failing.

#### 4️⃣ Best Practices

Never commit API keys to version control.

Use local.properties + BuildConfig for safe local development.

For production apps, consider using encrypted storage or environment variables.

Rotate keys immediately if accidentally exposed.

#### ✅ Benefits

Security: API key is never committed.

Ease of use: Accessible anywhere via BuildConfig.

Professional workflow: Follows Android industry best practices.

Portfolio-ready: Demonstrates knowledge of secure API management.

---

## 📂 Project Structure

```
app/
├── application
├── data/
│   ├── model/
│   │   └── geminiModels
│   ├── remote
│   └── repository
├── database/
│   ├── dao
│   ├── entity
│   └── mainDb
├── di
├── navigate
├── ui/
│   ├── components
│   ├── detailScreen
│   ├── screen
│   └── theme
├── utils
├── viewModel
└── MainActivity.kt
```

- The **Repository layer** communicates with the Gemini API.
- The **ViewModel** handles business logic and UI state.
- The **Compose UI** observes state updates and renders chat messages.

---

## 🔄 Git Flow Workflow

This project is managed using **Git Flow**:

- `main` → Stable production-ready versions  
- `develop` → Ongoing development  
- `feature/*` → New features  
- `release/*` → Release preparation  
- `hotfix/*` → Critical fixes  

This ensures a professional and scalable version control workflow.

---

## 🎯 Purpose of This Project

This is an educational sample project that demonstrates:

- How to integrate AI APIs in Android
- How to structure scalable Android apps
- How to apply Clean Architecture properly
- How to manage releases professionally using Git Flow

It is intended as a learning and architectural reference project.


---

## 🏷 Version

 
[![Latest Release](https://img.shields.io/badge/Latest%20Release-v1.0.0-gery?style=plastic&logo=github)](https://github.com/sadegh-it/Gemini-Chat/releases/tag/v1.0.0)


## 📥 Download

You can download the latest stable APK from the official GitHub Releases page:

[![Download Latest Release](https://img.shields.io/badge/Download-APK-blue?style=for-the-badge&logo=android)](https://github.com/sadegh-it/Gemini-Chat/releases/download/v1.0.0/Gemini-Chat.apk)

---

## 📄 License

This project is licensed under the MIT License.

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction...

See the full license in the [LICENSE](LICENSE) file.

---

## ⭐ Support

If you found this project useful and helpful, consider giving it a star on GitHub⭐.

![GitHub stars](https://img.shields.io/github/stars/sadegh-it/Gemini-Chat?style=for-the-badge)
