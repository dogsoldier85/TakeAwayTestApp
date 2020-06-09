# TakeAwayTestApp

#### This repository contains a detailed sample app that :
- Written in Kotlin (100%)
- Offline mode - room
- MVVM architecture = Android Jetpack, Koin (DI), Retrofit2, Corutines etc.
- Additional lib: Glide, Timber
- Examples for UI and Unit testing

#### Project architecture :
![](https://github.com/dogsoldier85/NewsApp/blob/master/arc_impl.jpg)

#### To activate mock
1. Go to DI.kt file
2. Comment this line: single<INetworkHandler> { NetworkHandler() }
3. Uncomment this line: single<INetworkHandler> { MockNetworkHandler() }
4. Uninstall app and run it again  

### License
```
 Copyright 2013 Square, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
  
```
