plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.quadexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quadexample"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    val media3Version = "1.1.1"

    // For media playback using ExoPlayer
    implementation("androidx.media3:media3-exoplayer:$media3Version")

    // For DASH playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-dash:$media3Version")
    // For HLS playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-hls:$media3Version")
    // For RTSP playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-rtsp:$media3Version")
    // For ad insertion using the Interactive Media Ads SDK with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-ima:$media3Version")

    // For loading data using the Cronet network stack
    implementation("androidx.media3:media3-datasource-cronet:$media3Version")
    // For loading data using the OkHttp network stack
    implementation("androidx.media3:media3-datasource-okhttp:$media3Version")
    // For loading data using librtmp
    implementation("androidx.media3:media3-datasource-rtmp:$media3Version")

    // For building media playback UIs
    implementation("androidx.media3:media3-ui:$media3Version")
    // For building media playback UIs for Android TV using the Jetpack Leanback library
    implementation("androidx.media3:media3-ui-leanback:$media3Version")

    // For exposing and controlling media sessions
    implementation("androidx.media3:media3-session:$media3Version")

    // For extracting data from media containers
    implementation("androidx.media3:media3-extractor:$media3Version")

    // For integrating with Cast
    implementation("androidx.media3:media3-cast:$media3Version")

    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-workmanager:$media3Version")

    // For transforming media files
    implementation("androidx.media3:media3-transformer:$media3Version")

    // Utilities for testing media components (including ExoPlayer components)
    implementation("androidx.media3:media3-test-utils:$media3Version")
    // Utilities for testing media components (including ExoPlayer components) via Robolectric
    implementation("androidx.media3:media3-test-utils-robolectric:$media3Version")

    // Common functionality for media database components
    implementation("androidx.media3:media3-database:$media3Version")
    // Common functionality for media decoders
    implementation("androidx.media3:media3-decoder:$media3Version")
    // Common functionality for loading data
    implementation("androidx.media3:media3-datasource:$media3Version")
    // Common functionality used across multiple media libraries
    implementation("androidx.media3:media3-common:$media3Version")
}