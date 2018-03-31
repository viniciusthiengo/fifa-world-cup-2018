package thiengo.com.br.fifaworldcup2018

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.evernote.android.state.State
import kotlinx.android.synthetic.main.activity_main.*
import thiengo.com.br.fifaworldcup2018.data.Database
import thiengo.com.br.fifaworldcup2018.domain.Game
import java.util.*


class MainActivity : AppCompatActivity() {

    @State
    var games: ArrayList<Game>? = null

    //@State(BundlerListParcelable::class)
    //var games: List<Game>? = null

    /*@State(GameBundler::class)
    var game = Game(
            "H",
            Country("Colômbia", R.drawable.colombia),
            Country("Japão", R.drawable.japao),
            Date( Database.inMilliseconds(19,9,0) ),
            "Arena Mordovia"
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //StateSaver.restoreInstanceState(this, savedInstanceState)
        setContentView(R.layout.activity_main)

        if( games == null ){
            Log.i("LOG", "inside")
            games = Database.getGames()
        }

        //Log.i("LOG", "Game: ${game.countryA.name}")
        //game.countryA.name = "África do Sul"
    }

    override fun onStart() {
        super.onStart()

        rv_games.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        rv_games.layoutManager = layoutManager
        rv_games.adapter = GamesAdapter(this, games!!)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //StateSaver.saveInstanceState(this, outState!!)
    }
}
