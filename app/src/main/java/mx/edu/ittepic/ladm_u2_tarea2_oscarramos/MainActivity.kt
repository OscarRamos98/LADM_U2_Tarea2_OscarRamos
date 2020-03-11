package mx.edu.ittepic.ladm_u2_tarea2_oscarramos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var lienzo  : Lienzo ?= null
    var hiloControl = HiloControl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)

        hiloControl!!.start()
    }
}

