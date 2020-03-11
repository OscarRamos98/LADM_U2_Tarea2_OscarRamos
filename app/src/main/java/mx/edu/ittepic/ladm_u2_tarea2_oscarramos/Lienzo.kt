package mx.edu.ittepic.ladm_u2_tarea2_oscarramos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var puntero = p

    var circulo = FiguraGeometrica(200, 200, 30)
    var pausar = FiguraGeometrica(100, 600, 520, 100)
    var despausar = FiguraGeometrica(100,  720, 520,100)
    var reiniciar = FiguraGeometrica(100,  840, 520,100)
    var detener = FiguraGeometrica(100, 960, 520, 100)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.BLACK)

        paint.color = Color.WHITE
        circulo.pintar(canvas, paint)


        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        pausar.pintar(canvas, paint)


        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        despausar.pintar(canvas, paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        reiniciar.pintar(canvas, paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        detener.pintar(canvas, paint)

        paint.color = Color.BLACK

        paint.textSize = 80f

        canvas.drawText("PAUSAR",210f,680f,paint)

        canvas.drawText("DESPAUSAR",135f,795f,paint)

        canvas.drawText("REINICIAR",170f,920f,paint)

        canvas.drawText("DETENER",190f,1040f,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //REVISAMOS QUIEN ESTA EN AREA
                if (pausar.estaEnArea(event)) {
                    punteroFiguraGeometrica = pausar
                    puntero.setTitle("Pausado")
                    puntero.hiloControl!!.pausar()
                }
                if (despausar.estaEnArea(event)) {
                    punteroFiguraGeometrica = despausar
                    puntero.setTitle("Despausado")
                    puntero.hiloControl.despausar()
                }
                if (reiniciar.estaEnArea(event)) {
                    punteroFiguraGeometrica = reiniciar
                    puntero.setTitle("Reiniciado")

                    if (puntero.hiloControl.isAlive) {
                        circulo.mover(200, 200)
                    }
                }
                if (detener.estaEnArea(event)) {
                    punteroFiguraGeometrica = detener
                    puntero.setTitle("Detenido")
                    puntero.hiloControl.detener()
                }
            }


        }
        invalidate()
        return true
    }



    fun animarCirculo() {

        circulo.rebote(width, height/2)

        invalidate()
    }

}