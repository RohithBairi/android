MVP Design Pattern Example

In MVP the three classes are defined as follows:

The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.
The view is a passive interface that displays data (from the model) and routes user commands (events) to the presenter to act upon that data.
The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.

Creating the Model class and presenter  -> MainActivityPresenter.java

Presenter::
The methods of this class contain core business logic which will decide what to display and how to display. 
It triggers the View class to make the necessary changes to the UI.
Which returns view to the Main Activity (Attaching view and persenter)

View ::
The View class is responsible for updating the UI according to the changes triggered by the Presenter layer. 
The data provided by the Model will be used by View and the appropriate changes will be made in the activity. 

Advantages of MVP Architecture
No conceptual relationship in android components
Easy code maintenance and testing as the application’s model, view, and presenter layer are separated.

