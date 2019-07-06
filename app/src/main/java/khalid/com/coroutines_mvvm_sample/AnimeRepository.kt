package khalid.com.coroutines_mvvm_sample

import kotlinx.coroutines.delay

/**
 * Created by  on 7/6/2019.
 */
class AnimeRepository {
    private var noOfAnime = 0
    suspend fun getAnime() : List<Anime> {
        delay(5000)
        return listOf(
            Anime("Naruto", 5.0, 500),
            Anime("Boruto", 3.0, 150),
            Anime("Black clover", 5.0, 90),
            Anime("Attack on titans", 4.7, 53),
            Anime("One piece", 4.0, 1000),
            Anime("Full metal Alchemist", 4.0, 500),
            Anime("Hunter x hunter", 5.0, 500),
            Anime("Bleach", 5.0, 1000)

        )
    }
}