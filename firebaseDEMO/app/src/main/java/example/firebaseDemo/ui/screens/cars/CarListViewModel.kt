package example.firebaseDemo.ui.screens.cars

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObjects
import com.google.firebase.ktx.Firebase
import example.firebaseDemo.domain.model.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CarListViewModel : ViewModel(){
    private var _carList = MutableStateFlow<List<Car>>(emptyList())
    var carList = _carList.asStateFlow()

    fun getCarList() {
        var db = Firebase.firestore

        db.collection("cars")
            .addSnapshotListener() { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }

                if (value != null) {
                    _carList.value = value.toObjects()
                }

            }
    }
}