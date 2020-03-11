package mx.edu.ittepic.ladm_u2_tarea2_oscarramos

class HiloControl (p:MainActivity):Thread() {
    var puntero = p
    private var iniciado = false

    private var pausa = false

    override fun run() {
        super.run()
        iniciado = true
        while (iniciado) {
            sleep(10)
            if (pausa == false) {
                puntero.runOnUiThread {
                    puntero.lienzo!!.animarCirculo()
                }
            }
        }

    }



    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}