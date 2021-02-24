plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    val navVersion = "2.3.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    val fragmentVersion = "1.2.2"
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    val timberVersion = "4.7.1"
    implementation ("com.jakewharton.timber:timber:$timberVersion")

    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
    implementation("androidx.core:core-ktx:1.5.0-beta01")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.ramitsuri.forumhub.android"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}