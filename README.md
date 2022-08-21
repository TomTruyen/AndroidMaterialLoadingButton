# AndroidMaterialLoadingButton

![Example GIF]()


A simple LoadingButton using MaterialComponents.


## Import

```gradle
maven { url 'https://jitpack.io' }
```

```gradle
implementation 'com.github.TomTruyen:AndroidMaterialLoadingButton:1.0'
```


## Usage
### XML

```xml
<com.tomtruyen.android.material.loadingbutton.LoadingButton
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        app:LoadingButton_text="Text"
        app:LoadingButton_textColor="@color/white"
        app:LoadingButton_textSize="10sp"
        app:LoadingButton_icon="@drawable/ic_android"
        app:LoadingButton_iconGravity="start"
        app:LoadingButton_iconSize="24dp"
        app:LoadingButton_indeterminate="true"
        app:LoadingButton_indicatorColor="@color/white"
        app:LoadingButton_indicatorSize="24dp"
        app:LoadingButton_indicatorThickness="2dp"
        />

```

### Kotlin

#### Show loading indicator

```kotlin
button.startLoading()
```

#### Hide loading indicator

```kotlin
button.stopLoading()
```

#### Check if loading indicator is shown

```kotlin
button.isLoading
```

### Styling
Basic styling can be done using the given properties. For further styling it is advised to use a custom `style`

Example (Material3):

```xml
<style name="ButtonStyle" parent="Widget.Material3.Button">
        <item name="android:textAllCaps">false</item>
        <item name="android:textColor">@color/white</item>
        <item name="backgroundTint">@null</item>
        <item name="android:background">@color/blue</item>
        <item name="cornerRadius">@dimen/radius_normal</item>
        <item name="elevation">0dp</item>
        <item name="android:height">50dp</item>
        <item name="android:letterSpacing">0</item>
    </style>
```

for Material2 `Widget.MaterialComponents.Button` can be used as `parent`

