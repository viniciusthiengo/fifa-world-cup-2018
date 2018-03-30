package thiengo.com.br.fifaworldcup2018

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.evernote.android.state.State
import kotlinx.android.synthetic.main.activity_main.*
import thiengo.com.br.fifaworldcup2018.data.Database
import thiengo.com.br.fifaworldcup2018.domain.Game

class MainActivity : AppCompatActivity() {

    @State
    var games: ArrayList<Game>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if( games == null ){
            Log.i("LOG", "inside")
            games = Database.getGames()
        }
    }

    override fun onStart() {
        super.onStart()

        rv_games.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        rv_games.layoutManager = layoutManager
        rv_games.adapter = GamesAdapter(this, games!!)
    }
}
