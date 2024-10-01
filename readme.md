## Simple App or View Binding 
Simple is an only a simple app for the how to use view binding, simple app is a basic BMI calculator,

---
### View Binding

view binding is a way to get the id of the view or component for the perform the operation. this is the modern way to get views id and recommanded.

 #### how to enable view binding 
 goto the build.gradle(app.module) file and use this syntax. 

``` View Binding 

 buildFeatures {
        viewBinding = true
    }

```

----

## View Model

view model is a class in android architecture that manages UI-related data and survive configuration changes like screen rotation. it help seprate the app's logic from the UI, ensuring that data persists without being lost during such changes `like  screen rotate and close app`

#### view ` that means UI or frontend` like activity or fragments

#### Model `that means DATA or logic part` like as backend or logical part. 

```
UI(view) <-------> ViewModel <--------> Data(Model)
```
#### how to implements 
step 1: add dependency

step 2: create a viewmodel class and inherit the `ViewModel()` class

step 3: create a variable of viewmodel class, then initialized with `viewModelProvider()` class. 

------
## Live Data

Live Data is a special data holder (container) that Hold data, Live Data is a lifecycle aware data holder in android that updates the UI automatically when the underlying data changes `example - weather app, stopwatch`

live data is observ the model class and update the UI data.

```Live Data
UI <-------------> LiveData+ViewModel <------------>Model
```
