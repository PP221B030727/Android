package com.example.week_5
import  android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.week_5.DataBase.Room.AppRoomDatabase
import com.example.week_5.DataBase.Room.repository.RoomRepository
import com.example.week_5.Utils.REPOSITORY
import com.example.week_5.Utils.TYPE_FIREBASE
import com.example.week_5.Utils.TYPE_ROOM
import com.example.week_5.model.Authorization
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(applictaion : Application) : AndroidViewModel(applictaion) {
//    val readTest:MutableLiveData<List<Authorization>> by lazy {
//        MutableLiveData< List<Authorization> >()
//    }
//    val dBtype : MutableLiveData<String> by lazy {
//        MutableLiveData<String>(TYPE_ROOM)
//    }
//    init {
//        readTest.value =
//            when(dBtype.value){
//                TYPE_ROOM->{
//                    listOf<Authorization>(
//                        Authorization(FullName = "Nursultan", email = "n_turugeldiev@kbtu.kz" , password = "1234"),
//                        Authorization(FullName = "Arman", email = "a_chakalov@kbtu.kz" , password = "1234"),
//                        Authorization(FullName = "Sultan", email = "s_sultanov@kbtu.kz" , password = "1234")
//                    )
//                }
//                TYPE_FIREBASE-> listOf()
//                else-> listOf()
//            }
//    }
    val context = applictaion


    fun initDatabase(type : String , onSuccess:()->Unit){
        Log.d("checkData","MainViewModel initDatabase is type $type")
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }

    }


    fun addAuthorization(auto : Authorization , onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.create(auto = auto){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun  readAllUsers() = REPOSITORY.readAll

}
class MainViewModelFactory(private  val applictaion: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel :: class.java)){
            return  MainViewModel(applictaion = applictaion) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}