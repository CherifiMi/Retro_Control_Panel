
<h1 align="center">Retro_Control_Panel</h1>

<p align="center">  
  This app is a retro style control panel.
</p>
</br>

<img width="2433" alt="FRAME" src="https://user-images.githubusercontent.com/98290339/152133459-b1f26d50-9b4e-4f2e-97ef-d4245334eeb5.png">


### It contains: 
  - Digital calender and clock using the [LocalDateTime.now()](https://developer.android.com/reference/java/time/LocalDateTime)
  - Custom Power progress bar
  - MapView for your location using the [MapBox Api](https://mapbox.com/)
  - Weather Data Using the [Open Weather Api](http://api.openweathermap.org/data/2.5/weather?q=london&APPID=be2793fc36a6181ecb9eb1166eb1253c)
  - Music player by [Media Plyer](https://developer.android.com/guide/topics/media/mediaplayer)
  - Applications Interface that opens another apps via the [PackageManager](https://developer.android.com/reference/android/content/pm/PackageManager) 


## Tech stack & Open-source libraries

- Minimum SDK level 27
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Architecture
    - MVVM Architecture (View - ViewBinding - ViewModel - Model)
    - Repository Pattern
- [Processing](https://android.processing.org/) for the [Matrix Screen](https://github.com/CherifiMi/Matrix_Screen) and the coustem progress bar
- [Material Ui](https://material.io/)
- [Retrofit](https://github.com/square/retrofit) the get the data from the api
- [Coroutines](https://developer.android.com/kotlin/coroutines) to handel the api requests
- [Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Coil](https://github.com/coil-kt/coil) for loading the food Maps Images from a url
- [View binding](https://developer.android.com/topic/libraries/view-binding) to bind data :)

## What I Learned:
- using the PackageManager to lunch another apps
- using the processing lib to make the background and the progress bar
- using the fragment container 
- using the geocoder to turn coordinators to a city name
- using the countdown fun to make the clock update
- using the mapBox api to make the stylized map
- using the media player

## final app

https://user-images.githubusercontent.com/98290339/151686173-4361824f-7c04-4b3f-8b65-224efe9bccf8.mp4

## Architecture
Retro_Control_Panel is based on the MVVM architecture and the Repository pattern.
![image](https://user-images.githubusercontent.com/98290339/152096381-2a8898d3-c351-4032-979d-ebc836e46332.png)

## Open Api

This app uses the [MapBox Api](https://mapbox.com/) to get the Map Image, and the [Open Weather Api](https://openweathermap.org/api) to get the coordination and the weather data


## Ui Made by [Figma](https://www.figma.com/file/mtCF10n9wphsv1JdKG00uQ/Ux-and-shi?node-id=166%3A720)

![image](https://user-images.githubusercontent.com/98290339/151686091-8f9e3b58-3563-42f6-8166-bb58a3c11a48.png)




