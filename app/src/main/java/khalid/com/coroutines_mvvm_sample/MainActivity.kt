package khalid.com.coroutines_mvvm_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import khalid.com.coroutines_mvvm_starter.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var animeViewModel: AnimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animeViewModel = ViewModelProviders.of(this).get(AnimeViewModel::class.java)

        animeViewModel.anime.observe(this, Observer {animes->
            //bind your views here
            progressBar.visibility = View.GONE
            textView.visibility = View.VISIBLE
            textView.text = animes.toString()
        })
    }
    
}
