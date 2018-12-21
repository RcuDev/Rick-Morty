# Rick-Morty
Android application developed in Kotlin using Clean Architecture and Arch (Android Architecture Components)

<img src="https://pixel.nymag.com/imgs/daily/vulture/2018/06/07/magazine/rick-and-morty/lede.w700.h467.jpg">

**Features**

- Character List: OK
- Character Detail: IN PROGRESS
- Splash Screen: PENDING
- Local data with Room: PENDING
- Searcher: PENDING

Possible future feature is the creation of a custom error screen for handling exceptions.

---

## Architecture

I have used Clean architecture following the great work done by Fernando Cejas (<a>https://fernandocejas.com/</a>).

Clean architecture manages to uncouple, in a simple and effective way, each module and functionality of the application, allowing a better maintainability and respecting the SOLID principles.

---

## Android Architecture Components

* **ViewModel**: The ViewModel class is designed to store and manage UI-related data in lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
* **LiveData**: LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.
* **Navigation**: Navigation handles navigating between your app's destinations--that is, anywhere in your app to which users can navigate. While destinations are usually Fragments representing specific screens, the Navigation Architecture Component supports the other destination types listed below:
  - Activities
  - Navigation graphs and subgraphs - when the destination is a graph or subgraph, users navigate to the start destination of that graph or subgraph
  - Custom destination types

  These destinations are connected via actions, and a set of destinations and connecting actions comprise an app's navigation graph. 
* **Room**: The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

  The library helps you create a cache of your app's data on a device that's running your app. This cache, which serves as your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of whether users have an internet connection.
  
## Other characteristics of the project

* Kotlin coroutines in its stable version to perform asynchronous tasks.
* Dagger for dependency injection.
* Retrofit with Okhttp3 for api calls.
* Glide to load images from network.
