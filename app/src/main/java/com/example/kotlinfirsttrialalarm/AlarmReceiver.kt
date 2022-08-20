
package com.example.kotlinfirsttrialalarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast

class AlarmReceiver :BroadcastReceiver()
{
    override fun onReceive(context: Context?,  intent: Intent?) {
        val vibrator = context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(3000)
        Toast.makeText(context,"Alarm ! Wake UP! GTFU!",Toast.LENGTH_LONG).show()

        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        if (alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        val ringtone = RingtoneManager.getRingtone(context,alarmUri)
        ringtone.play()
    }
}