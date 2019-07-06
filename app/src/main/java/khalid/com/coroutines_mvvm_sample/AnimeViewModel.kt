package khalid.com.coroutines_mvvm_sample

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by  on 7/6/2019.
 */
class AnimeViewModel : ViewModel() {
    var animeLiveData = MutableLiveData<List<Anime>>()
    private var animeRepository = AnimeRepository()
    //for liveData 2.2.0-alpha01
    var  anime= liveData(Dispatchers.IO) {
        //notice that we didn't need a callback
        val animes = animeRepository.getAnime()
        emit(animes)
    }
        //before livedata 2.2.0-alpha01
    fun loadAnime(){
            viewModelScope.launch {
                var animes : List<Anime>? = null
                withContext(Dispatchers.IO){
                    animes = animeRepository.getAnime()
                }
                animeLiveData.value = animes
            }
        }

}