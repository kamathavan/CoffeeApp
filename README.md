# CoffeeApp

This concept consists of structuring the App in 3 separate modules:
* **app**: Android module that contains the Android _Application_ component and all the framework specific configurations. It has visibility over all the other modules and defines the global dependency injection configurations.
* **domain**: Kotlin module that represents the _domain layer_. It contains _Use Cases_ (platform-independent business logic), the _Entities_ (platform-independent business models) and the _Repository interfaces_.
* **data**: Android module that represents the _data layer_. It contains _Repositories_ implementation, the data source _Api_ implementations and the corresponding api-specific models. 

## Screen Coffee of Application

The Screen shot flow is shown by the picture below:
<br> <br> <br>
<img src="screenshots/coffee_list.png" alt="Coffee list" style="width:250px;height:400px;">
<img src="screenshots/coffee_details.png"  style="width:250px;height:400px;">
<br>
