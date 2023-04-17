package com.example.week_5
import  android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.week_5.DataBase.Room.AppRoomDatabase
import com.example.week_5.DataBase.Room.AppRoomDatabaseBook
import com.example.week_5.DataBase.Room.repository.RoomRepository
import com.example.week_5.Utils.REPOSITORY
import com.example.week_5.Utils.TYPE_ROOM
import com.example.week_5.model.Authorization
import com.example.week_5.model.book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(applictaion : Application) : AndroidViewModel(applictaion) {
    val context = applictaion
    fun initDatabase(type : String , onSuccess:()->Unit){
        Log.d("checkData","MainViewModel initDatabase is type $type")
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                val daoBook = AppRoomDatabaseBook.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao , daoBook)
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
    fun addBook(bok : book , onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.createBook(bok = bok){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
    fun deleteUsers(auto : Authorization , onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(auto = auto){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }

    }
    fun deleteBooks(bok : book , onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.deleteBook(bok = bok){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }

    }



    fun  readAllUsers() = REPOSITORY.readAll

    fun readAllBooks() = REPOSITORY.readAllBook


    fun updateBook(bok : book , onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.updateBook(bok = bok){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun getAllAscBooks() = REPOSITORY.readAllBookAsc
    fun getAllDscBooks() = REPOSITORY.readAllBooksDSC
}
class MainViewModelFactory(private  val applictaion: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel :: class.java)){
            return  MainViewModel(applictaion = applictaion) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}